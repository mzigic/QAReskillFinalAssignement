package com.projectname.e2e.tests.data.provider.sandbox;

import com.projectname.e2e.tests.constants.DataProviderNames;
import org.testng.annotations.DataProvider;

public class ForgotPasswordProvider {

    @DataProvider(name = DataProviderNames.VERIFY_FORGOT_PASSWORD_FORM_ERRORS)
    public static Object[][] verifyForgotPasswordFormErrors() {

        return new Object[][]{
                {"WithEmptyEmail", ""},
                {"WithInvalidEmail", "abc"}
        };
    }
}
