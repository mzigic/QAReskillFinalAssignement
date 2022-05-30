package com.projectname.e2e.tests.pages.sandbox;

import com.projectname.e2e.tests.data.enums.Module;
import com.projectname.e2e.tests.selectors.CustomBy;
import com.projectname.e2e.tests.utils.CheckIfElement;
import com.projectname.e2e.tests.webdriver.CustomWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

public class NavigationBarSubPage {

    private By logoutBtn = CustomBy.cssSelector(".nav [href='/dashboard']");
    private By sideMenuContainer = CustomBy.cssSelector(".menu-grid>.menu");

    private CustomWebDriver driver;

    public NavigationBarSubPage(CustomWebDriver driver) {
        this.driver = driver;
    }

    private WebElement getLogoutButton(){
        try {
            return driver.findElement(CustomBy.cssSelector(".nav [href='/dashboard']"));
        } catch(Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Logout button");
        }
    }

    private WebElement getModalLogoutConfirmButton(){
        try{
            return driver.findElement(CustomBy.cssSelector("#react-confirm-alert .confirmation-dialog--buttons--confirm"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find Logout Modal Confirm button");
        }
    }

    public void logout(){
        logStep("INFO: Click on Logout button in Navigation bar");
        getLogoutButton().click();
        logStep("PASS: Clicked on Logout button in Navigation bar");

        logStep("INFO: Click on Logout modal confirm button");
        getModalLogoutConfirmButton().click();
        logStep("PASS: Clicked on Logout modal confirm button");
    }

    private WebElement getDashboardModuleLink(){
        try {
            return driver.findElement(CustomBy.cssSelector(".menu-grid [href='/dashboard']"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find dashboard module link in navigation sidebar", e);
        }
    }

    private WebElement getProfileModuleLink(){
        try {
            return driver.findElement(CustomBy.cssSelector(".menu-grid [href='/profile']"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find profile module link in navigation sidebar", e);
        }
    }

    public void navigateTo(Module module) {
        switch (module) {
            case DASHBOARD -> getDashboardModuleLink().click();
            case PROFILE -> getProfileModuleLink().click();
        }
        logStep("INFO: Proceed to " + module + " section");
    }

    boolean isDisplayed(){
        return CheckIfElement.isDisplayed(logoutBtn, driver) &&
                CheckIfElement.isDisplayed(sideMenuContainer, driver);
    }

}
