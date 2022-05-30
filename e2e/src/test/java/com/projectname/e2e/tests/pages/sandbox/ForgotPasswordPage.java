package com.projectname.e2e.tests.pages.sandbox;

import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends PageBase {

    private final By forgotPasswordEmailInput = CustomBy.name("email");

    public ForgotPasswordPage(CustomWebDriver driver) {
        super(driver, "", "", "");
    }

    @Override
    public PageBase show() {
        if(!isDisplayed()){

            HomePage homePage = new HomePage(driver, "", email, password);

            if(sandboxNavigationBar.isDisplayed()){
                sandboxNavigationBar.logout();
            }else if(homePage.isDisplayed()){
                homePage.proceedToCandidateLoginPage();
            }
            new LoginPage(driver, email, password).proceedToForgotPasswordForm();
        }

        driver.waitForElementToBePresent(forgotPasswordEmailInput);

        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(forgotPasswordEmailInput, driver) &&
                driver.getCurrentUrl().contains("/forgot-password");
    }

    private WebElement getValidationErrorMessage(){
        try {
            return driver.findElement(CustomBy.id("validation-msg"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find validation error message.");
        }
    }

    private WebElement getForgotPasswordEmailInput(){
        try{
            return driver.findElement(CustomBy.name("email"));
        }catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find email input on forgot password form.");
        }
    }

    private WebElement getForgotPasswordSendButton(){
        try{
            return driver.findElement(CustomBy.cssSelector(".landing>button"));
        }catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find send button.");
        }
    }

    public String getForgotPasswordEmailValidationMessage(){
        return getValidationErrorMessage().getText();
    }

    public void sendInstructionsTo(String email){
        getForgotPasswordEmailInput().click();
        getForgotPasswordEmailInput().clear();
        getForgotPasswordEmailInput().sendKeys(email);
        getForgotPasswordSendButton().click();
    }

}
