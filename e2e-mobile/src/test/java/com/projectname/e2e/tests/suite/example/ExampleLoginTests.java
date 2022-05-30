package com.projectname.e2e.tests.suite.example;

import com.projectname.e2e.tests.environment.ConfigSetup;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.projectname.e2e.tests.screens.example.ExampleDashboardScreen;
import com.projectname.e2e.tests.screens.example.ExampleLoginScreen;
import com.projectname.e2e.tests.suite.common.BaseSuite;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

public class ExampleLoginTests extends BaseSuite {


    @Test(groups = {"android", "ios"})
    @Description("Verify that user is successfully logged in the app")
    public void verifySuccessfulLogin() {
        ExampleLoginScreen exampleLoginScreen = new ExampleLoginScreen(this.driver, this.platform, ConfigSetup.getDefaultUser(), ConfigSetup.getDefaultPsw());

        logStep("INFO: Login in the app");
        ExampleDashboardScreen exampleDashboardScreen = exampleLoginScreen.login(ConfigSetup.getDefaultUser(), ConfigSetup.getDefaultPsw());
        logStep("PASS: User is successfully logged in");

        logStep("INFO: Verify that user is logged in");
        Assert.assertTrue(exampleDashboardScreen.isDisplayed(), "Dashboard screen is not displayed");
        logStep("PASS: User is logged in");
    }
}
