package com.projectname.api.client.data.model.sandbox.common;

import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.annotations.ResponseRequiredField;

import java.io.Serial;
import java.io.Serializable;

public class TestCaseStep implements Serializable {
    @Serial
    private static final long serialVersionUID = -8857941658727551593L;

    @SerializedName("id")
    @ResponseRequiredField(canBeEmpty = false)
    private Integer id;

    @SerializedName("value")
    @ResponseRequiredField(canBeEmpty = false)
    private String value;

    @SerializedName("testcase_id")
    private Integer testCaseId;

    public TestCaseStep() {
    }

    public TestCaseStep(Integer id, String value, Integer testCaseId) {
        this(id, value);
        this.testCaseId = testCaseId;
    }

    public TestCaseStep(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(Integer testCaseId) {
        this.testCaseId = testCaseId;
    }
}
