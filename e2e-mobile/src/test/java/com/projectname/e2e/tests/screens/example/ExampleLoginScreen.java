package com.projectname.e2e.tests.screens.example;

import com.projectname.e2e.tests.common.UIMap;
import com.projectname.e2e.tests.data.model.common.Screen;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import com.projectname.e2e.tests.screens.common.BaseScreen;

import java.util.concurrent.TimeUnit;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

public class ExampleLoginScreen extends BaseScreen {
    public ExampleLoginScreen(AppiumDriver driver, String platform, String username, String password) {
        super(driver, platform, username, password);
    }

    @Override
    public BaseScreen show() {
        return this;
    }

    @Override
    public boolean isDisplayed() {
        try {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            this.driver.findElement(UIMap.getLocator("loginScreen", this.platform));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public WebElement getScreen() {
        try {
            return this.driver.findElement(UIMap.getLocator("loginScreen", this.platform));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find login screen root", e);
        }
    }

    private WebElement getInputEmail(WebElement screen) {
        return this.fetchElement("loginScreen.inpUsername", screen, Screen.EXAMPLE_LOGIN.getName());
    }

    private WebElement getInputPassword(WebElement screen) {
        return this.fetchElement("loginScreen.inpPassword", screen, Screen.EXAMPLE_LOGIN.getName());
    }

    private WebElement getButtonLogin(WebElement screen) {
        return this.fetchElement("loginScreen.btnLogin", screen, Screen.EXAMPLE_LOGIN.getName());
    }

    public  ExampleDashboardScreen login(String userName, String password) {
        logStep("INFO: Enter email: " + userName);
        WebElement weEmail = this.getInputEmail(this.getScreen());
        weEmail.click();
        weEmail.clear();
        weEmail.sendKeys(userName);
        logStep("PASS: Email is entered");

        logStep("INFO: Enter password: *********");
        WebElement wePass = this.getInputPassword(this.getScreen());
        wePass.click();
        wePass.clear();
        wePass.sendKeys(password);
        logStep("PASS: Password is entered");

        logStep("INFO: Press login button");
        this.getButtonLogin(this.getScreen()).click();
        logStep("PASS: Login button is pressed");

        return new ExampleDashboardScreen(this.driver, this.platform, this.username, this.password);
    }
}
