package com.projectname.api.tests.functional.suites.sandbox;

import com.projectname.api.client.calls.CandidateAPI;
import com.projectname.api.client.constants.GlobalParams;
import com.projectname.api.client.data.model.sandbox.candidate.CandidateLoginRequest;
import com.projectname.api.client.data.model.sandbox.candidate.CandidateLoginResponse;
import com.projectname.api.client.data.model.sandbox.candidate.UpdateProfileRequest;
import com.projectname.api.client.data.model.sandbox.common.CandidateProfile;
import com.projectname.api.tests.environment.ConfigSetup;
import com.projectname.api.tests.functional.asserts.CandidateAssert;
import com.projectname.api.tests.init.SandboxTestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

// each test class should extend TestBase class in order to inherit all common behaviors and to be logged properly in report
// this sample test class implement api calls from internal sandbox site
// for proper usage, apiBaseUrl is set via String constant in SandboxTestBase class, in @BeforeClass method
// test methods in this class calls rest assured methods, with token authorization, in background
public class CandidateProfileFunctionalTests extends SandboxTestBase {

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

        token = candidateLoginResponse.getToken();
    }

    // each test case should be simple, readable, in few lines and without any to technical steps
    // It should represent user actions like as those are done manually on UI
    @Test(groups = {"regression", "smoke"})
    @Description("Profile Info can be retrieved for active and authorized candidate")
    @Feature("Candidate profile")
    public static void verifyProfileDataCanBeRetrievedForActiveAndAuthorizedCandidate(){
        logStep("INFO: Get profile data");
        CandidateProfile candidateProfileResponse = CandidateAPI.getCandidateProfile(token);
        logStep("PASS: Profile data retrieved");

        logStep("INFO: Verify candidate profile response");
        candidateAssert.assertProfileResponse(candidateProfileResponse);
        logStep("PASS: Candidate profile response verified");
    }

    @Test(groups = {"regression", "smoke"})
    @Description("Profile Info can be modified for active and authorized candidate")
    @Feature("Candidate profile")
    public static void verifyProfileDataCanBeModifiedForActiveAndAuthorizedCandidate(){
        logStep("INFO: Get current profile data");
        CandidateProfile currentProfileData = CandidateAPI.getCandidateProfile(token);
        logStep("PASS: Current profile data retrieved");

        UpdateProfileRequest updateProfileRequest =
                new UpdateProfileRequest("Modified profile infO", GlobalParams.CAREER_STATUS_OTHER_ID, GlobalParams.VALID_CITY_ID, "");

        logStep("INFO: Modify profile data");
        CandidateProfile modifiedProfileData = CandidateAPI.modifyCandidateProfile(token, updateProfileRequest);
        currentProfileData.setBiography(updateProfileRequest.getBiography());
        currentProfileData.setCareerStatusId(updateProfileRequest.getCareerStatusId());
        currentProfileData.setCityId(updateProfileRequest.getCityId());
        logStep("PASS: Profile data modified");

        logStep("INFO: Verify modified profile data");
        candidateAssert.assertProfileResponseData(modifiedProfileData, currentProfileData);
        logStep("PASS: Profile data verified");

    }
}
