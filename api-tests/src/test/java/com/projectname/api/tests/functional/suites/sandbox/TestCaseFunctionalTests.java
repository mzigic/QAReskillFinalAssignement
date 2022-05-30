package com.projectname.api.tests.functional.suites.sandbox;

import com.projectname.api.client.calls.CandidateAPI;
import com.projectname.api.client.constants.GlobalParams;
import com.projectname.api.client.data.model.sandbox.candidate.CandidateLoginRequest;
import com.projectname.api.client.data.model.sandbox.candidate.CandidateLoginResponse;
import com.projectname.api.client.data.model.sandbox.testcase.TestCaseCreateRequest;
import com.projectname.api.client.data.model.sandbox.testcase.GetTestCaseByIdErrorResponse;
import com.projectname.api.client.data.model.sandbox.testcase.TestCaseResponse;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.data.provider.TestCaseProvider;
import com.projectname.api.tests.environment.ConfigSetup;
import com.projectname.api.tests.functional.asserts.CandidateAssert;
import com.projectname.api.tests.functional.asserts.TestCaseAssert;
import com.projectname.api.tests.init.SandboxTestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

public class TestCaseFunctionalTests extends SandboxTestBase {

    static TestCaseAssert testCaseAssert = new TestCaseAssert();
    static CandidateAssert candidateAssert = new CandidateAssert();
    static String token;

    @BeforeClass(groups = {"regression", "smoke"})
    public void authorizeCandidate(){
        logStep("INFO: Authorize candidate");
        CandidateLoginRequest candidateLoginRequest = new CandidateLoginRequest(ConfigSetup.getUser(), ConfigSetup.getUserPsw());
        CandidateLoginResponse candidateLoginResponse = CandidateAPI.candidateLogin(candidateLoginRequest);
        logStep("PASS: Candidate authorized");

        logStep("INFO: Verify response");
        candidateAssert.assertLoggedInCandidate(candidateLoginResponse);
        logStep("PASS: Response verified");
        token  = candidateLoginResponse.getToken();
    }

    @Test(groups = {"regression", "smoke", "create"})
    @Description("Test case can be created for active and authorized candidate")
    @Feature("Candidate test cases")
    public static void verifyTestCaseCanBeCreatedForActiveAndAuthorizedCandidate(){
        TestCaseCreateRequest testCaseCreateRequest = TestCaseProvider.generateSampleTestCaseRequest();

        logStep("INFO: Candidate add new test case");
        List<TestCaseResponse> testCaseResponseList = CandidateAPI.addNewTestCase(testCaseCreateRequest, token);
        logStep("PASS: Test case added");

        TestCaseResponse testCaseExpected = TestCaseResponse.parseFromCreatedTestCase(testCaseCreateRequest);
        TestCaseResponse testCaseActual = testCaseResponseList.get(0);

        logStep("INFO: Verify created test case");
        testCaseAssert.assertCreatedTestCase(testCaseExpected, testCaseActual);
        logStep("PASS: Created test cases data verified");
    }

    // test-case with data provider usage as example for data-driven testing support
    @Test(groups = {"regression", "smoke"}, dataProvider = DataProviderNames.VERIFY_CREATE_TEST_CASE, dataProviderClass = TestCaseProvider.class)
    @Description("Test case can be created for active and authorized candidate with data provider")
    @Feature("Candidate test cases")
    public static void verifyTestCaseCanBeCreatedForActiveAndAuthorizedCandidateWithProvider(String methodNameSuffix, TestCaseCreateRequest testCaseCreateRequest){

        logStep("INFO: Candidate add new test case");
        List<TestCaseResponse> testCaseResponseList = CandidateAPI.addNewTestCase(testCaseCreateRequest, token);
        logStep("PASS: Test case added");

        TestCaseResponse testCaseExpected = TestCaseResponse.parseFromCreatedTestCase(testCaseCreateRequest);
        TestCaseResponse testCaseActual = testCaseResponseList.get(0);


        logStep("INFO: Verify test cases");
        testCaseAssert.assertCreatedTestCase(testCaseExpected, testCaseActual);
        logStep("PASS: Candidate test cases data verified");
    }

    // send the wrong user id on purpose to get error response from the server
    @Test(groups = {"regression", "smoke"})
    public static void verifyGetTestCaseWillReturnErrorForInvalidId(){
        logStep("INFO: Get Candidate Test Case by invalid ID");
        GetTestCaseByIdErrorResponse testCaseErrorResponse = CandidateAPI.getTestCaseByInvalidId(token, GlobalParams.INVALID_TEST_CASE_ID);
        logStep("PASS: Error response received");

        logStep("INFO: Verify Error Response");
        testCaseAssert.assertTestCaseWithInvalidIdResponse(testCaseErrorResponse);
        logStep("PASS: Error response verified");
    }

    @Test(groups = {"regression", "smoke"})
    public static void verifyCreateTestCaseAssertWillFail(){
        TestCaseCreateRequest testCaseCreateRequest = TestCaseProvider.generateSampleTestCaseRequest();

        logStep("INFO: Candidate add new test case");
        List<TestCaseResponse> testCaseResponseList = CandidateAPI.addNewTestCase(testCaseCreateRequest, token);
        logStep("PASS: Test case added");

        TestCaseResponse testCaseExpected = TestCaseResponse.parseFromCreatedTestCase(testCaseCreateRequest);
        TestCaseResponse testCaseActual = testCaseResponseList.get(0);

        // hardcoded data on purpose to fail the assertion
        testCaseExpected.setDescription("Modified Description");

        logStep("INFO: Verify test cases");
        testCaseAssert.assertCreatedTestCase(testCaseExpected, testCaseActual);
        logStep("PASS: Candidate test cases data verified");
    }
}
