package com.projectname.api.client.data.model.people.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.data.model.seniority.Seniority;
import com.projectname.api.client.data.model.team.Team;
import com.projectname.api.client.data.model.technology.Technology;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CreatePersonRequest implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("technologies")
    @Expose
    private List<Technology> technologies = new ArrayList<>();
    @SerializedName("seniority")
    @Expose
    private List<Seniority> seniority = new ArrayList<>();
    @SerializedName("team")
    @Expose
    private List<Team> team = new ArrayList<>();
    private final static long serialVersionUID = 6193505836131998481L;

    public CreatePersonRequest() {
    }

    public CreatePersonRequest(String name, List<Technology> technologies, List<Seniority> seniority, List<Team> team) {
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

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }

    public List<Seniority> getSeniority() {
        return seniority;
    }

    public void setSeniority(List<Seniority> seniority) {
        this.seniority = seniority;
    }

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }
}



