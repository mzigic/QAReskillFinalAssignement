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

    private WebElement getPreviewBtn() {
        try {
            return driver.findElement(CustomBy.xpath("/html/body/div/div/div[3]/div[2]/div/div[2]/div/span/a/div/div[2]/div[5]/div/div[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find preview button on projects page");
        }
    }

    private WebElement projectPreviewTitle() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"myModal-0\"]/div/div/div[2]/div[1]/div[2]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find project preview title");
        }
    }

    private WebElement getTeamInProjectPreview() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"myModal-0\"]/div/div/div[2]/div[2]/div/div[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find team in project preview");
        }
    }

    private WebElement getPersonInProjectPreview() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"myModal-0\"]/div/div/div[2]/div[2]/div/div[2]/div/div[1]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find person in project preview");
        }
    }

    private WebElement getSeniorityProjectPreview() {
        try {
            return driver.findElement(CustomBy.xpath("//*[@id=\"myModal-0\"]/div/div/div[2]/div[2]/div/div[2]/div/div[2]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find seniority in project preview");
        }
    }

    private WebElement getTechnologiesInProjectPreview() {
        try {
            return driver.findElement(CustomBy.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div/span/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find technologies in project preview");
        }
    }

    public void openProjectPreview() {
        getPreviewBtn().click();
    }

    public ProjectDetails getProjectCardTitle(String title) {
        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setTitle(projectCard(title).getText());
        return projectDetails;
    }

    public ProjectDetails getProjectPreview() {
        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setTitle(projectPreviewTitle().getAttribute("textContent"));
        projectDetails.setTeam(getTeamInProjectPreview().getAttribute("textContent"));
        projectDetails.setPerson(getPersonInProjectPreview().getAttribute("textContent"));
        projectDetails.setSeniority(getSeniorityProjectPreview().getAttribute("textContent").split(":")[1].trim());
        projectDetails.setTechnology(getTechnologiesInProjectPreview().getAttribute("textContent").split(":")[1].trim());
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
