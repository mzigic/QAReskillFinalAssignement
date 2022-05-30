package com.projectname.api.client.data.model.sandbox.testcase;

import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.annotations.ResponseRequiredField;

import java.io.Serial;
import java.io.Serializable;

public class TestCaseDeleteResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -7689940763438807437L;

    @ResponseRequiredField(canBeEmpty = false)
    @SerializedName("success")
    private String message;

    public TestCaseDeleteResponse() {
    }

    public TestCaseDeleteResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
