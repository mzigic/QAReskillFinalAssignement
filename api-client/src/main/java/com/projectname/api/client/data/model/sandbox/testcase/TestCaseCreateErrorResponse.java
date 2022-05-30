package com.projectname.api.client.data.model.sandbox.testcase;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class TestCaseCreateErrorResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -7689940763438807437L;

    @SerializedName("title")
    private String titleRequiredMsg;

    @SerializedName("expected_result")
    private String expectedResultRequiredMsg;

    @SerializedName("test_steps")
    private String testStepsRequiredMsg;

    public TestCaseCreateErrorResponse() {
    }

    public TestCaseCreateErrorResponse(String titleRequiredMsg, String expectedResultRequiredMsg, String testStepsRequiredMsg) {
        this.titleRequiredMsg = titleRequiredMsg;
        this.expectedResultRequiredMsg = expectedResultRequiredMsg;
        this.testStepsRequiredMsg = testStepsRequiredMsg;
    }

    public String getTitleRequiredMsg() {
        return titleRequiredMsg;
    }

    public void setTitleRequiredMsg(String titleRequiredMsg) {
        this.titleRequiredMsg = titleRequiredMsg;
    }

    public String getExpectedResultRequiredMsg() {
        return expectedResultRequiredMsg;
    }

    public void setExpectedResultRequiredMsg(String expectedResultRequiredMsg) {
        this.expectedResultRequiredMsg = expectedResultRequiredMsg;
    }

    public String getTestStepsRequiredMsg() {
        return testStepsRequiredMsg;
    }

    public void setTestStepsRequiredMsg(String testStepsRequiredMsg) {
        this.testStepsRequiredMsg = testStepsRequiredMsg;
    }
}
