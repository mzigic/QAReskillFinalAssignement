package com.projectname.e2e.tests.data.model.projects;

public class ProjectDetails {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProjectDetails() {

    }

    public static ProjectDetails parseExpectedDetails(CreateProjectRequest projectRequest) {
        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setTitle(projectRequest.getTitle());
        return projectDetails;
    }
}
