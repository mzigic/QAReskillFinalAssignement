package com.projectname.e2e.tests.data.model.example;

import com.projectname.api.client.data.model.users.create.CreateUserRequest;

import java.io.Serializable;

public class ExampleCreatedUserDetailsOnDashboardScreen implements Serializable {
    private String name;
    private String job;

    public ExampleCreatedUserDetailsOnDashboardScreen() {

    }

    public ExampleCreatedUserDetailsOnDashboardScreen(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public static ExampleCreatedUserDetailsOnDashboardScreen parseExpectedExampleCreatedUserDetailsOnDashboardScreen(CreateUserRequest userRequest) {
        ExampleCreatedUserDetailsOnDashboardScreen exampleCreatedUserDetailsOnDashboardScreen = new ExampleCreatedUserDetailsOnDashboardScreen();
        exampleCreatedUserDetailsOnDashboardScreen.setName(userRequest.getName());
        exampleCreatedUserDetailsOnDashboardScreen.setJob(userRequest.getJob());
        return exampleCreatedUserDetailsOnDashboardScreen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
