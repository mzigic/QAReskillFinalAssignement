package com.projectname.api.tests.schemavalidation.suites;

import com.projectname.api.client.asserts.ValidationSchemaAssert;
import com.projectname.api.client.calls.CandidateAPI;
import com.projectname.api.client.constants.GlobalParams;
import com.projectname.api.client.data.model.sandbox.candidate.CandidateLoginRequest;
import com.projectname.api.client.data.model.sandbox.candidate.CandidateLoginResponse;
import com.projectname.api.tests.environment.ConfigSetup;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

// example for response validation test
public class SandboxValidationTests extends SandboxTestBase {

    static String token;

    @BeforeClass(groups = {"integration"})
    public void authorizeCandidate(){
        logStep("INFO: Authorize candidate");
        CandidateLoginRequest candidateLoginRequest = new CandidateLoginRequest(ConfigSetup.getUser(), ConfigSetup.getUserPsw());
        CandidateLoginResponse candidateLoginResponse = CandidateAPI.candidateLogin(candidateLoginRequest);
        logStep("PASS: Candidate authorized");

        logStep("INFO: Obtain token");
        token  = candidateLoginResponse.getToken();
        logStep("PASS: Token obtained");
    }

    @Test(groups = {"integration"})
    public static void verifyLoginCandidateResponse(){
        CandidateLoginRequest candidateLoginRequest = new CandidateLoginRequest(ConfigSetup.getUser(), ConfigSetup.getUserPsw());

        logStep("INFO: Verify required fields");
        new ValidationSchemaAssert().assertResponseStructure(CandidateAPI.validateCandidateLoginResponse(candidateLoginRequest));
        logStep("PASS: Required fields are verified");

    }

    @Test(groups = {"integration"})
    @Description("Allure description for this test")
    public static void verifyGetTestCaseByIdResponse() {
        logStep("INFO: Verify required fields");
        new ValidationSchemaAssert().assertResponseStructure(CandidateAPI.validateGetTestCaseIdResponse(token, GlobalParams.VALID_TEST_CASE_ID));
        logStep("PASS: Required fields are verified");
    }
}
