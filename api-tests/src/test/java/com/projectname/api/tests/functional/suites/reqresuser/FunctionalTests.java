package com.projectname.api.tests.functional.suites.reqresuser;

import com.projectname.api.client.calls.UserAPI;
import com.projectname.api.client.data.model.users.create.CreateUserRequest;
import com.projectname.api.client.data.model.users.create.CreateUserResponse;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.data.provider.UserProvider;
import com.projectname.api.tests.functional.asserts.UserAssert;
import com.projectname.api.tests.init.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

// each test class should extend TestBase class in order to inherit all common behaviors and to be logged properly in report
// this sample test class implement api calls from https://reqres.in/ site
// for proper usage, apiBaseUrl needs to be set in ConfigSetup class
// test methods in this class calls rest assured methods, without authorization, in background
public class FunctionalTests extends TestBase {

    // each test case should be simple, readable, in few lines and without any to technical steps
    // It should represent user actions like as those are done manually on UI
    @Test(groups = {"regression", "smoke"})
    @Description("Allure description for this test")
    public static void verifyCreateUser() {
        LocalDateTime date = LocalDateTime.now();

        CreateUserRequest createUserRequest = new CreateUserRequest("John Doe" + date, "QA Engineer");

        logStep("INFO: Create user");
        CreateUserResponse createdUserActual = UserAPI.createUser(createUserRequest);
        logStep("PASS: User is created");

        CreateUserResponse createdUserExpected = CreateUserResponse.parseCreatedUser(createUserRequest);

        UserAssert userAssert = new UserAssert();
        logStep("INFO: Verify user is created");
        userAssert.assertCreatedUser(createdUserActual, createdUserExpected);
        logStep("PASS: Response is verified");
    }

    // test-case with data provider usage as example for data-driven testing support
    @Test(groups = {"regression", "smoke"}, dataProvider = DataProviderNames.VERIFY_CREATE_USER, dataProviderClass = UserProvider.class)
    @Description("Verify can create user")
    public static void verifyCreateUserWithDataProvider(String methodNameSuffix, CreateUserRequest createUserRequest) {

        logStep("INFO: Create user");
        CreateUserResponse createdUserActual = UserAPI.createUser(createUserRequest);
        logStep("PASS: User is created");

        CreateUserResponse createdUserExpected = CreateUserResponse.parseCreatedUser(createUserRequest);

        UserAssert userAssert = new UserAssert();
        logStep("INFO: Verify user is created");
        userAssert.assertCreatedUser(createdUserActual, createdUserExpected);
        logStep("PASS: Response is verified");
    }

    // send the wrong user id on purpose to get a 404 error from the server
    @Test
    public void verifyTestWillReturnError() {
        UserAPI.getUserById("55");
    }

    @Test
    public void verifyAssertWillFail() {
        LocalDateTime date = LocalDateTime.now();
        CreateUserRequest createUserRequest = new CreateUserRequest("milos" + date, "QA Engineer");
        CreateUserResponse actualResponse = UserAPI.createUser(createUserRequest);
        CreateUserResponse expectedResponse = CreateUserResponse.parseCreatedUser(createUserRequest);

        // hardcoded data on purpose to fail the assertion
        expectedResponse.setName("Made up name");

        UserAssert userAssert = new UserAssert();
        logStep("INFO: Verify user is created");
        userAssert.assertCreatedUser(actualResponse, expectedResponse);
        logStep("PASS: Response is verified");
    }

}
