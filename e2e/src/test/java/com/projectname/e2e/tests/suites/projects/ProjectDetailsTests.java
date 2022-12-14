package com.projectname.e2e.tests.suites.projects;

import com.projectname.api.client.utils.helpers.RandomDataGenerator;
import com.projectname.e2e.tests.asserts.ProjectsAssert;
import com.projectname.e2e.tests.data.model.projects.*;
import com.projectname.e2e.tests.data.provider.projects.ProjectProvider;
import com.projectname.e2e.tests.environment.ConfigSetup;
import com.projectname.e2e.tests.pages.DashboardPage;
import com.projectname.e2e.tests.pages.LoginPage;
import com.projectname.e2e.tests.pages.projects.CreateProjectPage;
import com.projectname.e2e.tests.pages.projects.ProjectDetailsPage;
import com.projectname.e2e.tests.pages.projects.ProjectsPage;
import com.projectname.e2e.tests.suites.common.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectDetailsTests extends TestBase {
    @BeforeClass
    public void setup() {
        LoginPage loginPage = new LoginPage(getDriver(), "", ConfigSetup.getUser(), ConfigSetup.getUserPsw());
        loginPage.show();
        DashboardPage dashboardPage = loginPage.login(ConfigSetup.getUser(), ConfigSetup.getUserPsw());
        dashboardPage.openProjectsPage();
    }

    @Test
    public void verifyCanUpdateProject() {
        ProjectsPage projectsPage = new ProjectsPage(getDriver(), "", "", "");
        projectsPage.openCreateProjectPage();

        CreateProjectPage createProjectPage = new CreateProjectPage(getDriver(), "", "", "");

        CreateProjectRequest createProjectRequest = ProjectProvider.prepareCreateProjectRequest();
        createProjectPage.createNewProject(createProjectRequest);

        ProjectDetailsPage projectDetailsPage = new ProjectDetailsPage(getDriver(), "", "", "");

        UpdateProjectRequest updateProjectRequest = new UpdateProjectRequest();
        updateProjectRequest.setTitle("edit");
        projectDetailsPage.updateProject(updateProjectRequest);
        ProjectDetails updatedProjectDetails = projectDetailsPage.getActualProjectDetails();

        String technologyTitle = "technology " + RandomDataGenerator.createRandomStringAlphabeticWithLen(2);
        CreateTechnologyRequest createTechnologyRequest = new CreateTechnologyRequest();
        createTechnologyRequest.setTitle(technologyTitle);
        projectDetailsPage.createTechnology(createTechnologyRequest);

        String seniorityTitle = "seniority " + RandomDataGenerator.createRandomStringAlphabeticWithLen(2);
        CreateSeniorityRequest createSeniorityRequest = new CreateSeniorityRequest();
        createSeniorityRequest.setTitle(seniorityTitle);
        projectDetailsPage.createSeniority(createSeniorityRequest);

        String teamTitle = "team " + RandomDataGenerator.createRandomStringAlphabeticWithLen(2);
        CreateTeamRequest createTeamRequest = new CreateTeamRequest();
        createTeamRequest.setTitle(teamTitle);
        projectDetailsPage.createTeam(createTeamRequest);

        String personName = "person " + RandomDataGenerator.createRandomStringAlphabeticWithLen(2);
        CreatePersonRequest createPersonRequest = new CreatePersonRequest();
        createPersonRequest.setName(personName);
        projectDetailsPage.createPerson(createPersonRequest);

        projectDetailsPage.assignPersonToProject();

        projectDetailsPage.navigateBackToProjectsPage();

        ProjectsAssert projectsAssert = new ProjectsAssert();
        ProjectDetails projectCardTitle = projectsPage.getProjectCardTitle(updatedProjectDetails.getTitle());
        projectsAssert.assertCreatedProjectCard(projectCardTitle, updatedProjectDetails);

        projectsPage.openProjectPreview();

        ProjectDetails projectDetails = projectsPage.getProjectPreview();
        projectsAssert.assertProjectPreviewDetails(projectDetails, updatedProjectDetails.getTitle(), teamTitle, personName, seniorityTitle, technologyTitle);

        projectsPage.openProjectDetails(updatedProjectDetails.getTitle());
    }
}
