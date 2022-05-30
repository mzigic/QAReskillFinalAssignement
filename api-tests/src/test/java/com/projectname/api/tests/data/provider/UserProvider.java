package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.users.create.CreateUserRequest;
import com.projectname.api.client.utils.helpers.RandomDataGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import org.testng.annotations.DataProvider;

import java.time.LocalDateTime;

public class UserProvider {

    @DataProvider(name = DataProviderNames.VERIFY_CREATE_USER)
    public static Object[][] verifyCreateUser() {
        LocalDateTime date = LocalDateTime.now();
        return new Object[][]{
                {"WithRandomNameAndJob", new CreateUserRequest(RandomDataGenerator.createRandomStringAlphanumericWithLen(5),
                        RandomDataGenerator.createRandomStringAlphanumericWithLen(5))},
                {"AsQaAutomationEngineer", new CreateUserRequest("Jason Kidd " + date,
                        "QA Automation Engineer")},
        };
    }

}
