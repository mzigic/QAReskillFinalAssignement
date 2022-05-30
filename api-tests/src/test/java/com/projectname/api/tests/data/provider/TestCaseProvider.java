package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.sandbox.testcase.TestCaseCreateErrorResponse;
import com.projectname.api.client.data.model.sandbox.testcase.TestCaseCreateRequest;
import com.projectname.api.client.data.model.sandbox.common.TestCaseStep;
import com.projectname.api.client.utils.helpers.RandomDataGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.constants.ErrorMessages;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class TestCaseProvider {

    @DataProvider(name = DataProviderNames.VERIFY_CREATE_TEST_CASE)
    public static Object[][] verifyCreateTestCase() {

        return new Object[][]{
                {"WithRandomTestSteps", generateSampleTestCaseRequest()},
                {"WithoutAutomatedAndDescription", new TestCaseCreateRequest(false,
                        RandomDataGenerator.createRandomStringAlphanumericWithLen(25),
                        generateSampleTestCaseSteps(3, 10),
                        "Sample Title " + RandomDataGenerator.createRandomStringAlphanumericWithLen(15)
                )}
        };
    }

    public static List<TestCaseStep> generateSampleTestCaseSteps(int minSteps, int maxSteps){
        List<TestCaseStep> testCaseStepList = new ArrayList<>();
        int stepsToGenerate = RandomDataGenerator.createRandomWholeNumber(minSteps, maxSteps);
        for(int i=0; i<stepsToGenerate; i++){
            testCaseStepList.add(new TestCaseStep(i+1, RandomDataGenerator.createRandomStringAlphanumericWithLen(15)));
        }

        return testCaseStepList;
    }

    public static TestCaseCreateRequest generateSampleTestCaseRequest(){
        return new TestCaseCreateRequest(false,
        RandomDataGenerator.createRandomStringAlphanumericWithLen(25),
                RandomDataGenerator.createRandomStringAlphanumericWithLen(25),
                generateSampleTestCaseSteps(3, 10),
                "Sample Title " + RandomDataGenerator.createRandomStringAlphanumericWithLen(15)
                );
    }

    private static TestCaseCreateErrorResponse prepareExpectedTestCaseWithoutTitleResponse(){
        TestCaseCreateErrorResponse expectedCreateTestCaseWithoutTitle = new TestCaseCreateErrorResponse();
        expectedCreateTestCaseWithoutTitle.setTitleRequiredMsg(ErrorMessages.TEST_CASE_TITLE_REQUIRED_MSG);
        return expectedCreateTestCaseWithoutTitle;
    }

    private static TestCaseCreateErrorResponse prepareExpectedTestCaseWithoutExpectedResultsResponse(){
        TestCaseCreateErrorResponse expectedCreateTestCaseWithoutExpectedResults = new TestCaseCreateErrorResponse();
        expectedCreateTestCaseWithoutExpectedResults.setExpectedResultRequiredMsg(ErrorMessages.TEST_CASE_EXPECTED_RESULTS_REQUIRED_MSG);
        return expectedCreateTestCaseWithoutExpectedResults;
    }

    private static TestCaseCreateErrorResponse prepareExpectedTestCaseWithoutTestStepsResponse(){
        TestCaseCreateErrorResponse expectedCreateTestCaseWithoutTestSteps = new TestCaseCreateErrorResponse();
        expectedCreateTestCaseWithoutTestSteps.setTestStepsRequiredMsg(ErrorMessages.TEST_CASE_STEPS_REQUIRED_MSG);
        return expectedCreateTestCaseWithoutTestSteps;
    }

    @DataProvider(name = DataProviderNames.VERIFY_CANT_CREATE_TEST_CASE)
    public static Object[][] verifyCantCreateTestCase() {
        return new Object[][]{
                {"WithoutTitle", new TestCaseCreateRequest(false,
                        RandomDataGenerator.createRandomStringAlphanumericWithLen(25),
                        generateSampleTestCaseSteps(3, 10),
                        ""
                ), prepareExpectedTestCaseWithoutTitleResponse()},
                {"WithoutTestSteps", new TestCaseCreateRequest(false,
                        RandomDataGenerator.createRandomStringAlphanumericWithLen(25),
                        generateSampleTestCaseSteps(0,0),
                        "Sample Title " + RandomDataGenerator.createRandomStringAlphanumericWithLen(15)
                ), prepareExpectedTestCaseWithoutTestStepsResponse()},
                {"WithoutExpectedResults", new TestCaseCreateRequest(false,
                        "",
                        generateSampleTestCaseSteps(3, 10),
                        "Sample Title " + RandomDataGenerator.createRandomStringAlphanumericWithLen(15)
                ), prepareExpectedTestCaseWithoutExpectedResultsResponse()}
        };
    }
}
