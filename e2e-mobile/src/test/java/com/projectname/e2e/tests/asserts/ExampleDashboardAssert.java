package com.projectname.e2e.tests.asserts;

import com.projectname.e2e.tests.data.model.example.ExampleCreatedUserDetailsOnDashboardScreen;
import com.projectname.e2e.tests.data.model.example.ExampleDashboardScreenDetails;
import org.testng.asserts.SoftAssert;

public class ExampleDashboardAssert {

    private SoftAssert softAssert;

    public ExampleDashboardAssert() { this.softAssert = new SoftAssert(); }

    public void assertUserDetailsOnDashboardScreen(ExampleDashboardScreenDetails actualExampleDashboardScreenDetails, ExampleDashboardScreenDetails expectedExampleDashboardScreenDetails){
        this.softAssert.assertEquals(actualExampleDashboardScreenDetails.getUserName(), expectedExampleDashboardScreenDetails.getUserName(), "User name didn't match");
        this.softAssert.assertEquals(actualExampleDashboardScreenDetails.getUserEmail(), expectedExampleDashboardScreenDetails.getUserEmail(), "User email didn't match");
        this.softAssert.assertEquals(actualExampleDashboardScreenDetails.isHideEmailSwitch(), expectedExampleDashboardScreenDetails.isHideEmailSwitch(), "Hide email switch value didn't match");
        this.softAssert.assertAll();
    }

    public void assertCreatedUserOnDashboardScreen(ExampleCreatedUserDetailsOnDashboardScreen actualExampleCreatedUserDetailsOnDashboardScreen, ExampleCreatedUserDetailsOnDashboardScreen expectedExampleCreatedUserDetailsOnDashboardScreen) {
        this.softAssert.assertEquals(actualExampleCreatedUserDetailsOnDashboardScreen.getName(), expectedExampleCreatedUserDetailsOnDashboardScreen.getName(), "Name didn't match");
        this.softAssert.assertEquals(actualExampleCreatedUserDetailsOnDashboardScreen.getJob(), expectedExampleCreatedUserDetailsOnDashboardScreen.getJob(), "Job didn't match");
        this.softAssert.assertAll();
    }
}
