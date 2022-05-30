package com.projectname.api.client.data.model.sandbox.common;

import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.annotations.ResponseRequiredField;

import java.io.Serial;
import java.io.Serializable;

public class CommonErrorResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -5665399941855393906L;

    @SerializedName("error")
    @ResponseRequiredField(canBeEmpty = false)
    private String error;

    public CommonErrorResponse() {
    }

    public CommonErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
