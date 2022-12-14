package com.projectname.api.client.data.model.people.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.data.model.seniority.CreateSeniorityResponse;
import com.projectname.api.client.data.model.team.CreateTeamResponse;
import com.projectname.api.client.data.model.technology.create.CreateTechnologyResponse;

import java.io.Serializable;

public class UpdatePersonResponse implements Serializable {

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
    @SerializedName("seniority")
    @Expose
    private CreateSeniorityResponse seniority;
    @SerializedName("team")
    @Expose
    private CreateTeamResponse team;
    @SerializedName("technologies")
    @Expose
    private CreateTechnologyResponse[] technologies = null;
    private final static long serialVersionUID = -4625511916604852520L;

    public UpdatePersonResponse() {
    }

    public UpdatePersonResponse(Integer id, String name, Integer candidateId, Integer seniorityId, Integer teamId, Integer candidateScenarioId, CreateSeniorityResponse seniority, CreateTeamResponse team, CreateTechnologyResponse[] technologies) {
        super();
        this.id = id;
        this.name = name;
        this.candidateId = candidateId;
        this.seniorityId = seniorityId;
        this.teamId = teamId;
        this.candidateScenarioId = candidateScenarioId;
        this.seniority = seniority;
        this.team = team;
        this.technologies = technologies;
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

    public CreateSeniorityResponse getSeniority() {
        return seniority;
    }

    public void setSeniority(CreateSeniorityResponse seniority) {
        this.seniority = seniority;
    }

    public CreateTeamResponse getTeam() {
        return team;
    }

    public void setTeam(CreateTeamResponse team) {
        this.team = team;
    }

    public CreateTechnologyResponse[] getTechnologies() {
        return technologies;
    }

    public void setTechnologies(CreateTechnologyResponse[] technologies) {
        this.technologies = technologies;
    }

    public static UpdatePersonResponse parseUpdatedPerson(UpdatePersonRequest updatePersonRequest) {
        UpdatePersonResponse updatePersonResponse = new UpdatePersonResponse();
        updatePersonResponse.setName(updatePersonRequest.getName());
        updatePersonResponse.setTechnologies(updatePersonRequest.getTechnologies());
        updatePersonResponse.setSeniority(updatePersonRequest.getSeniority());
        updatePersonResponse.setTeam(updatePersonRequest.getTeam());
        return updatePersonResponse;
    }
}