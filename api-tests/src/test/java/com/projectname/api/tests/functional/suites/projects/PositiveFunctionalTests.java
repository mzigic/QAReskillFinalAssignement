package com.projectname.api.tests.functional.suites.projects;

import com.projectname.api.client.calls.PeopleAPI;
import com.projectname.api.client.calls.ProjectsAPI;
import com.projectname.api.client.data.model.people.Person;
import com.projectname.api.client.data.model.people.create.CreatePersonRequest;
import com.projectname.api.client.data.model.people.create.CreatePersonResponse;
import com.projectname.api.client.data.model.projects.create.CreateProjectRequest;
import com.projectname.api.client.data.model.projects.create.CreateProjectResponse;
import com.projectname.api.client.data.model.projects.list.ListProjectsResponse;
import com.projectname.api.client.data.model.projects.update.AssignPersonRequest;
import com.projectname.api.client.data.model.projects.update.UpdateProjectRequest;
import com.projectname.api.client.data.model.projects.update.UpdateProjectResponse;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.data.provider.ProjectProvider;
import com.projectname.api.tests.functional.asserts.ProjectAssert;
import com.projectname.api.tests.init.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.List;

public class PositiveFunctionalTests extends TestBase {
    @Test(dataProvider = DataProviderNames.VERIFY_CREATE_PROJECT, dataProviderClass = ProjectProvider.class)
    @Description("Verify can create project")
    public static void verifyCreateProjectWithDataProvider(String methodNameSuffix, CreateProjectRequest createProjectRequest) {

        CreateProjectResponse createdProjectActual = ProjectsAPI.createProject(token, createProjectRequest);

        CreateProjectResponse createdProjectExpected = CreateProjectResponse.parseCreatedProject(createProjectRequest);

        ProjectAssert projectAssert = new ProjectAssert();
        projectAssert.assertCreatedProject(createdProjectActual, createdProjectExpected);

        ListProjectsResponse[] projects = ProjectsAPI.getProjects(token);
        projectAssert.assertProjectInList(projects, createdProjectActual.getId());

        ProjectsAPI.deleteProject(token, createdProjectActual.getId());
    }

    @Test
    @Description("Verify can update project")
    public static void verifyCanUpdateProject() {
        CreateProjectRequest createProjectRequest = new CreateProjectRequest("Title1");

        CreateProjectResponse createdProjectActual = ProjectsAPI.createProject(token, createProjectRequest);

        CreatePersonRequest createPersonRequest = new CreatePersonRequest();
        createPersonRequest.setName("PersonToAssign");

        CreatePersonResponse[] createPersonResponse = PeopleAPI.createPerson(token, createPersonRequest);
        CreatePersonResponse person = null;
        for(CreatePersonResponse personResponse : createPersonResponse) {
            if(personResponse.getName().equals(createPersonRequest.getName())) {
                person = personResponse;
                break;
            }
        }

        UpdateProjectRequest updateProjectRequest = new UpdateProjectRequest(
                "Updated title", List.of(new AssignPersonRequest(person.getId(), person.getName())), createdProjectActual.getId());

        UpdateProjectResponse updatedProjectActual = ProjectsAPI.updateProject(token, updateProjectRequest, createdProjectActual.getId());

        UpdateProjectResponse updatedProjectExpected = UpdateProjectResponse.parseUpdatedProject(updateProjectRequest);

        ProjectAssert projectAssert = new ProjectAssert();

        projectAssert.assertUpdatedProjectTitle(updatedProjectActual, updatedProjectExpected);
        projectAssert.assertPersonAssigned(updatedProjectActual, person.getId());

        PeopleAPI.deletePerson(token, person.getId());
        ProjectsAPI.deleteProject(token, createdProjectActual.getId());
    }
}