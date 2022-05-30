package com.projectname.api.client.data.model.sandbox.common;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class TaskStatus implements Serializable {
    @Serial
    private static final long serialVersionUID = -5772524901844726947L;

    @SerializedName("projects")
    private Boolean projects;

    @SerializedName("reports")
    private Boolean reports;

    @SerializedName("testcases")
    private Integer testCases;

    public TaskStatus() {
    }

    public TaskStatus(Boolean projects, Boolean reports, Integer testCases) {
        this.projects = projects;
        this.reports = reports;
        this.testCases = testCases;
    }

    public Boolean getProjects() {
        return projects;
    }

    public void setProjects(Boolean projects) {
        this.projects = projects;
    }

    public Boolean getReports() {
        return reports;
    }

    public void setReports(Boolean reports) {
        this.reports = reports;
    }

    public Integer getTestCases() {
        return testCases;
    }

    public void setTestCases(Integer testCases) {
        this.testCases = testCases;
    }
}
