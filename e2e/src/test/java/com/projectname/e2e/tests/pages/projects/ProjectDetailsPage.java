package com.projectname.e2e.tests.pages.projects;

import com.projectname.e2e.tests.data.model.projects.*;
import com.projectname.e2e.tests.pages.common.PageBase;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    private WebElement getDialogConfirmButton() {
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

    private WebElement getPersonInputField() {
        try {
            return driver.findElement(CustomBy.name("person"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find person name input field");
        }
    }

    private WebElement getTechnologyInputField() {
        try {
            return driver.findElement(CustomBy.name("technology"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find technology input field");
        }
    }

    private WebElement getSeniorityInputField() {
        try {
            return driver.findElement(CustomBy.name("seniority"));
        } catch (Exception e) {
            throw new AssertionError("Could not find seniority input field");
        }
    }

    private WebElement getTeamInputField() {
        try {
            return driver.findElement(CustomBy.name("team"));
        } catch (Exception e) {
            throw new AssertionError("Could not find team input field");
        }
    }

    private WebElement getTechnologyDropdown() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"picky__button__button\"]/span[text()='Technology']"));
        } catch (Exception e) {
            throw new AssertionError("Could not find technology dropdown");
        }
    }

    private WebElement getSeniorityDropdown() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"picky__button__button\"]/span[text()='Seniority']"));
        } catch (Exception e) {
            throw new AssertionError("Could not find seniority dropdown");
        }
    }

    private WebElement getTeamDropdown() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"picky__button__button\"]/span[text()='Team']"));
        } catch (Exception e) {
            throw new AssertionError("Could not find team dropdown");
        }
    }

    private WebElement getValueFromDropdown() {
        try {
            return driver.findElement(CustomBy.id("picky-option-0"));
        } catch (Exception e) {
            throw new AssertionError("Could not find value in dropdown");
        }
    }

    private WebElement getPeopleDropdown() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"picky__button__button\"]/span[text()='People']"));
        } catch (Exception e) {
            throw new AssertionError("Could not find people dropdown");
        }
    }

    private WebElement getSubmitPersonBtn() {
        try {
            return driver.findElement(CustomBy.xpath("/html/body/div/div/div[3]/div[2]/div/div[2]/div[2]/div[4]/div[5]/button"));
        } catch (Exception e) {
            throw new AssertionError("Could not find submit person button");
        }
    }

    private WebElement getSubmitAssignPeopleBtn() {
        try {
            return driver.findElement(CustomBy.xpath("/html/body/div/div/div[3]/div[2]/div/div[2]/div[1]/div[2]/div[2]/button"));
        } catch (Exception e) {
            throw new AssertionError("Could not find submit assign person button");
        }
    }

    private WebElement getCreateTechnologyBtn() {
        try {
            return driver.findElement(CustomBy.xpath("/html/body/div/div/div[3]/div[2]/div/div[2]/div[2]/div[1]/div[2]/button"));
        } catch (Exception e) {
            throw new AssertionError("Could not find create technology button");
        }
    }

    private WebElement getCreateSeniorityBtn() {
        try {
            return driver.findElement(CustomBy.xpath("/html/body/div/div/div[3]/div[2]/div/div[2]/div[2]/div[2]/div[2]/button"));
        } catch (Exception e) {
            throw new AssertionError("Could not find create seniority button");
        }
    }

    private WebElement getCreateTeamBtn() {
        try {
            return driver.findElement(CustomBy.xpath("/html/body/div/div/div[3]/div[2]/div/div[2]/div[2]/div[3]/div[2]/button"));
        } catch (Exception e) {
            throw new AssertionError("Could not find create team button");
        }
    }

    private WebElement getRemoveButton() {
        try {
            return driver.findElement(By.cssSelector(".confirmation-dialog--buttons--confirm"));
        } catch (Exception e) {
            throw new AssertionError("Could not find create team button");
        }
    }

    public void clickOnTechnologyDropdown() {
        getTechnologyDropdown().click();
    }

    public void clickOnSeniorityDropdown() {
        getSeniorityDropdown().click();
    }

    public void clickOnTeamDropdown() {
        getTeamDropdown().click();
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

    public ProjectDetailsPage createPerson(CreatePersonRequest personRequest) {
        getPersonInputField().click();
        getPersonInputField().clear();
        getPersonInputField().sendKeys(personRequest.getName());

        clickOnTechnologyDropdown();
        getValueFromDropdown().click();

        clickOnSeniorityDropdown();
        getValueFromDropdown().click();

        clickOnTeamDropdown();
        getValueFromDropdown().click();

        getSubmitPersonBtn().click();

        return new ProjectDetailsPage(driver, url, email, password);
    }

    public void assignPersonToProject() {
        getPeopleDropdown().click();
        getValueFromDropdown().click();
        getSubmitAssignPeopleBtn().click();
    }

    public ProjectDetailsPage createTechnology(CreateTechnologyRequest technologyRequest) {
        getTechnologyInputField().click();
        getTechnologyInputField().clear();
        getTechnologyInputField().sendKeys(technologyRequest.getTitle());
        getCreateTechnologyBtn().click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ProjectDetailsPage(driver, url, email, password);
    }

    public ProjectDetailsPage createSeniority(CreateSeniorityRequest seniorityRequest) {
        getSeniorityInputField().click();
        getSeniorityInputField().clear();
        getSeniorityInputField().sendKeys(seniorityRequest.getTitle());
        getCreateSeniorityBtn().click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ProjectDetailsPage(driver, url, email, password);
    }

    public ProjectDetailsPage createTeam(CreateTeamRequest teamRequest) {
        getTeamInputField().click();
        getTeamInputField().clear();
        getTeamInputField().sendKeys(teamRequest.getTitle());
        getCreateTeamBtn().click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ProjectDetailsPage(driver, url, email, password);
    }

    public ProjectDetailsPage updateProject(UpdateProjectRequest updateProjectRequest) {
        getTitleInputField().click();
        getTitleInputField().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        getTitleInputField().sendKeys(updateProjectRequest.getTitle());
        return new ProjectDetailsPage(driver, url, email, password);
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

}
