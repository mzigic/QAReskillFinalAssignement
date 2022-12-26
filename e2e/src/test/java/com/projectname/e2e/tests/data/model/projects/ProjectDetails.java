package com.projectname.e2e.tests.data.model.projects;

public class ProjectDetails {
    private String title;
    private String technology;
    private String seniority;
    private String team;
    private String person;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProjectDetails() {

    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public static ProjectDetails parseExpectedDetails(CreateProjectRequest projectRequest) {
        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setTitle(projectRequest.getTitle());
        return projectDetails;
    }
}
