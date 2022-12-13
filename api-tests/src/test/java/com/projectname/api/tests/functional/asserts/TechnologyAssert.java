package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.technology.create.CreateTechnologyResponse;
import com.projectname.api.client.data.model.technology.list.ListTechnologyResponse;
import com.projectname.api.client.data.model.technology.update.UpdateTechnologyResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

public class TechnologyAssert {
    private SoftAssert softAssert;

    public TechnologyAssert() {
        this.softAssert = new SoftAssert();
    }

    public void assertCreatedTechnology(CreateTechnologyResponse actualResponse, CreateTechnologyResponse expectedResponse) {
        if (actualResponse == null) {
            Assert.fail("Technology was not created");
        }
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "Technology didn't match");
        this.softAssert.assertAll();
    }

    public void assertTechnologyInList(ListTechnologyResponse[] actualResponse, Integer technologyId) {
        boolean technologyFound = false;
        for (ListTechnologyResponse project : actualResponse) {
            if (Objects.equals(project.getId(), technologyId)) {
                technologyFound = true;
                break;
            }
        }
        if (!technologyFound) {
            Assert.fail("Technology not created!");
        }
    }

    public void assertUpdatedTechnologyTitle(UpdateTechnologyResponse actualResponse, UpdateTechnologyResponse expectedResponse) {
        if (actualResponse == null) {
            Assert.fail("Technology was not created");
        }
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "Title didn't match");
        this.softAssert.assertAll();
    }
}
