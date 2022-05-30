package com.projectname.e2e.tests.screens.example;

import com.projectname.e2e.tests.common.UIMap;
import com.projectname.e2e.tests.data.model.common.Platforms;
import com.projectname.e2e.tests.data.model.common.Screen;
import com.projectname.e2e.tests.data.model.example.ExampleCreatedUserDetailsOnDashboardScreen;
import com.projectname.e2e.tests.data.model.example.ExampleDashboardScreenDetails;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import com.projectname.e2e.tests.screens.common.BaseScreen;

import java.util.concurrent.TimeUnit;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

public class ExampleDashboardScreen extends BaseScreen {
    public ExampleDashboardScreen(AppiumDriver driver, String platform, String username, String password) {
        super(driver, platform, username, password);
    }

    // Show method is used to open this screen no matter on where we are located currently
    @Override
    public BaseScreen show() {
        if(!this.isDisplayed()) {
            ExampleLoginScreen exampleLoginScreen = new ExampleLoginScreen(this.driver, this.platform, this.username, this.password);
            if(exampleLoginScreen.isDisplayed()) {
                exampleLoginScreen.login(this.username, this.password);
            }
        }
        return this;
    }

    // isDisplayed method is returning boolean value are we on this screen or not
    @Override
    public boolean isDisplayed() {
        try {
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            this.driver.findElement(UIMap.getLocator("dashboardScreen", platform));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // getScreen method is returning root element on this screen so we can search for other elements inside the root element
    @Override
    public WebElement getScreen() {
        try {
            return this.driver.findElement(UIMap.getLocator("dashboardScreen", platform));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find dashboard screen root", e);
        }
    }

    private WebElement getUserNameField() {
        return this.fetchElement("dashboardScreen.userNameField", this.getScreen(), Screen.EXAMPLE_DASHBOARD.getName());
    }

    private String getUserNameValue() {
        if(platform.equals(Platforms.Platform.ANDROID.getValue())) {
            return this.getUserNameField().getText();
        }
        return this.getUserNameField().getAttribute("value");
    }

    private WebElement getUserEmailField() {
        return this.fetchElement("dashboardScreen.userEmailField", this.getScreen(), Screen.EXAMPLE_DASHBOARD.getName());
    }

    private String getUserEmailValue() {
        if(platform.equals(Platforms.Platform.ANDROID.getValue())) {
            return this.getUserEmailField().getText();
        }
        return this.getUserEmailField().getAttribute("value");
    }

    private WebElement getHideEmailSwitch() {
        return this.fetchElement("dashboardScreen.hideEmailSwitch", this.getScreen(), Screen.EXAMPLE_DASHBOARD.getName());
    }

    private Boolean getHideEmailSwitchValue() {
        return this.getSwitchValue(this.getHideEmailSwitch());
    }

    private WebElement getCreateUserInputNameField() {
        return this.fetchElement("dashboardScreen.createUserInputNameField", this.getScreen(), Screen.EXAMPLE_DASHBOARD.getName());
    }

    private WebElement getCreateUserInputJobField() {
        return this.fetchElement("dashboardScreen.createUserInputJobField", this.getScreen(), Screen.EXAMPLE_DASHBOARD.getName());
    }

    private WebElement getAddNewUserBtn() {
        return this.fetchElement("dashboardScreen.createUserAddNewBtn", this.getScreen(), Screen.EXAMPLE_DASHBOARD.getName());
    }

    private WebElement getCreatedUserNameField() {
        return this.fetchElement("dashboardScreen.createdUserNameField", this.getScreen(), Screen.EXAMPLE_DASHBOARD.getName());
    }

    private String getCreatedUserNameValue() {
        if(platform.equals(Platforms.Platform.ANDROID.getValue())) {
            return this.getCreatedUserNameField().getText();
        }
        return this.getCreatedUserNameField().getAttribute("value");
    }

    private WebElement getCreatedUserJobField() {
        return this.fetchElement("dashboardScreen.createdUserJobField", this.getScreen(), Screen.EXAMPLE_DASHBOARD.getName());
    }

    private String getCreatedUserJobValue() {
        if(platform.equals(Platforms.Platform.ANDROID.getValue())) {
            return this.getCreatedUserJobField().getText();
        }
        return this.getCreatedUserJobField().getAttribute("value");
    }

    public void createUserFromDashboard(String name, String job) {
        logStep("INFO: Enter name: " + name);
        this.getCreateUserInputNameField().click();
        this.getCreateUserInputNameField().clear();
        this.getCreateUserInputNameField().sendKeys(name);
        logStep("PASS: Name is entered");

        logStep("INFO: Enter job: " + job);
        this.getCreateUserInputJobField().click();
        this.getCreateUserInputJobField().clear();
        this.getCreateUserInputJobField().sendKeys(job);
        logStep("PASS: Job is entered");

        logStep("INFO: Tap on add new btn");
        this.getAddNewUserBtn().click();
        logStep("PASS: Btn is clicked");
    }

    public ExampleCreatedUserDetailsOnDashboardScreen getActualDetailsOfCreatedUser() {
        logStep("INFO: Fetch actual data of created user");
        ExampleCreatedUserDetailsOnDashboardScreen exampleCreatedUserDetailsOnDashboardScreen = new ExampleCreatedUserDetailsOnDashboardScreen();
        exampleCreatedUserDetailsOnDashboardScreen.setName(getCreatedUserNameValue());
        exampleCreatedUserDetailsOnDashboardScreen.setJob(getCreatedUserJobValue());
        logStep("PASS: Actual data for created user is fetched");

        return exampleCreatedUserDetailsOnDashboardScreen;
    }

    public ExampleDashboardScreenDetails getActualDetailsFromDashboardScreen() {
        logStep("INFO: Fetch actual data from dashboard screen");
        ExampleDashboardScreenDetails exampleDashboardScreenDetails = new ExampleDashboardScreenDetails();
        exampleDashboardScreenDetails.setUserName(this.getUserNameValue());
        exampleDashboardScreenDetails.setUserEmail(this.getUserEmailValue());
        exampleDashboardScreenDetails.setHideEmailSwitch(this.getHideEmailSwitchValue());
        logStep("PASS: Actual data for dashboard is fetched");

        return exampleDashboardScreenDetails;
    }


}
