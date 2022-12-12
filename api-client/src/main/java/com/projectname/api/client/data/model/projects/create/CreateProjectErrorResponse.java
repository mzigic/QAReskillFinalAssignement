package com.projectname.api.client.data.model.projects.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CreateProjectErrorResponse implements Serializable {

    @SerializedName("title")
    @Expose
    private String title;
    private final static long serialVersionUID = -86196845735121616L;

    public CreateProjectErrorResponse() {
    }

    public CreateProjectErrorResponse(String title) {
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