package com.projectname.e2e.tests.pages.projects;

import com.projectname.e2e.tests.data.model.projects.ProjectDetails;
import com.projectname.e2e.tests.pages.DashboardPage;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends PageBase {
    public ProjectsPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        if (!isDisplayed()) {
            DashboardPage dashboardPage = new DashboardPage(driver, url, email, password);
            if (dashboardPage.isDisplayed()) {
                dashboardPage.openProjectsPage();
            }
        }
        return this;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div[1]/div/a/div[2]"), driver);
    }

    public CreateProjectPage openCreateProjectPage() {
        getNewProjectBtn().click();
        return new CreateProjectPage(driver, url, email, password);
    }


    private WebElement getNewProjectBtn() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div[1]/div/div/div/span/a"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find new project button on projects page");
        }
    }

    private WebElement projectCard(String title) {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div[2]/div/span[1]/a/div/div[1]/div[text()='" + title + "']"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find project card on projects page");
        }
    }

    public ProjectDetails getProjectCardTitle(String title) {
        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setTitle(projectCard(title).getText());
        return projectDetails;
    }

    public ProjectDetailsPage openProjectDetails(String title) {
        projectCard(title).click();
        return new ProjectDetailsPage(driver, url, email, password);
    }
    public boolean projectCardExists(String title) {
        try {
            projectCard(title);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
