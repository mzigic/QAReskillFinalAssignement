package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.people.create.CreatePersonResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class PersonAssert {
    private SoftAssert softAssert;

    public PersonAssert() {
        this.softAssert = new SoftAssert();
    }

    public void assertCreatedPerson(CreatePersonResponse actualResponse, CreatePersonResponse expectedResponse) {
        if (actualResponse == null) {
            Assert.fail("Person was not created");
        }
        softAssert.assertEquals(actualResponse.getName(), expectedResponse.getName(), "Person didn't match");
        softAssert.assertEquals(actualResponse.getTeam().getId(), expectedResponse.getTeam().getId(), "Team didn't match");
        softAssert.assertEquals(actualResponse.getSeniority().getId(), expectedResponse.getSeniority().getId(), "Seniority didn't match");
        softAssert.assertEquals(actualResponse.getTechnologies()[0].getId(), expectedResponse.getTechnologies()[0].getId(), "Technologies didn't match");
        this.softAssert.assertAll();
    }
}
