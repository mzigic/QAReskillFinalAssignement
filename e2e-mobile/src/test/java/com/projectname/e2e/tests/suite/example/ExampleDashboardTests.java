package com.projectname.e2e.tests.suite.example;

import com.projectname.api.client.data.model.users.create.CreateUserRequest;
import com.projectname.e2e.tests.asserts.ExampleDashboardAssert;
import com.projectname.e2e.tests.data.model.example.ExampleCreatedUserDetailsOnDashboardScreen;
import com.projectname.e2e.tests.data.model.example.ExampleDashboardScreenDetails;
import com.projectname.e2e.tests.data.provider.ExampleDashboardScreenProvider;
import com.projectname.e2e.tests.environment.ConfigSetup;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.projectname.e2e.tests.screens.example.ExampleDashboardScreen;
import com.projectname.e2e.tests.suite.common.BaseSuite;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

public class ExampleDashboardTests extends BaseSuite {

    ExampleDashboardScreen exampleDashboardScreen;
    ExampleDashboardAssert exampleDashboardAssert;


    @BeforeClass(groups = {"android", "ios"})
    public void prepareDataForTest() {
        exampleDashboardScreen = new ExampleDashboardScreen(this.driver, this.platform, ConfigSetup.getDefaultUser(), ConfigSetup.getDefaultPsw());
        exampleDashboardAssert = new ExampleDashboardAssert();
    }

    @Test(groups = {"android", "ios"})
    @Description("Verify that user data on dashboard screen are correct")
    public void verifyUserDataOnDashboardScreen() {
        Object getSingleUserInfo = "Here rest assured functions will be called to fetch correct user data";

        logStep("INFO: Fetch actual user data from dashboard screen");
        ExampleDashboardScreenDetails actualExampleDashboardScreenDetails = exampleDashboardScreen.getActualDetailsFromDashboardScreen();
        logStep("PASS: User data are fetched");

        ExampleDashboardScreenDetails expectedExampleDashboardScreenDetails = ExampleDashboardScreenDetails.parseExampleDashboardScreenDetails(getSingleUserInfo);

        logStep("INFO: Verify that user data from dashboard screen are correct");
        exampleDashboardAssert.assertUserDetailsOnDashboardScreen(actualExampleDashboardScreenDetails, expectedExampleDashboardScreenDetails);
        logStep("PASS: User data are correct");
    }

    @Test(groups = {"android", "ios"})
    @Description("Verify user is created from Dashboard screen")
    public void verifyUserIsCreated() {
        CreateUserRequest userRequest = ExampleDashboardScreenProvider.prepareCreateUserRequest();

        logStep("INFO: Create user from dashboard screen");
        exampleDashboardScreen.createUserFromDashboard(userRequest.getName(), userRequest.getJob());
        logStep("PASS: User is successfully created");

        logStep("INFO: Fetch actual data for recently created user");
        ExampleCreatedUserDetailsOnDashboardScreen actualExampleCreatedUserDetailsOnDashboardScreen = exampleDashboardScreen.getActualDetailsOfCreatedUser();
        logStep("PASS: Data are fetched");

        ExampleCreatedUserDetailsOnDashboardScreen expectedExampleCreatedUserDetailsOnDashboardScreen = ExampleCreatedUserDetailsOnDashboardScreen.parseExpectedExampleCreatedUserDetailsOnDashboardScreen(userRequest);

        logStep("INFO: Verify that user is created");
        exampleDashboardAssert.assertCreatedUserOnDashboardScreen(actualExampleCreatedUserDetailsOnDashboardScreen, expectedExampleCreatedUserDetailsOnDashboardScreen);
        logStep("PASS: User is created successfully");
    }
}
