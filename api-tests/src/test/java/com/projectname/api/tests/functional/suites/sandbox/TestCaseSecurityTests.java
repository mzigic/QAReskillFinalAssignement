package com.projectname.api.tests.functional.suites.sandbox;

import com.projectname.api.client.calls.CandidateAPI;
import com.projectname.api.client.data.model.sandbox.candidate.CandidateLoginRequest;
import com.projectname.api.client.data.model.sandbox.candidate.CandidateLoginResponse;
import com.projectname.api.client.data.model.sandbox.testcase.TestCaseCreateErrorResponse;
import com.projectname.api.client.data.model.sandbox.testcase.TestCaseCreateRequest;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.data.provider.TestCaseProvider;
import com.projectname.api.tests.environment.ConfigSetup;
import com.projectname.api.tests.functional.asserts.TestCaseErrorAssert;
import com.projectname.api.tests.init.SandboxTestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

//to avoid any misunderstanding, test case refers to sandbox application section
public class TestCaseSecurityTests extends SandboxTestBase {

    static String token;

    @BeforeClass(groups = {"regression", "smoke"})
    public void authorizeCandidate(){
        logStep("INFO: Authorize candidate");
        CandidateLoginRequest candidateLoginRequest = new CandidateLoginRequest(ConfigSetup.getUser(), ConfigSetup.getUserPsw());
        CandidateLoginResponse candidateLoginResponse = CandidateAPI.candidateLogin(candidateLoginRequest);
        logStep("PASS: Candidate authorized");

        token  = candidateLoginResponse.getToken();
    }

    @Test(groups = {"regression", "smoke"}, dataProvider = DataProviderNames.VERIFY_CANT_CREATE_TEST_CASE, dataProviderClass = TestCaseProvider.class)
    @Description("Test case can be created for active and authorized candidate")
    @Feature("Candidate test cases")
    public static void verifyCantCreateTestCase(String methodNameSuffix,
                                                TestCaseCreateRequest testCaseCreateRequest,
                                                TestCaseCreateErrorResponse expectedTestCaseCreateErrorResponse) {
        logStep("INFO: Try to create test case");
        TestCaseCreateErrorResponse actualTestCaseCreateErrorResponse = CandidateAPI.tryToCreateTestCase(token, testCaseCreateRequest);
        logStep("PASS: Request is processed");

        TestCaseErrorAssert testCaseErrorAssert = new TestCaseErrorAssert();
        logStep("INFO: Verify test case is not created");
        testCaseErrorAssert.assertTestCaseCreateErrorResponse(actualTestCaseCreateErrorResponse, expectedTestCaseCreateErrorResponse);
        logStep("PASS: Response is verified");

    }

}
