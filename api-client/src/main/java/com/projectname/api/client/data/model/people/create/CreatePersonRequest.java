package com.projectname.api.client.data.model.people.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.data.model.seniority.CreateSeniorityResponse;
import com.projectname.api.client.data.model.team.CreateTeamResponse;
import com.projectname.api.client.data.model.technology.create.CreateTechnologyResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CreatePersonRequest implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("technologies")
    @Expose
    private List<CreateTechnologyResponse> technologies = new ArrayList<>();
    @SerializedName("seniority")
    @Expose
    private List<CreateSeniorityResponse> seniority = new ArrayList<>();
    @SerializedName("team")
    @Expose
    private List<CreateTeamResponse> team = new ArrayList<>();
    private final static long serialVersionUID = 6193505836131998481L;

    public CreatePersonRequest() {
    }

    public CreatePersonRequest(String name, List<CreateTechnologyResponse> technologies, List<CreateSeniorityResponse> seniority, List<CreateTeamResponse> team) {
        super();
        this.name = name;
        this.technologies = technologies;
        this.seniority = seniority;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CreateTechnologyResponse> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<CreateTechnologyResponse> technologies) {
        this.technologies = technologies;
    }

    public List<CreateSeniorityResponse> getSeniority() {
        return seniority;
    }

    public void setSeniority(List<CreateSeniorityResponse> seniority) {
        this.seniority = seniority;
    }

    public List<CreateTeamResponse> getTeam() {
        return team;
    }

    public void setTeam(List<CreateTeamResponse> team) {
        this.team = team;
    }
}



