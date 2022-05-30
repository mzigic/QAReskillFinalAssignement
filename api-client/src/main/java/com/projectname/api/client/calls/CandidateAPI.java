package com.projectname.api.client.calls;

import com.projectname.api.client.constants.SandboxApiEndpoints;
import com.projectname.api.client.data.model.sandbox.candidate.CandidateDashboardResponse;
import com.projectname.api.client.data.model.sandbox.candidate.CandidateLoginRequest;
import com.projectname.api.client.data.model.sandbox.candidate.CandidateLoginResponse;
import com.projectname.api.client.data.model.sandbox.testcase.TestCaseCreateErrorResponse;
import com.projectname.api.client.data.model.sandbox.testcase.TestCaseCreateRequest;
import com.projectname.api.client.data.model.sandbox.candidate.UpdateProfileRequest;
import com.projectname.api.client.data.model.sandbox.common.CandidateProfile;
import com.projectname.api.client.data.model.sandbox.testcase.GetTestCaseByIdErrorResponse;
import com.projectname.api.client.data.model.sandbox.testcase.TestCaseResponse;
import com.projectname.api.client.data.model.sandbox.testcase.TestCaseDeleteResponse;
import com.projectname.api.client.data.model.sandbox.testcase.TestCaseNotFoundResponse;
import com.projectname.api.client.utils.rest.GsonFunctions;
import com.projectname.api.client.utils.rest.RestAssuredNoAuthFunctions;
import com.projectname.api.client.utils.rest.RestAssuredTokenAuthFunctions;
import com.projectname.api.client.utils.rest.model.ResponseValidation;
import io.restassured.response.Response;

import java.util.List;

public class CandidateAPI {
    public static CandidateLoginResponse candidateLogin(CandidateLoginRequest loginRequest){
        return GsonFunctions.parseSuccessResponseToModel(
                RestAssuredNoAuthFunctions.post(loginRequest, SandboxApiEndpoints.CANDIDATE_LOGIN),
                CandidateLoginResponse.class
        );
    }

    public static CandidateDashboardResponse getCandidateDashboard(String accessToken){
        return GsonFunctions.parseSuccessResponseToModel(
                RestAssuredTokenAuthFunctions.get(accessToken, SandboxApiEndpoints.CANDIDATE_DASHBOARD),
                CandidateDashboardResponse.class
        );
    }

    public static List<TestCaseResponse> getCandidateTestCases(String accessToken){
        return GsonFunctions.parseSuccessResponseAsListToModel(
                RestAssuredTokenAuthFunctions.get(accessToken, SandboxApiEndpoints.CANDIDATE_TESTCASES),
                TestCaseResponse[].class
        );
    }

    public static List<TestCaseResponse> addNewTestCase(TestCaseCreateRequest testCase, String accessToken){
        return GsonFunctions.parseSuccessResponseAsListToModel(
                RestAssuredTokenAuthFunctions.post(testCase, accessToken, SandboxApiEndpoints.CANDIDATE_TESTCASES),
                TestCaseResponse[].class
        );
    }

    public static CandidateProfile getCandidateProfile(String accessToken){
        return GsonFunctions.parseSuccessResponseToModel(
                RestAssuredTokenAuthFunctions.get(accessToken, SandboxApiEndpoints.CANDIDATE_PROFILE),
                CandidateProfile.class
        );
    }

    public static CandidateProfile modifyCandidateProfile(String accessToken, UpdateProfileRequest updateProfileRequest){
        return GsonFunctions.parseSuccessResponseToModel(
                RestAssuredTokenAuthFunctions.put(updateProfileRequest, accessToken, SandboxApiEndpoints.CANDIDATE_PROFILE),
                CandidateProfile.class
        );
    }

    public static TestCaseDeleteResponse deleteTestCase(String accessToken, String testCaseId){
        return GsonFunctions.parseSuccessResponseToModel(
                RestAssuredTokenAuthFunctions.delete(accessToken, SandboxApiEndpoints.testCaseBy(testCaseId)),
                TestCaseDeleteResponse.class
        );
    }

    public static TestCaseNotFoundResponse getNonExistingTestCaseById(String accessToken, String testCaseId){
        return GsonFunctions.parseSuccessResponseToModel(
                RestAssuredTokenAuthFunctions.get(accessToken, SandboxApiEndpoints.testCaseBy(testCaseId)),
                TestCaseNotFoundResponse.class
        );
    }

    public static TestCaseResponse getTestCaseById(String accessToken, String testCaseId){
        return GsonFunctions.parseSuccessResponseToModel(
                RestAssuredTokenAuthFunctions.get(accessToken, testCaseId),
         TestCaseResponse.class
        );
    }

    public static GetTestCaseByIdErrorResponse getTestCaseByInvalidId(String accessToken, String testCaseId){
        return GsonFunctions.parseErrorResponseToModel(
                RestAssuredTokenAuthFunctions.get(accessToken, SandboxApiEndpoints.testCaseBy(testCaseId)),
                GetTestCaseByIdErrorResponse.class
        );
    }

    //Method used to parse and validate response for Schema Validation tests
    public static ResponseValidation validateGetTestCaseIdResponse(String accessToken, String testCaseId) {
        Response jsonResponse = RestAssuredTokenAuthFunctions.get(accessToken, SandboxApiEndpoints.testCaseBy(testCaseId));
        return GsonFunctions.verifyResponse(jsonResponse, TestCaseResponse.class);
    }

    public static ResponseValidation validateCandidateLoginResponse(CandidateLoginRequest request) {
        Response jsonResponse = RestAssuredNoAuthFunctions.post(request, SandboxApiEndpoints.CANDIDATE_LOGIN);
        return GsonFunctions.verifyResponse(jsonResponse, CandidateLoginResponse.class);
    }

    public static TestCaseCreateErrorResponse tryToCreateTestCase(String accessToken, TestCaseCreateRequest request) {
        return GsonFunctions.parseErrorResponseToModel(
                RestAssuredTokenAuthFunctions.post(request, accessToken, SandboxApiEndpoints.CANDIDATE_TESTCASES),
                TestCaseCreateErrorResponse.class
        );
    }

}
