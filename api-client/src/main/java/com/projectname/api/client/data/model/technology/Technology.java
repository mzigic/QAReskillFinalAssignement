package com.projectname.api.client.data.model.technology;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Technology implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("candidate_id")
    @Expose
    private Integer candidateId;
    @SerializedName("candidate_scenario_id")
    @Expose
    private Integer candidateScenarioId;
    private final static long serialVersionUID = 6534800126487123186L;

    public Technology() {
    }

    public Technology(Integer id, String title, Integer candidateId, Integer candidateScenarioId) {
        super();
        this.id = id;
        this.title = title;
        this.candidateId = candidateId;
        this.candidateScenarioId = candidateScenarioId;
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

    public Integer getCandidateScenarioId() {
        return candidateScenarioId;
    }

    public void setCandidateScenarioId(Integer candidateScenarioId) {
        this.candidateScenarioId = candidateScenarioId;
    }

}