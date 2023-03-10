package com.projectname.api.client.calls;

import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.users.byid.GetUserByIdResponse;
import com.projectname.api.client.data.model.users.create.CreateUserRequest;
import com.projectname.api.client.data.model.users.create.CreateUserResponse;
import com.projectname.api.client.utils.rest.GsonFunctions;
import com.projectname.api.client.utils.rest.RestAssuredNoAuthFunctions;
import com.projectname.api.client.utils.rest.model.ResponseValidation;
import io.restassured.response.Response;

//Methods that help parse json into model classes
public class UserAPI {

    public static CreateUserResponse createUser(CreateUserRequest createRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredNoAuthFunctions.post(createRequest, ApiEndpoints.USERS), CreateUserResponse.class);
    }

    public static GetUserByIdResponse getUserById(String userId) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredNoAuthFunctions.get(ApiEndpoints.users(userId)), GetUserByIdResponse.class);
    }

    //Method used to parse and validate response for Integration tests
    public static ResponseValidation validateGetUserByIdResponse(String userId) {
        Response jsonResponse = RestAssuredNoAuthFunctions.get(ApiEndpoints.users(userId));
        return GsonFunctions.verifyResponse(jsonResponse, GetUserByIdResponse.class);
    }

//example for retrieving list as response
//    public static List<ListOfObject> getListResponse(String accessToken) {
//        return GsonFunctions.parseSuccessResponseAsListToModel(RestAssuredTokenAuthFunctions.get(accessToken, ApiEndpoints.USERS), ListOfObject[].class);
//    }

//example for retrieving list as response for integration test
//    public static ResponseValidation validateListResponse(String accessToken) {
//        Response jsonResponse = RestAssuredTokenAuthFunctions.get(accessToken, ApiEndpoints.USERS);
//        return GsonFunctions.verifyResponse(jsonResponse, ResponseValidation[].class);
//    }
}
