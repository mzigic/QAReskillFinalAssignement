package com.projectname.e2e.tests.asserts;

import com.projectname.e2e.tests.data.model.projects.ProjectDetails;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ProjectsAssert {
    private SoftAssert softAssert;

    public ProjectsAssert() {
        softAssert = new SoftAssert();
    }

    public void assertProjectCreated(ProjectDetails actualDetails, ProjectDetails expectedDetails) {
        if (actualDetails == null) {
            Assert.fail("Actual details are null");
        }

        this.softAssert.assertEquals(actualDetails.getTitle(), expectedDetails.getTitle());
        this.softAssert.assertAll();
    }

    public void assertCreatedProjectCard(ProjectDetails actualDetails, ProjectDetails expectedDetails) {
        if (actualDetails == null) {
            Assert.fail("Actual details are null");
        }

        this.softAssert.assertEquals(actualDetails.getTitle(), expectedDetails.getTitle());
        this.softAssert.assertAll();
    }


}
