package com.projectname.e2e.tests.pages.sandbox;

import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

public class HomePage extends PageBase {

    private By homePageButtonsContainer = CustomBy.cssSelector(".landing .landing-buttons");
    private final String BASE_URL = "https://qa-sandbox.ni.htec.rs/";

    public HomePage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        if(!isDisplayed()){
            LoginPage loginPage = new LoginPage(driver, email, password);
            if(!loginPage.isDisplayed() || this.sandboxNavigationBar.isDisplayed()) {
                sandboxNavigationBar.logout();
                logStep("INFO: User is logged out in order to navigate to Home page");
            }

            driver.get(BASE_URL);
            driver.waitForElementToBePresent(homePageButtonsContainer);
        }

        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(homePageButtonsContainer, driver) &&
                driver.getCurrentUrl().equals(BASE_URL);
    }

    private WebElement getCandidateLoginButton(){
        try {
            return driver.findElement(CustomBy.cssSelector(".landing [href='/login']"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Candidate Login Button on Home Page", e);
        }
    }

    private WebElement getAdminLoginButton(){
        try {
            return driver.findElement(CustomBy.cssSelector(".landing [href='/admin-login']"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Admin Login Button on Home Page", e);
        }
    }

    public LoginPage proceedToCandidateLoginPage(){
        getCandidateLoginButton().click();
        return new LoginPage(driver, email, password);
    }
}
