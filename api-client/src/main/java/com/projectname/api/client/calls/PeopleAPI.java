package com.projectname.api.client.calls;

import com.projectname.api.client.constants.SandboxApiEndpoints;
import com.projectname.api.client.data.model.people.create.CreatePersonRequest;
import com.projectname.api.client.data.model.people.create.CreatePersonResponse;
import com.projectname.api.client.data.model.people.update.UpdatePersonRequest;
import com.projectname.api.client.data.model.people.update.UpdatePersonResponse;
import com.projectname.api.client.utils.rest.GsonFunctions;
import com.projectname.api.client.utils.rest.RestAssuredTokenAuthFunctions;

public class PeopleAPI {
    public static CreatePersonResponse[] createPerson(String token, CreatePersonRequest createPerson) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredTokenAuthFunctions.post(createPerson, token, SandboxApiEndpoints.CANDIDATE_PEOPLE), CreatePersonResponse[].class);
    }

    public static void deletePerson(String token, Integer id) {
        RestAssuredTokenAuthFunctions.delete(token, SandboxApiEndpoints.people(id));
    }

    public static UpdatePersonResponse[] updatePerson(String token, UpdatePersonRequest updatePerson, Integer id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredTokenAuthFunctions.put(updatePerson, token,
                SandboxApiEndpoints.persons(id)), UpdatePersonResponse[].class);
    }

    public static CreatePersonResponse[] getPersons(String token) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredTokenAuthFunctions.get(token, SandboxApiEndpoints.CANDIDATE_PEOPLE), CreatePersonResponse[].class);
    }
}
