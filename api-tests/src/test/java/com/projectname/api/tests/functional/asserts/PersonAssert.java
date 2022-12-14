package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.people.create.CreatePersonResponse;
import com.projectname.api.client.data.model.people.update.UpdatePersonResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

public class PersonAssert {
    private SoftAssert softAssert;

    public PersonAssert() {
        this.softAssert = new SoftAssert();
    }

    public void assertCreatedPerson(CreatePersonResponse actualResponse, CreatePersonResponse expectedResponse) {
        if (actualResponse == null) {
            Assert.fail("Person was not created");
        }
        softAssert.assertEquals(actualResponse.getName(), expectedResponse.getName(), "Person name didn't match");
        softAssert.assertEquals(actualResponse.getTeam().getId(), expectedResponse.getTeam().getId(), "Team didn't match");
        softAssert.assertEquals(actualResponse.getSeniority().getId(), expectedResponse.getSeniority().getId(), "Seniority didn't match");
        softAssert.assertEquals(actualResponse.getTechnologies()[0].getId(), expectedResponse.getTechnologies()[0].getId(), "Technologies didn't match");
        this.softAssert.assertAll();
    }

    public void assertUpdatedPerson(UpdatePersonResponse actualResponse, UpdatePersonResponse expectedResponse) {
        if (actualResponse == null) {
            Assert.fail("Person was not created");
        }
        softAssert.assertEquals(actualResponse.getName(), expectedResponse.getName(), "Person name didn't match");
        this.softAssert.assertAll();
        softAssert.assertEquals(actualResponse.getTeam().getId(), expectedResponse.getTeam().getId(), "Team didn't match");
        softAssert.assertEquals(actualResponse.getSeniority().getId(), expectedResponse.getSeniority().getId(), "Seniority didn't match");
        softAssert.assertEquals(actualResponse.getTechnologies()[0].getId(), expectedResponse.getTechnologies()[0].getId(), "Technologies didn't match");
        this.softAssert.assertAll();
    }

    public void assertPersonNotInList(CreatePersonResponse[] actualResponse, Integer personId) {
        boolean personFound = false;
        for (CreatePersonResponse person : actualResponse) {
            if (Objects.equals(person.getId(), personId)) {
                personFound = true;
                break;
            }
        }
        if (personFound) {
            Assert.fail("Person not deleted!");
        }
    }
}
