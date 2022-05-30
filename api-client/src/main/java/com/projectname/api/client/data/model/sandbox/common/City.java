package com.projectname.api.client.data.model.sandbox.common;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class City implements Serializable {

    @Serial
    private static final long serialVersionUID = 4934620751287096871L;

    @SerializedName("id")
    private Integer cityId;

    @SerializedName("value")
    private String value;

    public City() {
    }

    public City(Integer cityId, String value) {
        this.cityId = cityId;
        this.value = value;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
