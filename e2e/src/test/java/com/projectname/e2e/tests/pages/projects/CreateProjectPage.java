package com.projectname.e2e.tests.pages.projects;

import com.projectname.e2e.tests.data.model.projects.CreateProjectRequest;
import com.projectname.e2e.tests.data.model.projects.UpdateProjectRequest;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.WebElement;

public class CreateProjectPage extends PageBase {
    public CreateProjectPage(CustomWebDriver driver, String url, String email, String password) {
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
            return driver.findElement(CustomBy.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div[2]/div[1]/div[2]/input"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find title input field on create project page");
        }
    }

    private WebElement getSubmitBtn() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div[2]/div[2]/button"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find submit button on create project page");
        }
    }

    private WebElement titleErrorMessage() {
        try {
            return driver.findElement(CustomBy.id("validation-msg"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find title error message on create project page");
        }
    }

    public String getTitleErrorMessage() {
        return titleErrorMessage().getText();
    }

    public ProjectDetailsPage createNewProject(CreateProjectRequest createProjectRequest) {
        getTitleInputField().click();
        getTitleInputField().clear();
        getTitleInputField().sendKeys(createProjectRequest.getTitle());

        getSubmitBtn().click();

        return new ProjectDetailsPage(driver, url, email, password);
    }


}
