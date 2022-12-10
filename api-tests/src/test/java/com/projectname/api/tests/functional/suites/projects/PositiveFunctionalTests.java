package com.projectname.api.tests.functional.suites.projects;

import com.projectname.api.client.calls.ProjectsAPI;
import com.projectname.api.client.data.model.projects.create.CreateProjectRequest;
import com.projectname.api.client.data.model.projects.create.CreateProjectResponse;
import com.projectname.api.client.data.model.projects.list.ListProjectsResponse;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.data.provider.ProjectProvider;
import com.projectname.api.tests.functional.asserts.ProjectAssert;
import com.projectname.api.tests.init.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

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
}
