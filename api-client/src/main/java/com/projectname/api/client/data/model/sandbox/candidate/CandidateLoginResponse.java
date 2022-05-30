package com.projectname.api.client.data.model.sandbox.candidate;

import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.annotations.ResponseRequiredField;

import java.io.Serial;
import java.io.Serializable;

public class CandidateLoginResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -3499445339016778914L;

    @SerializedName("refreshToken")
    @ResponseRequiredField(canBeEmpty = false)
    private String refreshToken;

    @SerializedName("success")
    @ResponseRequiredField(canBeEmpty = false)
    private Boolean success;

    @SerializedName("token")
    @ResponseRequiredField(canBeEmpty = false)
    private String token;

    public CandidateLoginResponse() {
    }

    public CandidateLoginResponse(String refreshToken, Boolean success, String token) {
        this.refreshToken = refreshToken;
        this.success = success;
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
