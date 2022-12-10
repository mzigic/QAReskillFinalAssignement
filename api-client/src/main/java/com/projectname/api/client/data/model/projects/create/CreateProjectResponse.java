package com.projectname.api.client.data.model.projects.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CreateProjectResponse implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("candidate_id")
    @Expose
    private Integer candidateId;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("candidate_scenario_id")
    @Expose
    private Integer candidateScenarioId;
    @SerializedName("people_count")
    @Expose
    private Integer peopleCount;
    @SerializedName("seniority_count")
    @Expose
    private Integer seniorityCount;
    @SerializedName("technology_count")
    @Expose
    private Integer technologyCount;
    private final static long serialVersionUID = 1119344957783425492L;

    public CreateProjectResponse() {
    }

    public CreateProjectResponse(Integer id, String title, Integer candidateId, Object image, Integer candidateScenarioId, Integer peopleCount, Integer seniorityCount, Integer technologyCount) {
        super();
        this.id = id;
        this.title = title;
        this.candidateId = candidateId;
        this.image = image;
        this.candidateScenarioId = candidateScenarioId;
        this.peopleCount = peopleCount;
        this.seniorityCount = seniorityCount;
        this.technologyCount = technologyCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public Integer getCandidateScenarioId() {
        return candidateScenarioId;
    }

    public void setCandidateScenarioId(Integer candidateScenarioId) {
        this.candidateScenarioId = candidateScenarioId;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Integer getSeniorityCount() {
        return seniorityCount;
    }

    public void setSeniorityCount(Integer seniorityCount) {
        this.seniorityCount = seniorityCount;
    }

    public Integer getTechnologyCount() {
        return technologyCount;
    }

    public void setTechnologyCount(Integer technologyCount) {
        this.technologyCount = technologyCount;
    }

    public static CreateProjectResponse parseCreatedProject(CreateProjectRequest createProjectRequest) {
        CreateProjectResponse createProjectResponse = new CreateProjectResponse();
        createProjectResponse.setTitle(createProjectRequest.getTitle());
        return createProjectResponse;
    }
}