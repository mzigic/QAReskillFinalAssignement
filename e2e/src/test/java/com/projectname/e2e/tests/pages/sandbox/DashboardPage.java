package com.projectname.e2e.tests.pages.sandbox;

import com.projectname.e2e.tests.data.enums.Module;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.By;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

public class DashboardPage extends PageBase {

    private By dashboardContainer = CustomBy.cssSelector(".card-grid>.card");

    public DashboardPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        logStep("INFO: Navigate to Dashboard page");
        if(!isDisplayed()){

            LoginPage loginPage = new LoginPage(driver, email, password);
            if(loginPage.isDisplayed()) {
                loginPage.loginWith(email, password);
            } else if(sandboxNavigationBar.isDisplayed()){
                sandboxNavigationBar.navigateTo(Module.DASHBOARD);
            }

        }

        driver.waitForElementToBePresent(dashboardContainer);
        logStep("PASS: Dashboard page is shown");

        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(dashboardContainer, driver) &&
                driver.getCurrentUrl().contains("/dashboard");
    }
}
