package com.projectname.e2e.tests.suites.projects;

import com.projectname.api.client.utils.helpers.RandomDataGenerator;
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
import org.xbill.DNS.Update;

import java.util.Random;

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
        updateProjectRequest.setTitle("updated title");
        projectDetailsPage.updateProject(updateProjectRequest);
        ProjectDetails updatedProjectDetails = projectDetailsPage.getActualProjectDetails();


        CreateTechnologyRequest createTechnologyRequest = new CreateTechnologyRequest();
        createTechnologyRequest.setTitle("technology " + RandomDataGenerator.createRandomStringAlphabeticWithLen(5));
        projectDetailsPage.createTechnology(createTechnologyRequest);

        CreateSeniorityRequest createSeniorityRequest = new CreateSeniorityRequest();
        createSeniorityRequest.setTitle("seniority " + RandomDataGenerator.createRandomStringAlphabeticWithLen(5));
        projectDetailsPage.createSeniority(createSeniorityRequest);

        CreateTeamRequest createTeamRequest = new CreateTeamRequest();
        createTeamRequest.setTitle("team " + RandomDataGenerator.createRandomStringAlphabeticWithLen(5));
        projectDetailsPage.createTeam(createTeamRequest);

        CreatePersonRequest createPersonRequest = new CreatePersonRequest();
        createPersonRequest.setName("person " + RandomDataGenerator.createRandomStringAlphabeticWithLen(5));
        projectDetailsPage.createPerson(createPersonRequest);

        projectDetailsPage.assignPersonToProject();

        projectDetailsPage.navigateBackToProjectsPage();



    }
}
