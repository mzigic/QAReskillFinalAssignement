package com.projectname.e2e.tests.pages;

import com.projectname.e2e.tests.data.enums.Module;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.pages.projects.ProjectsPage;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

public class DashboardPage extends PageBase {

    public DashboardPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        logStep("INFO: Navigate to Dashboard page");
        if (!isDisplayed()) {
            LoginPage loginPage = new LoginPage(driver,"", email, password);
            if (loginPage.isDisplayed()) {
                loginPage.login(email, password);
            } else {
                navigateTo(Module.DASHBOARD);
            }
            logStep("PASS: Dashboard page is shown");
        }
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div/div[1]/div/div[1]/div"), driver);
    }

    private WebElement getPlaygroundBtn() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div/a[4]/div[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find playground button on dashboard page");
        }
    }

    public ProjectsPage openProjectsPage() {
        getPlaygroundBtn().click();
        return new ProjectsPage(driver, url, email, password);
    }
}
