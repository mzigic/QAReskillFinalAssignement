package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.sandbox.testcase.TestCaseCreateErrorResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TestCaseErrorAssert {
    private SoftAssert softAssert;

    public TestCaseErrorAssert() {
    }

    public void assertTestCaseCreateErrorResponse(TestCaseCreateErrorResponse actualResponse, TestCaseCreateErrorResponse expectedResponse) {
        if(actualResponse == null){
            Assert.fail("Response is null");
        }
        this.softAssert = new SoftAssert();

        if(expectedResponse.getTitleRequiredMsg() != null){
            softAssert.assertEquals(actualResponse.getTitleRequiredMsg(),
                    expectedResponse.getTitleRequiredMsg(),
                    "title didn't match in error response");
        }

        if(expectedResponse.getExpectedResultRequiredMsg() != null){
            softAssert.assertEquals(actualResponse.getExpectedResultRequiredMsg(),
                    expectedResponse.getExpectedResultRequiredMsg(),
                    "expected result didn't match in error response");
        }

        if(expectedResponse.getTestStepsRequiredMsg() != null){
            softAssert.assertEquals(actualResponse.getTestStepsRequiredMsg(),
                    expectedResponse.getTestStepsRequiredMsg(),
                    "test cases didn't match in error response");
        }

        this.softAssert.assertAll();
    }
}
