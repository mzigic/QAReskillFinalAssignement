package com.projectname.e2e.tests.suites.sandbox;

import com.projectname.e2e.tests.constants.ErrorMessages;
import com.projectname.e2e.tests.environment.ConfigSetup;
import com.projectname.e2e.tests.pages.sandbox.DashboardPage;
import com.projectname.e2e.tests.pages.sandbox.LoginPage;
import com.projectname.e2e.tests.pages.sandbox.HomePage;
import com.projectname.e2e.tests.suites.common.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.projectname.api.client.utils.reporting.Allure.logStep;
import static com.projectname.e2e.tests.data.provider.sandbox.LoginProvider.*;

public class LoginTests extends TestBase {

    @Test(groups = {"smoke", "ui" })
    @Description("Verify login")
    @Feature("Login")
    public void verifyLogin() {
        logStep("INFO: Fetch home page");
        HomePage homePage = new HomePage(getDriver(), "", ConfigSetup.getUser(), ConfigSetup.getUserPsw());
        homePage.show();
        logStep("PASS: Home page is fetched");

        logStep("INFO: Fetch login page");
        LoginPage loginPage = homePage.proceedToCandidateLoginPage();
        loginPage.show();
        logStep("PASS: Login page is fetched");

        DashboardPage sandboxDashboardPage = loginPage.loginWith(ConfigSetup.getUser(), ConfigSetup.getUserPsw());
        logStep("INFO: Verify Dashboard page is shown");
        Assert.assertTrue(sandboxDashboardPage.isDisplayed(), "Dashboard page is not fetched");
        logStep("PASS: Dashboard page is fetched -  Login with valid credentials is verified");
    }

    @Test(groups = {"smoke", "ui" })
    @Description("Verify login")
    @Feature("Login")
    public void verifyLoginFailsForInvalidEmailPasswordCombination() {

        logStep("INFO: Fetch home page");
        HomePage homePage = new HomePage(getDriver(), "", INVALID_EMAIL, INVALID_PSW);
        homePage.show();
        logStep("PASS: Home page is fetched");

        logStep("INFO: Fetch login page");
        LoginPage loginPage = homePage.proceedToCandidateLoginPage();
        loginPage.show();
        logStep("PASS: Login page is fetched");

        loginPage.loginWith(INVALID_EMAIL, INVALID_PSW);

        logStep("INFO: Verify User not authorized message is shown");
        Assert.assertEquals(
                loginPage.getValidationMessage(),
                ErrorMessages.userIsNotAuthorizedMsg(INVALID_EMAIL),
                "User not authorized message isn't verified"
        );
        logStep("PASS: User not authorized message is shown - Login with invalid credentials is verified");

    }

    @Test(groups = {"smoke", "ui" })
    @Description("Verify login")
    @Feature("Login")
    public void verifyLogout() {

        logStep("INFO: Fetch login page");
        LoginPage loginPage = new LoginPage(getDriver(), "", ConfigSetup.getUser(), ConfigSetup.getUserPsw());
        loginPage.show();
        logStep("PASS: Login page is fetched");

        loginPage.loginWith(ConfigSetup.getUser(), ConfigSetup.getUserPsw());

        logStep("INFO: User try to logout");
        loginPage.getNavigationBar().logout();
        logStep("PASS: User logged out - Logout is verified");
    }
}
