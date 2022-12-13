package com.projectname.api.client.calls;

import com.projectname.api.client.constants.SandboxApiEndpoints;
import com.projectname.api.client.data.model.people.create.CreatePersonRequest;
import com.projectname.api.client.data.model.people.create.CreatePersonResponse;
import com.projectname.api.client.utils.rest.GsonFunctions;
import com.projectname.api.client.utils.rest.RestAssuredTokenAuthFunctions;

public class PeopleAPI {
    public static CreatePersonResponse[] createPerson(String token, CreatePersonRequest createPerson) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredTokenAuthFunctions.post(createPerson, token, SandboxApiEndpoints.CANDIDATE_PEOPLE), CreatePersonResponse[].class);
    }

    public static void deletePerson(String token, Integer id) {
        RestAssuredTokenAuthFunctions.delete(token, SandboxApiEndpoints.people(id));
    }
}
