package com.projectname.api.client.data.model.projects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProjectRequiredFieldErrorResponse implements Serializable {

    @SerializedName("title")
    @Expose
    private String title;
    private final static long serialVersionUID = -86196845735121616L;

    public ProjectRequiredFieldErrorResponse() {
    }

    public ProjectRequiredFieldErrorResponse(String title) {
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