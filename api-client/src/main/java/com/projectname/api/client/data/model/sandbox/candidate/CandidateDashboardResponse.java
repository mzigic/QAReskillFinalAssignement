package com.projectname.api.client.data.model.sandbox.candidate;

import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.annotations.ResponseRequiredField;
import com.projectname.api.client.data.model.sandbox.common.CandidateProfile;
import com.projectname.api.client.data.model.sandbox.common.Scenario;
import com.projectname.api.client.data.model.sandbox.common.TaskStatus;

import java.io.Serial;
import java.io.Serializable;

public class CandidateDashboardResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 2600443895074685008L;

    @SerializedName("finished")
    @ResponseRequiredField(canBeEmpty = false)
    private TaskStatus finished;

    @SerializedName("profile")
    @ResponseRequiredField(canBeEmpty = false)
    private CandidateProfile profile;

    @SerializedName("scenario")
    @ResponseRequiredField(canBeEmpty = false)
    private Scenario scenario;

    public CandidateDashboardResponse() {
    }

    public CandidateDashboardResponse(TaskStatus finished, CandidateProfile profile, Scenario scenario) {
        this.finished = finished;
        this.profile = profile;
        this.scenario = scenario;
    }

    public TaskStatus getFinished() {
        return finished;
    }

    public void setFinished(TaskStatus finished) {
        this.finished = finished;
    }

    public CandidateProfile getProfile() {
        return profile;
    }

    public void setProfile(CandidateProfile profile) {
        this.profile = profile;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
}
