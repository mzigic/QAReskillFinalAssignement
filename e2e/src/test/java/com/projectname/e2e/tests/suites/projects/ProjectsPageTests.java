package com.projectname.e2e.tests.suites.projects;

import com.projectname.e2e.tests.asserts.ProjectsAssert;
import com.projectname.e2e.tests.data.model.projects.CreateProjectRequest;
import com.projectname.e2e.tests.data.model.projects.ProjectDetails;
import com.projectname.e2e.tests.data.provider.projects.ProjectProvider;
import com.projectname.e2e.tests.environment.ConfigSetup;
import com.projectname.e2e.tests.pages.DashboardPage;
import com.projectname.e2e.tests.pages.LoginPage;
import com.projectname.e2e.tests.pages.projects.CreateProjectPage;
import com.projectname.e2e.tests.pages.projects.ProjectDetailsPage;
import com.projectname.e2e.tests.pages.projects.ProjectsPage;
import com.projectname.e2e.tests.suites.common.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectsPageTests extends TestBase {
    @BeforeClass
    public void setup() {
        LoginPage loginPage = new LoginPage(getDriver(), "", ConfigSetup.getUser(), ConfigSetup.getUserPsw());
        loginPage.show();
        DashboardPage dashboardPage = loginPage.login(ConfigSetup.getUser(), ConfigSetup.getUserPsw());
        dashboardPage.openProjectsPage();
    }

    @Test
    public void verifyProjectIsCreated() {
        ProjectsPage projectsPage = new ProjectsPage(getDriver(), "", "", "");
        projectsPage.openCreateProjectPage();

        CreateProjectPage createProjectPage = new CreateProjectPage(getDriver(), "", "", "");

        CreateProjectRequest createProjectRequest = ProjectProvider.prepareCreateProjectRequest();
        createProjectPage.createNewProject(createProjectRequest);

        ProjectDetailsPage projectDetailsPage = new ProjectDetailsPage(getDriver(), "", "", "");
        ProjectDetails projectDetails = new ProjectDetails();

        ProjectDetails actualProjectDetails = projectDetailsPage.getActualProjectDetails();
        ProjectDetails expectedProjectDetails = projectDetails.parseExpectedDetails(createProjectRequest);

        ProjectsAssert projectsAssert = new ProjectsAssert();

        projectsAssert.assertProjectCreated(actualProjectDetails, expectedProjectDetails);

        projectDetailsPage.navigateBackToProjectsPage();

        ProjectDetails projectCardTitle = projectsPage.getProjectCardTitle(actualProjectDetails.getTitle());
        projectsAssert.assertCreatedProjectCard(projectCardTitle, expectedProjectDetails);

        projectsPage.openProjectDetails(actualProjectDetails.getTitle());
        projectDetailsPage.removeProject();
        projectDetailsPage.confirmRemoveProject();

//      need to figure out how to assert if element doesn't exist
//        boolean projectCardExists = projectsPage.projectCardExists(actualProjectDetails.getTitle());
//
//        Assert.assertFalse(projectCardExists, "Project is not deleted");
    }

    @Test
    public void verifyCannotCreateProjectWithoutTitle() {
        ProjectsPage projectsPage = new ProjectsPage(getDriver(), "", "", "");
        projectsPage.openCreateProjectPage();

        CreateProjectPage createProjectPage = new CreateProjectPage(getDriver(), "", "", "");

        CreateProjectRequest createProjectRequest = new CreateProjectRequest();
        createProjectRequest.setTitle("");
        createProjectPage.createNewProject(createProjectRequest);

        String expectedMessage = "Title is required";
        String actualMessage = createProjectPage.getTitleErrorMessage();

        Assert.assertEquals(expectedMessage, actualMessage, "Title error message didn't match");
    }
}
