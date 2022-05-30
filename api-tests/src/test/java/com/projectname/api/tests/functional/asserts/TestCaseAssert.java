package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.sandbox.common.TestCaseStep;
import com.projectname.api.client.data.model.sandbox.testcase.GetTestCaseByIdErrorResponse;
import com.projectname.api.client.data.model.sandbox.testcase.TestCaseResponse;
import com.projectname.api.tests.constants.ErrorMessages;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TestCaseAssert {

    private SoftAssert softAssert;

    public TestCaseAssert() {
    }

    // soft assert that do complete check and then log all errors found in test case
    public void assertCreatedTestCase(TestCaseResponse expectedResponse, TestCaseResponse actualResponse){
        if(actualResponse == null){
            Assert.fail("Test case not created");
        }
        this.softAssert = new SoftAssert();
        softAssert.assertEquals(actualResponse.getTitle(), expectedResponse.getTitle(), "title doesn't match");
        softAssert.assertEquals(actualResponse.getExpectedResult(), expectedResponse.getExpectedResult(), "expected result doesn't match");
        softAssert.assertEquals(actualResponse.getAutomated(), expectedResponse.getAutomated(), "automated doesn't match");
        softAssert.assertEquals(actualResponse.getDescription(), expectedResponse.getDescription(), "description doesn't match");

        for (TestCaseStep actualTestCaseStep: actualResponse.getTestSteps()) {
            TestCaseStep expectedTestCaseStep = expectedResponse.getTestSteps().get(actualResponse.getTestSteps().indexOf(actualTestCaseStep));
            softAssert.assertEquals(actualTestCaseStep.getValue(), expectedTestCaseStep.getValue(), "step value doesn't match");
        }

        this.softAssert.assertAll();
    }

    public void assertTestCaseWithInvalidIdResponse(GetTestCaseByIdErrorResponse invalidResponse){
        if(invalidResponse == null){
            Assert.fail("Error response for test case with invalid id not returned");
        }

        this.softAssert = new SoftAssert();
        softAssert.assertEquals(invalidResponse.getError(), ErrorMessages.TEST_CASE_NOT_FOUND_MSG);
        this.softAssert.assertAll();
    }
}
