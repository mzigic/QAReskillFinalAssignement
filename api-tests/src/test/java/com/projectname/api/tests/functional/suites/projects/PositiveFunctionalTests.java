package com.projectname.api.tests.functional.suites.projects;

import com.projectname.api.client.calls.*;
import com.projectname.api.client.data.model.people.create.CreatePersonRequest;
import com.projectname.api.client.data.model.people.create.CreatePersonResponse;
import com.projectname.api.client.data.model.projects.create.CreateProjectRequest;
import com.projectname.api.client.data.model.projects.create.CreateProjectResponse;
import com.projectname.api.client.data.model.projects.list.ListProjectsResponse;
import com.projectname.api.client.data.model.projects.update.AssignPersonRequest;
import com.projectname.api.client.data.model.projects.update.UpdateProjectRequest;
import com.projectname.api.client.data.model.projects.update.UpdateProjectResponse;
import com.projectname.api.client.data.model.seniority.CreateSeniorityRequest;
import com.projectname.api.client.data.model.seniority.CreateSeniorityResponse;
import com.projectname.api.client.data.model.team.CreateTeamRequest;
import com.projectname.api.client.data.model.team.CreateTeamResponse;
import com.projectname.api.client.data.model.technology.create.CreateTechnologyRequest;
import com.projectname.api.client.data.model.technology.create.CreateTechnologyResponse;
import com.projectname.api.client.data.model.technology.list.ListTechnologyResponse;
import com.projectname.api.client.data.model.technology.update.UpdateTechnologyRequest;
import com.projectname.api.client.data.model.technology.update.UpdateTechnologyResponse;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.data.provider.ProjectProvider;
import com.projectname.api.tests.data.provider.TechnologyProvider;
import com.projectname.api.tests.functional.asserts.PersonAssert;
import com.projectname.api.tests.functional.asserts.ProjectAssert;
import com.projectname.api.tests.functional.asserts.TechnologyAssert;
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
        for (CreatePersonResponse personResponse : createPersonResponse) {
            if (personResponse.getName().equals(createPersonRequest.getName())) {
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

    @Test(dataProvider = DataProviderNames.VERIFY_CREATE_TECHNOLOGY, dataProviderClass = TechnologyProvider.class)
    @Description("Verify can create technology")
    public static void verifyCreateTechnologyWithDataProvider(String methodNameSuffix, CreateTechnologyRequest createTechnologyRequest) {

        CreateTechnologyResponse[] createdTechnologyList = TechnologyAPI.createTechnology(token, createTechnologyRequest);

        CreateTechnologyResponse createdTechnologyExpected = CreateTechnologyResponse.parseCreatedTechnology(createTechnologyRequest);

        CreateTechnologyResponse createdTechnologyActual = null;
        for (CreateTechnologyResponse technologyResponse : createdTechnologyList) {
            if (technologyResponse.getTitle().equals(createTechnologyRequest.getTitle())) {
                createdTechnologyActual = technologyResponse;
                break;
            }
        }
        TechnologyAssert technologyAssert = new TechnologyAssert();
        technologyAssert.assertCreatedTechnology(createdTechnologyActual, createdTechnologyExpected);

        ListTechnologyResponse[] technologies = TechnologyAPI.getTechnologies(token);
        technologyAssert.assertTechnologyInList(technologies, createdTechnologyActual.getId());

        TechnologyAPI.deleteTechnology(token, createdTechnologyActual.getId());
    }

    @Test
    @Description("Verify can update technology")
    public static void verifyCanUpdateTechnology() {
        CreateTechnologyRequest createTechnologyRequest = new CreateTechnologyRequest("Technology1");

        CreateTechnologyResponse[] createTechnologyResponse = TechnologyAPI.createTechnology(token, createTechnologyRequest);
        CreateTechnologyResponse createdTechnologyActual = null;
        for (CreateTechnologyResponse technologyResponse : createTechnologyResponse) {
            if (technologyResponse.getTitle().equals(createTechnologyRequest.getTitle())) {
                createdTechnologyActual = technologyResponse;
                break;
            }
        }

        UpdateTechnologyRequest updateTechnologyRequest = new UpdateTechnologyRequest("Updated technology title");

        UpdateTechnologyResponse[] updatedTechnologyList = TechnologyAPI.updateTechnology(token, updateTechnologyRequest, createdTechnologyActual.getId());
        UpdateTechnologyResponse updatedTechnologyActual = null;
        for (UpdateTechnologyResponse technologyResponse : updatedTechnologyList) {
            if (technologyResponse.getTitle().equals(updateTechnologyRequest.getTitle())) {
                updatedTechnologyActual = technologyResponse;
                break;
            }
        }

        UpdateTechnologyResponse updatedTechnologyExpected = UpdateTechnologyResponse.parseUpdatedTechnology(updateTechnologyRequest);

        TechnologyAssert technologyAssert = new TechnologyAssert();

        technologyAssert.assertUpdatedTechnologyTitle(updatedTechnologyActual, updatedTechnologyExpected);

        TechnologyAPI.deleteTechnology(token, createdTechnologyActual.getId());
    }

    @Test
    @Description("Verify can create person")
    public static void verifyCanCreatePerson() {
        //creating technology
        CreateTechnologyRequest createTechnologyRequest = new CreateTechnologyRequest("Technology1");

        CreateTechnologyResponse[] createTechnologyResponse = TechnologyAPI.createTechnology(token, createTechnologyRequest);
        //creating seniority
        CreateSeniorityRequest createSeniorityRequest = new CreateSeniorityRequest("Seniority1");

        CreateSeniorityResponse[] createSeniorityResponse = SeniorityAPI.createSeniority(token, createSeniorityRequest);
        CreateSeniorityResponse createdSeniorityActual = null;
        for (CreateSeniorityResponse seniorityResponse : createSeniorityResponse) {
            if (seniorityResponse.getTitle().equals(createSeniorityRequest.getTitle())) {
                createdSeniorityActual = seniorityResponse;
                break;
            }
        }
        //creating team
        CreateTeamRequest createTeamRequest = new CreateTeamRequest("Team1");

        CreateTeamResponse[] createTeamResponse = TeamAPI.createTeam(token, createTeamRequest);
        CreateTeamResponse createdTeamActual = null;
        for (CreateTeamResponse teamResponse : createTeamResponse) {
            if (teamResponse.getTitle().equals(createTeamRequest.getTitle())) {
                createdTeamActual = teamResponse;
                break;
            }
        }
        //creating person
        CreatePersonRequest createPersonRequest = new CreatePersonRequest("Person1", createTechnologyResponse, createdSeniorityActual, createdTeamActual);
        CreatePersonResponse[] createPersonResponse = PeopleAPI.createPerson(token, createPersonRequest);
        CreatePersonResponse createdPersonActual = null;
        for (CreatePersonResponse personResponse : createPersonResponse) {
            if (personResponse.getName().equals(createPersonRequest.getName())) {
                createdPersonActual = personResponse;
                break;
            }
        }
        CreatePersonResponse createdPersonExpected = CreatePersonResponse.parseCreatedPerson(createPersonRequest);

        PersonAssert personAssert = new PersonAssert();
        personAssert.assertCreatedPerson(createdPersonActual, createdPersonExpected);

        TechnologyAPI.deleteTechnology(token, createTechnologyResponse[0].getId());
        SeniorityAPI.deleteTSeniority(token, createdSeniorityActual.getId());

        PeopleAPI.deletePerson(token, createdPersonActual.getId());
        TeamAPI.deleteTeam(token, createdTeamActual.getId());
    }
}
