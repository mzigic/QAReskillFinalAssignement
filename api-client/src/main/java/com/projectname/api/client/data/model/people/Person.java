package com.projectname.api.client.data.model.people;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.data.model.seniority.CreateSeniorityResponse;
import com.projectname.api.client.data.model.technology.create.CreateTechnologyResponse;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("candidate_id")
    @Expose
    private Integer candidateId;
    @SerializedName("seniority_id")
    @Expose
    private Integer seniorityId;
    @SerializedName("team_id")
    @Expose
    private Integer teamId;
    @SerializedName("candidate_scenario_id")
    @Expose
    private Integer candidateScenarioId;

    @SerializedName("technologies")
    @Expose
    private List<CreateTechnologyResponse> technologies = null;
    @SerializedName("seniority")
    @Expose
    private CreateSeniorityResponse seniority;
    private final static long serialVersionUID = -2511334441852931804L;

    public Person() {
    }

    public Person(Integer id, String name, Integer candidateId, Integer seniorityId, Integer teamId, Integer candidateScenarioId, List<CreateTechnologyResponse> technologies, CreateSeniorityResponse seniority) {
        super();
        this.id = id;
        this.name = name;
        this.candidateId = candidateId;
        this.seniorityId = seniorityId;
        this.teamId = teamId;
        this.candidateScenarioId = candidateScenarioId;
        this.technologies = technologies;
        this.seniority = seniority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public Integer getSeniorityId() {
        return seniorityId;
    }

    public void setSeniorityId(Integer seniorityId) {
        this.seniorityId = seniorityId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getCandidateScenarioId() {
        return candidateScenarioId;
    }

    public void setCandidateScenarioId(Integer candidateScenarioId) {
        this.candidateScenarioId = candidateScenarioId;
    }

    public List<CreateTechnologyResponse> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<CreateTechnologyResponse> technologies) {
        this.technologies = technologies;
    }

    public CreateSeniorityResponse getSeniority() {
        return seniority;
    }

    public void setSeniority(CreateSeniorityResponse seniority) {
        this.seniority = seniority;
    }

}