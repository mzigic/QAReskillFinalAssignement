package com.projectname.api.client.calls;

import com.projectname.api.client.constants.SandboxApiEndpoints;
import com.projectname.api.client.data.model.login.LoginRequest;
import com.projectname.api.client.data.model.login.LoginResponse;
import com.projectname.api.client.utils.rest.GsonFunctions;
import com.projectname.api.client.utils.rest.RestAssuredNoAuthFunctions;

public class LoginAPI {
    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredNoAuthFunctions.post(loginRequest, SandboxApiEndpoints.CANDIDATE_LOGIN), LoginResponse.class);
    }
}