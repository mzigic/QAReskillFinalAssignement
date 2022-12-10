package com.projectname.api.client.calls;

import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.people.create.CreatePersonRequest;
import com.projectname.api.client.data.model.people.create.CreatePersonResponse;
import com.projectname.api.client.utils.rest.GsonFunctions;
import com.projectname.api.client.utils.rest.RestAssuredTokenAuthFunctions;

public class PeopleAPI {
    public static CreatePersonResponse[] createPerson(String token, CreatePersonRequest createPerson) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredTokenAuthFunctions.post(createPerson, token, ApiEndpoints.PEOPLE), CreatePersonResponse[].class);
    }

    public static void deletePerson(String token, Integer id) {
        RestAssuredTokenAuthFunctions.delete(token, ApiEndpoints.people(id));
    }
}
