package com.projectname.api.client.data.model.projects.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class UpdateProjectRequest implements Serializable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("people")
    @Expose
    private List<AssignPersonRequest> people = null;
    @SerializedName("project_id")
    @Expose
    private Integer projectId;
    private final static long serialVersionUID = -3056193926883568988L;

    public UpdateProjectRequest() {
    }

    public UpdateProjectRequest(String title, List<AssignPersonRequest> people, Integer projectId) {
        super();
        this.title = title;
        this.people = people;
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AssignPersonRequest> getPeople() {
        return people;
    }

    public void setPeople(List<AssignPersonRequest> people) {
        this.people = people;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

}