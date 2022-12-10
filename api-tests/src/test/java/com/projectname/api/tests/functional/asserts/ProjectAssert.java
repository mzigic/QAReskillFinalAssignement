package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.people.Person;
import com.projectname.api.client.data.model.projects.create.CreateProjectResponse;
import com.projectname.api.client.data.model.projects.list.ListProjectsResponse;
import com.projectname.api.client.data.model.projects.update.UpdateProjectResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

public class ProjectAssert {
    private SoftAssert softAssert;

    public ProjectAssert() {
        this.softAssert = new SoftAssert();
    }

    // soft assert that do complete check and then log all errors found in test case
    public void assertCreatedProject(CreateProjectResponse actualResponse, CreateProjectResponse expectedResponse) {
        if (actualResponse == null) {
            Assert.fail("Project was not created");
        }
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "Project didn't match");
        this.softAssert.assertAll();
    }

    public void assertProjectInList(ListProjectsResponse[] actualResponse, Integer projectId) {
        boolean projectFound = false;
        for (ListProjectsResponse project : actualResponse) {
            if (Objects.equals(project.getId(), projectId)) {
                projectFound = true;
                break;
            }
        }
        if (!projectFound) {
            Assert.fail("Project not created!");
        }
    }

    public void assertUpdatedProjectTitle(UpdateProjectResponse actualResponse, UpdateProjectResponse expectedResponse) {
        if (actualResponse == null) {
            Assert.fail("Project was not created");
        }
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "Title didn't match");
        this.softAssert.assertAll();
    }

    public void assertPersonAssigned(UpdateProjectResponse actualResponse, Integer personId) {
        boolean personFound = false;
        for (Person person : actualResponse.getTeams().get(0).getPeople()) {
            if (Objects.equals(person.getId(), personId)) {
                personFound = true;
                break;
            }
        }
        if (!personFound) {
            Assert.fail("Person not assigned!");
        }
    }
}
