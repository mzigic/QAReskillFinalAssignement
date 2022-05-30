package com.projectname.e2e.tests.pages.sandbox;

import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

public class LoginPage extends PageBase {

    private final By submitLoadingButton = By.cssSelector(".landing .full-width-btn");
    private final By submitLoadingSpinner = By.cssSelector(".loading-btn > .spinner-border");

    public LoginPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    public LoginPage(CustomWebDriver driver, String email, String password) {
        this(driver, "", email, password);
    }

    @Override
    public PageBase show() {
        if (!isDisplayed()) {
            sandboxNavigationBar.logout();
            logStep("INFO: User is logged out in order to navigate to Login page");
        }

        driver.waitForVisibilityOf(getLoginForm());

        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(submitLoadingButton, driver) &&
                driver.getCurrentUrl().contains("/login");
    }

    private void waitForEmailInput(){
        driver.waitForElementToBePresent(CustomBy.cssSelector("[href='/login']"));
        driver.waitForVisibilityOf(getEmailInput());
    }

    public DashboardPage loginWith(String email, String password){
        waitForEmailInput();
        //you can directly send characters, but idea with click is to see mouse follow from one element to another
        // since that action is triggered on click
        logStep("INFO: Enter email");
        getEmailInput().click();
        getEmailInput().clear();
        getEmailInput().sendKeys(email);

        logStep("INFO: Enter password");
        getPasswordInput().click();
        getPasswordInput().clear();
        getPasswordInput().sendKeys(password);

        logStep("INFO: Submit login form");
        getSubmitLoginButton().click();
        driver.waitForElementToDisappear(submitLoadingSpinner);
        logStep("PASS: Login form submitted");
        return new DashboardPage(driver, url, email, password);
    }

    public ForgotPasswordPage proceedToForgotPasswordForm(){
        logStep("INFO: Click at Forgot Password link");
        getForgotPasswordLink().click();
        driver.waitUntilURLContains("/forgot-password");
        logStep("PASS: Forgot Password page displayed");
        return new ForgotPasswordPage(driver);
    }

    private WebElement getEmailInput() {
        try {
            return driver.findElement(CustomBy.name("email"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find email input field on Login Page", e);
        }
    }

    private WebElement getPasswordInput() {
        try {
            return driver.findElement(CustomBy.name("password"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find password input field on Login page", e);
        }
    }

    private WebElement getRememberMeToggle(){
        try {
            return driver.findElement(CustomBy.className("react-switch-bg"));
        } catch(Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Remember Me toggle on Login page", e);
        }
    }

    private WebElement getSubmitLoginButton(){
        try {
            return driver.findElement(CustomBy.className("full-width-btn"));
        } catch(Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Submit Login button on Login page", e);
        }
    }

    private WebElement getForgotPasswordLink(){
        try {
            return driver.findElement(CustomBy.cssSelector("[href='/forgot-password']"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Forgot Password link on Login page", e);
        }
    }

    private WebElement getValidationErrorMessage(){
        try {
            return driver.findElement(CustomBy.id("validation-msg"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find validation error message.");
        }
    }

    private WebElement getLoginForm(){
        try{
            return driver.findElement(CustomBy.cssSelector(".main>.landing"));
        }catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find login form.");
        }
    }

    public String getValidationMessage(){
        return getValidationErrorMessage().getText();
    }
}
