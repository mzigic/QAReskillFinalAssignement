package com.projectname.api.client.data.model.sandbox.testcase;

import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.data.model.sandbox.common.TestCaseStep;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class TestCaseCreateRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1394712138598647255L;

    @SerializedName("automated")
    private Boolean automated;

    @SerializedName("description")
    private String description;

    @SerializedName("expected_result")
    private String expectedResult;

    @SerializedName("test_steps")
    private List<TestCaseStep> testSteps;

    @SerializedName("title")
    private String title;

    public TestCaseCreateRequest() {
    }

    public TestCaseCreateRequest(String expectedResult, List<TestCaseStep> testSteps, String title) {
        this.expectedResult = expectedResult;
        this.testSteps = testSteps;
        this.title = title;
    }

    public TestCaseCreateRequest(Boolean automated, String description, String expectedResult, List<TestCaseStep> testSteps, String title) {
        this(expectedResult, testSteps, title);
        this.automated = automated;
        this.description = description;
    }

    public TestCaseCreateRequest(Boolean automated, String expectedResult, List<TestCaseStep> testSteps, String title) {
        this(false, "", expectedResult, testSteps, title);
    }

    public Boolean getAutomated() {
        return automated;
    }

    public void setAutomated(Boolean automated) {
        this.automated = automated;
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
}
