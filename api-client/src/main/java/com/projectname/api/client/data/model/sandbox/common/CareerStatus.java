package com.projectname.api.client.data.model.sandbox.common;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class CareerStatus implements Serializable {
    @Serial
    private static final long serialVersionUID = 8367546632025134662L;

    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    public CareerStatus() {
    }

    public CareerStatus(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
