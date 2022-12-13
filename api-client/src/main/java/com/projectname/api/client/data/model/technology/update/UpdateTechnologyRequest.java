package com.projectname.api.client.data.model.technology.update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UpdateTechnologyRequest implements Serializable {

    @SerializedName("title")
    @Expose
    private String title;
    private final static long serialVersionUID = 8808003375303793479L;

    public UpdateTechnologyRequest() {
    }

    public UpdateTechnologyRequest(String title) {
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