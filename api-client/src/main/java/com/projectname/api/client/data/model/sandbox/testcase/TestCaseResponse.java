package com.projectname.api.client.data.model.sandbox.testcase;

import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.annotations.ResponseRequiredField;
import com.projectname.api.client.data.model.sandbox.common.TestCaseStep;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class TestCaseResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 8437997560019547421L;

    @SerializedName("automated")
    @ResponseRequiredField(canBeEmpty = false)
    private Boolean automated;

    @SerializedName("candidate_id")
    @ResponseRequiredField(canBeEmpty = false)
    private Integer candidateId;

    @SerializedName("candidate_scenario_id")
    @ResponseRequiredField(canBeEmpty = false)
    private Integer candidateScenarioId;

    @SerializedName("description")
    private String description;

    @SerializedName("expected_result")
    private String expectedResult;

    @SerializedName("id")
    @ResponseRequiredField(canBeEmpty = false)
    private Integer id;

    @SerializedName("test_steps")
    @ResponseRequiredField(canBeEmpty = false)
    private List<TestCaseStep> testSteps;

    @SerializedName("title")
    @ResponseRequiredField(canBeEmpty = false)
    private String title;

    public TestCaseResponse() {
    }

    public TestCaseResponse(Boolean automated, Integer candidateId, Integer candidateScenarioId, String description, String expectedResult, Integer id, List<TestCaseStep> testSteps, String title) {
        this.automated = automated;
        this.candidateId = candidateId;
        this.candidateScenarioId = candidateScenarioId;
        this.description = description;
        this.expectedResult = expectedResult;
        this.id = id;
        this.testSteps = testSteps;
        this.title = title;
    }

    public Boolean getAutomated() {
        return automated;
    }

    public void setAutomated(Boolean automated) {
        this.automated = automated;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TestCaseStep> getTestSteps() {
        return testSteps;
    }

    public void setTestSteps(List<TestCaseStep> testSteps) {
        this.testSteps = testSteps;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static TestCaseResponse parseFromCreatedTestCase(TestCaseCreateRequest testCaseCreateRequest){
        TestCaseResponse testCaseResponse = new TestCaseResponse();
        testCaseResponse.setAutomated(testCaseCreateRequest.getAutomated());
        testCaseResponse.setTestSteps(testCaseCreateRequest.getTestSteps());
        testCaseResponse.setTitle(testCaseCreateRequest.getTitle());
        testCaseResponse.setExpectedResult(testCaseCreateRequest.getExpectedResult());
        testCaseResponse.setDescription(testCaseCreateRequest.getDescription());
        return testCaseResponse;
    }
}
