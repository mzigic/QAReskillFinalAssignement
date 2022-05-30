package com.projectname.api.client.data.model.sandbox.common;

import com.google.gson.annotations.SerializedName;
import com.projectname.api.client.annotations.ResponseRequiredField;

import java.io.Serial;
import java.io.Serializable;

public class CandidateProfile implements Serializable {
    @Serial
    private static final long serialVersionUID = 205872818257069369L;

    @SerializedName("biography")
    private String biography;

    @SerializedName("career_status")
    private CareerStatus careerStatus;

    @SerializedName("career_status_id")
    private Integer careerStatusId;

    @SerializedName("city")
    private City city;

    @SerializedName("city_id")
    private Integer cityId;

    @ResponseRequiredField(canBeEmpty = false)
    @SerializedName("email")
    private String email;

    @ResponseRequiredField(canBeEmpty = false)
    @SerializedName("first_name")
    private String firstName;

    @SerializedName("github_username")
    private String githubUsername;

    @SerializedName("id")
    private Integer id;

    @SerializedName("img")
    private String img;

    @ResponseRequiredField(canBeEmpty = false)
    @SerializedName("last_name")
    private String lastName;

    public CandidateProfile() {
    }

    public CandidateProfile(String email, String firstName, Integer id, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
    }

    public CandidateProfile(String biography, CareerStatus careerStatus, Integer careerStatusId, City city, Integer cityId, String email, String firstName, String githubUsername, Integer id, String img, String lastName) {
        this.biography = biography;
        this.careerStatus = careerStatus;
        this.careerStatusId = careerStatusId;
        this.city = city;
        this.cityId = cityId;
        this.email = email;
        this.firstName = firstName;
        this.githubUsername = githubUsername;
        this.id = id;
        this.img = img;
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public CareerStatus getCareerStatus() {
        return careerStatus;
    }

    public void setCareerStatus(CareerStatus careerStatus) {
        this.careerStatus = careerStatus;
    }

    public Integer getCareerStatusId() {
        return careerStatusId;
    }

    public void setCareerStatusId(Integer careerStatusId) {
        this.careerStatusId = careerStatusId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGithubUsername() {
        return githubUsername;
    }

    public void setGithubUsername(String githubUsername) {
        this.githubUsername = githubUsername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
