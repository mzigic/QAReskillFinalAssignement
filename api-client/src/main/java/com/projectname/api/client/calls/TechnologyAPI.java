package com.projectname.api.client.calls;

import com.projectname.api.client.constants.SandboxApiEndpoints;
import com.projectname.api.client.data.model.technology.create.CreateTechnologyRequest;
import com.projectname.api.client.data.model.technology.create.CreateTechnologyResponse;
import com.projectname.api.client.data.model.technology.list.ListTechnologyResponse;
import com.projectname.api.client.data.model.technology.update.UpdateTechnologyRequest;
import com.projectname.api.client.data.model.technology.update.UpdateTechnologyResponse;
import com.projectname.api.client.utils.rest.GsonFunctions;
import com.projectname.api.client.utils.rest.RestAssuredTokenAuthFunctions;

public class TechnologyAPI {
    public static CreateTechnologyResponse[] createTechnology(String token, CreateTechnologyRequest createTechnology) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredTokenAuthFunctions.post(createTechnology, token, SandboxApiEndpoints.CANDIDATE_TECHNOLOGIES), CreateTechnologyResponse[].class);
    }

    public static ListTechnologyResponse[] getTechnologies(String token) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredTokenAuthFunctions.get(token, SandboxApiEndpoints.CANDIDATE_TECHNOLOGIES), ListTechnologyResponse[].class);
    }

    public static void deleteTechnology(String token, Integer id) {
        RestAssuredTokenAuthFunctions.delete(token, SandboxApiEndpoints.technologies(id));
    }

    public static UpdateTechnologyResponse[] updateTechnology(String token, UpdateTechnologyRequest updateTechnology, Integer id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredTokenAuthFunctions.put(updateTechnology, token,
                SandboxApiEndpoints.technologies(id)), UpdateTechnologyResponse[].class);
    }
}
