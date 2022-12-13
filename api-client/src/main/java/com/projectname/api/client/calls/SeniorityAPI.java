package com.projectname.api.client.calls;

import com.projectname.api.client.constants.SandboxApiEndpoints;
import com.projectname.api.client.data.model.seniority.CreateSeniorityRequest;
import com.projectname.api.client.data.model.seniority.CreateSeniorityResponse;
import com.projectname.api.client.utils.rest.GsonFunctions;
import com.projectname.api.client.utils.rest.RestAssuredTokenAuthFunctions;

public class SeniorityAPI {
    public static CreateSeniorityResponse[] createSeniority(String token, CreateSeniorityRequest createSeniority) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredTokenAuthFunctions.post(createSeniority, token, SandboxApiEndpoints.CANDIDATE_SENIORITIES),
                CreateSeniorityResponse[].class);
    }

    public static void deleteTSeniority(String token, Integer id) {
        RestAssuredTokenAuthFunctions.delete(token, SandboxApiEndpoints.seniorities(id));
    }
}
