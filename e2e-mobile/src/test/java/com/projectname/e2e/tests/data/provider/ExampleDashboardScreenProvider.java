package com.projectname.e2e.tests.data.provider;

import com.projectname.api.client.data.model.users.create.CreateUserRequest;
import com.projectname.api.client.utils.helpers.RandomDataGenerator;

public class ExampleDashboardScreenProvider {

    public static CreateUserRequest prepareCreateUserRequest() {
        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setName(RandomDataGenerator.createRandomStringWithLen(7));
        userRequest.setJob(RandomDataGenerator.createRandomStringWithLen(5));
        return userRequest;
    }
}
