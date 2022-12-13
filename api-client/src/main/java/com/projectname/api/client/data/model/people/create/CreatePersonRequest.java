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
    private CreateTechnologyResponse[] technologies;
    @SerializedName("seniority")
    @Expose
    private CreateSeniorityResponse seniority;
    @SerializedName("team")
    @Expose
    private CreateTeamResponse team;
    private final static long serialVersionUID = 6193505836131998481L;

    public CreatePersonRequest() {
    }

    public CreatePersonRequest(String name, CreateTechnologyResponse[] technologies, CreateSeniorityResponse seniority, CreateTeamResponse team) {
        super();
        this.name = name;
        this.technologies = technologies;
        this.seniority = seniority;
        this.team = team;
    }
    public CreatePersonRequest(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateTechnologyResponse[] getTechnologies() {
        return technologies;
    }

    public void setTechnologies(CreateTechnologyResponse[] technologies) {
        this.technologies = technologies;
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
}



