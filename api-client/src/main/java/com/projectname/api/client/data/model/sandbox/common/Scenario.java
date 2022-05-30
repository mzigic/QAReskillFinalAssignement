package com.projectname.api.client.data.model.sandbox.common;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class Scenario implements Serializable {

    @Serial
    private static final long serialVersionUID = 4719510085175121149L;

    @SerializedName("automated_count")
    private Integer automatedCount;

    @SerializedName("exam_type")
    private Integer examType;

    @SerializedName("id")
    private Integer id;

    @SerializedName("office_id")
    private Integer officeId;

    @SerializedName("report_count")
    private Integer reportCount;

    @SerializedName("scenario")
    private String scenario;

    @SerializedName("scenario_plain")
    private String scenarioPlain;

    @SerializedName("test_case_count")
    private Integer testCaseCount;

    @SerializedName("title")
    private String title;

    @SerializedName("user_id")
    private Integer userId;

    public Scenario() {
    }

    public Scenario(Integer automatedCount, Integer examType, Integer id, Integer officeId, Integer reportCount, String scenario, String scenarioPlain, Integer testCaseCount, String title, Integer userId) {
        this.automatedCount = automatedCount;
        this.examType = examType;
        this.id = id;
        this.officeId = officeId;
        this.reportCount = reportCount;
        this.scenario = scenario;
        this.scenarioPlain = scenarioPlain;
        this.testCaseCount = testCaseCount;
        this.title = title;
        this.userId = userId;
    }

    public Integer getAutomatedCount() {
        return automatedCount;
    }

    public void setAutomatedCount(Integer automatedCount) {
        this.automatedCount = automatedCount;
    }

    public Integer getExamType() {
        return examType;
    }

    public void setExamType(Integer examType) {
        this.examType = examType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Integer getReportCount() {
        return reportCount;
    }

    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getScenarioPlain() {
        return scenarioPlain;
    }

    public void setScenarioPlain(String scenarioPlain) {
        this.scenarioPlain = scenarioPlain;
    }

    public Integer getTestCaseCount() {
        return testCaseCount;
    }

    public void setTestCaseCount(Integer testCaseCount) {
        this.testCaseCount = testCaseCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
