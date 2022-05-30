package com.projectname.api.tests.functional.asserts;

import com.projectname.api.client.data.model.sandbox.candidate.CandidateLoginResponse;
import com.projectname.api.client.data.model.sandbox.common.CandidateProfile;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CandidateAssert {

    private SoftAssert softAssert;

    public CandidateAssert() {
        this.softAssert = new SoftAssert();
    }

    // soft assert that do complete check and then log all errors found in test case
    public void assertLoggedInCandidate(CandidateLoginResponse candidateLoginResponse) {
        if (candidateLoginResponse == null) {
            Assert.fail("Candidate login response is null");
        }

        softAssert.assertTrue(candidateLoginResponse.getSuccess(), "success is false");
        softAssert.assertTrue(!(candidateLoginResponse.getToken() == null || candidateLoginResponse.getToken().isEmpty()), "token is null or empty");
        softAssert.assertNotNull(candidateLoginResponse.getRefreshToken(), "refresh token is null");
        softAssert.assertFalse(candidateLoginResponse.getRefreshToken().isEmpty(), "refresh token is empty");
        this.softAssert.assertAll();
    }

    public void assertProfileResponse(CandidateProfile profileResponse){
        if(profileResponse == null){
            Assert.fail("Candidate profile response is null");
        }

        softAssert.assertNotNull(profileResponse.getFirstName(), "first name is null");
        softAssert.assertNotNull(profileResponse.getLastName(), "last name is null");
        softAssert.assertNotNull(profileResponse.getEmail(), "email is null");
        this.softAssert.assertAll();
    }

    public void assertProfileResponseData(CandidateProfile actualProfileInfo, CandidateProfile expectedProfileInfo){
        if(actualProfileInfo == null){
            Assert.fail("Candidate profile data are null");
        }

        softAssert.assertEquals(actualProfileInfo.getEmail(), expectedProfileInfo.getEmail(), "email mismatch");
        softAssert.assertEquals(actualProfileInfo.getFirstName(), expectedProfileInfo.getFirstName(), "first name mismatch");
        softAssert.assertEquals(actualProfileInfo.getLastName(), expectedProfileInfo.getLastName(), "last name mismatch");
        this.softAssert.assertAll();
    }
}
