package com.projectname.api.client.data.model.people.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.data.model.seniority.CreateSeniorityResponse;
import com.projectname.api.client.data.model.team.CreateTeamResponse;
import com.projectname.api.client.data.model.technology.create.CreateTechnologyResponse;

import java.io.Serializable;

public class UpdatePersonRequest implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
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

    public UpdatePersonRequest() {
    }

    public UpdatePersonRequest(Integer id, String name, CreateTechnologyResponse[] technologies, CreateSeniorityResponse seniority, CreateTeamResponse team) {
        super();
        this.id = id;
        this.name = name;
        this.technologies = technologies;
        this.seniority = seniority;
        this.team = team;
    }


    public UpdatePersonRequest(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
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



