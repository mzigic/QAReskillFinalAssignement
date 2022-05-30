package com.projectname.api.client.data.model.sandbox.testcase;

import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.annotations.ResponseRequiredField;

import java.io.Serial;
import java.io.Serializable;

public class TestCaseNotFoundResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -250611724415072702L;

    @SerializedName("error")
    @ResponseRequiredField(canBeEmpty = false)
    private String error;

    public TestCaseNotFoundResponse() {
    }

    public TestCaseNotFoundResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
