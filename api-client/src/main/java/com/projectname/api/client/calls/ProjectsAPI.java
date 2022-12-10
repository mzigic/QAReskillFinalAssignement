package com.projectname.api.client.calls;

import com.projectname.api.client.constants.ApiEndpoints;
import com.projectname.api.client.data.model.projects.create.CreateProjectRequest;
import com.projectname.api.client.data.model.projects.create.CreateProjectResponse;
import com.projectname.api.client.data.model.projects.list.ListProjectsResponse;
import com.projectname.api.client.data.model.projects.update.UpdateProjectRequest;
import com.projectname.api.client.data.model.projects.update.UpdateProjectResponse;
import com.projectname.api.client.utils.rest.GsonFunctions;
import com.projectname.api.client.utils.rest.RestAssuredTokenAuthFunctions;

public class ProjectsAPI {
    public static ListProjectsResponse[] getProjects(String token) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredTokenAuthFunctions.get(token, ApiEndpoints.PROJECTS), ListProjectsResponse[].class);
    }

    public static CreateProjectResponse createProject(String token, CreateProjectRequest createProject) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredTokenAuthFunctions.post(createProject, token, ApiEndpoints.PROJECTS), CreateProjectResponse.class);
    }

    public static UpdateProjectResponse updateProject(String token, UpdateProjectRequest updateProject, Integer id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredTokenAuthFunctions.put(updateProject, token, ApiEndpoints.projects(id)), UpdateProjectResponse.class);
    }

    public static void deleteProject(String token, Integer id) {
        RestAssuredTokenAuthFunctions.delete(token, ApiEndpoints.projects(id));
    }
}
