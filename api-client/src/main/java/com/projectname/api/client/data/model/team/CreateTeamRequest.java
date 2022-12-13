package com.projectname.api.client.data.model.team;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateTeamRequest {
    @SerializedName("title")
    @Expose
    private String title;
    private final static long serialVersionUID = 9080203777947693267L;

    public CreateTeamRequest() {
    }

    public CreateTeamRequest(String title) {
        super();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
