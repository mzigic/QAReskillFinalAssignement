package com.projectname.e2e.tests.suites.sandbox;

import com.projectname.e2e.tests.constants.DataProviderNames;
import com.projectname.e2e.tests.constants.ErrorMessages;
import com.projectname.e2e.tests.data.provider.sandbox.ForgotPasswordProvider;
import com.projectname.e2e.tests.pages.sandbox.ForgotPasswordPage;
import com.projectname.e2e.tests.suites.common.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

public class ForgotPasswordTests extends TestBase {

    @Test(groups = {"smoke", "ui" }, dataProvider = DataProviderNames.VERIFY_FORGOT_PASSWORD_FORM_ERRORS, dataProviderClass = ForgotPasswordProvider.class)
    @Description("Verify Forgot Password Form Errors")
    @Feature("Forgot Password")
    public void verifyForgetPasswordFormErrors(String methodSuffix, String email) {

        logStep("INFO: Fetch forgot password page");
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());
        forgotPasswordPage.show();
        logStep("PASS: Forgot password page is fetched");

        forgotPasswordPage.sendInstructionsTo(email);

        logStep("INFO: Verify validation error is shown");
        Assert.assertEquals(
                forgotPasswordPage.getForgotPasswordEmailValidationMessage(),
                ErrorMessages.forgotPasswordEmailIsInvalid(email),
                "Validation error isn't verified"
        );
        logStep("PASS: Validation error is shown");

    }

}
