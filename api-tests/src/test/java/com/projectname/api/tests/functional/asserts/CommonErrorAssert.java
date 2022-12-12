package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.projects.create.CreateProjectErrorResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CommonErrorAssert {
    private SoftAssert softAssert;

    public CommonErrorAssert() {
        this.softAssert = new SoftAssert();
    }

    public void assertRequiredFieldError(CreateProjectErrorResponse actualError, CreateProjectErrorResponse expectedError) {
        if (actualError == null) {
            Assert.fail("Actual error is null!");
        }
        if (actualError.getTitle() != null) {
            this.softAssert.assertEquals(
                    actualError.getTitle(), expectedError.getTitle(), "Title error didn't match!");
        }
        this.softAssert.assertAll();
    }
}
