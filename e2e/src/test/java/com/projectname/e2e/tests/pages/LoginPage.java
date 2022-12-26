package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.environment.ConfigSetup;
import com.projectname.e2e.tests.pages.common.NavigationBarSubPage;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

public class LoginPage extends PageBase {

    public LoginPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
        driver.get(ConfigSetup.getUIBaseURL() + "login");
    }

    @Override
    public PageBase show() {
        if (!isDisplayed()) {
            logStep("INFO: Navigate to Login page");
            new NavigationBarSubPage(driver).logout();
            logStep("PASS: User is logged out in order to navigate to Login page");
            driver.waitForElementToBePresent(CustomBy.name("email"));
        }
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.name("email"), driver);
    }

    public DashboardPage login(String email, String password) {
        WebElement weGetEmailInput = getEmailInput();
        //you can directly send characters, but idea with click is to see mouse follow from one element to another, since that action is triggered on click
        weGetEmailInput.click();
        weGetEmailInput.sendKeys(email);
        WebElement weGetPasswordInput = getPasswordInput();
        weGetPasswordInput.click();
        weGetPasswordInput.sendKeys(password);
        getLoginButton().click();
        driver.waitForElementToBePresent(CustomBy.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div/div[1]/div/div[1]/div"));
        return new DashboardPage(driver, "", email, password);
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

    private WebElement getLoginButton() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"root\"]/div/div[3]/div/div/button"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Log in button on Login page", e);
        }
    }

    private WebElement getUserLoginBtn() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[3]/a[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find login user button");
        }
    }
}
