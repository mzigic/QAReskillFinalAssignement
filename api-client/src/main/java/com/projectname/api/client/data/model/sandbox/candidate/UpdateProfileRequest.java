package com.projectname.api.client.data.model.sandbox.candidate;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.io.Serializable;

public class UpdateProfileRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -1179553616300075440L;

    @SerializedName("biography")
    private String biography;

    @SerializedName("career_status_id")
    private Integer careerStatusId;

    @SerializedName("city_id")
    private Integer cityId;

    @SerializedName("github_username")
    private String githubUserName;

    public UpdateProfileRequest() {
    }

    public UpdateProfileRequest(String biography, Integer careerStatusId, Integer cityId, String githubUserName) {
        this.biography = biography;
        this.careerStatusId = careerStatusId;
        this.cityId = cityId;
        this.githubUserName = githubUserName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getCareerStatusId() {
        return careerStatusId;
    }

    public void setCareerStatusId(Integer careerStatusId) {
        this.careerStatusId = careerStatusId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getGithubUserName() {
        return githubUserName;
    }

    public void setGithubUserName(String githubUserName) {
        this.githubUserName = githubUserName;
    }
}
