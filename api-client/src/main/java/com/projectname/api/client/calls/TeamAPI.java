package com.projectname.api.client.calls;

import com.projectname.api.client.constants.SandboxApiEndpoints;
import com.projectname.api.client.data.model.team.CreateTeamRequest;
import com.projectname.api.client.data.model.team.CreateTeamResponse;
import com.projectname.api.client.utils.rest.GsonFunctions;
import com.projectname.api.client.utils.rest.RestAssuredTokenAuthFunctions;

public class TeamAPI {
    public static CreateTeamResponse[] createTeam(String token, CreateTeamRequest createTeam) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredTokenAuthFunctions.post(createTeam, token, SandboxApiEndpoints.CANDIDATE_TEAMS),
                CreateTeamResponse[].class);
    }

    public static void deleteTeam(String token, Integer id) {
        RestAssuredTokenAuthFunctions.delete(token, SandboxApiEndpoints.teams(id));
    }
}
