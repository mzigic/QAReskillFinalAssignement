package com.projectname.e2e.tests.pages.projects;

import com.projectname.e2e.tests.data.model.projects.ProjectDetails;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

public class ProjectDetailsPage extends PageBase {
    public ProjectDetailsPage(CustomWebDriver driver, String url, String email, String password) {
        super(driver, url, email, password);
    }

    @Override
    public PageBase show() {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return CheckIfElement.isDisplayed(CustomBy.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div[1]/div/a/div[2]"), driver);
    }

    private WebElement getTitleInputField() {
        try {
            return driver.findElement(CustomBy.name("title"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not title input field on project details page");
        }
    }

    private WebElement getBackButton() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div[1]/div/a/div[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find back button on project details page");
        }
    }

    private WebElement getRemoveButton() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div[1]/div/div/div/span/button"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find remove button on project details page");
        }
    }

    private WebElement getConfirmRemoveButton() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div[3]/div[2]/div"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find confirm remove button in remove project pop up");
        }
    }

    public ProjectDetails getActualProjectDetails() {
        ProjectDetails projectDetails = new ProjectDetails();

        projectDetails.setTitle(getTitleInputField().getAttribute("value"));
        return projectDetails;
    }

    public ProjectsPage navigateBackToProjectsPage() {
        getBackButton().click();
        return new ProjectsPage(driver, url, email, password);
    }

    public void removeProject() {
        getRemoveButton().click();
    }

    public ProjectsPage confirmRemoveProject() {
        getConfirmRemoveButton().click();
        return new ProjectsPage(driver, url, email, password);
    }

}
