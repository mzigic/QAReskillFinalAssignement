package com.projectname.api.client.data.model.sandbox.candidate;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class CandidateLoginRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 2288397918420037457L;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public CandidateLoginRequest() {
    }

    public CandidateLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
