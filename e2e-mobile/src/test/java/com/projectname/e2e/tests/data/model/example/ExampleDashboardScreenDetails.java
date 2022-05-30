package com.projectname.e2e.tests.data.model.example;

import java.io.Serializable;

public class ExampleDashboardScreenDetails implements Serializable {
    private String userName;
    private String userEmail;
    private boolean hideEmailSwitch;

    public ExampleDashboardScreenDetails() {

    }

    public ExampleDashboardScreenDetails(String userName, String userEmail, boolean hideEmailSwitch) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.hideEmailSwitch = hideEmailSwitch;
    }

    public static ExampleDashboardScreenDetails parseExampleDashboardScreenDetails(Object dashboardResponseThatContainsValuesForThisFields) {
        // Creating expected model by parsing actual data from api response
        ExampleDashboardScreenDetails exampleDashboardScreenDetails = new ExampleDashboardScreenDetails();
        exampleDashboardScreenDetails.setUserEmail("Email from dashboard response");
        exampleDashboardScreenDetails.setUserName("User name from dashboard response");
        exampleDashboardScreenDetails.setHideEmailSwitch(true);
        return exampleDashboardScreenDetails;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean isHideEmailSwitch() {
        return hideEmailSwitch;
    }

    public void setHideEmailSwitch(boolean hideEmailSwitch) {
        this.hideEmailSwitch = hideEmailSwitch;
    }
}
