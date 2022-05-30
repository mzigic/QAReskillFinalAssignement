package com.projectname.api.tests.schemavalidation.suites;

import com.projectname.api.client.asserts.ValidationSchemaAssert;
import com.projectname.api.client.calls.UserAPI;
import com.projectname.api.tests.init.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

// example for response validation test
public class UserValidationTests extends TestBase {

    @Test(groups = {"integration"})
    @Description("Allure description for this test")
    public static void verifyGetUserByIdResponse() {
        logStep("INFO: Verify required fields");
        new ValidationSchemaAssert().assertResponseStructure(UserAPI.validateGetUserByIdResponse("1"));
        logStep("PASS: Required fields are verified");
    }
}
