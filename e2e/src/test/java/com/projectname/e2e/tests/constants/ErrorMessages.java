package com.projectname.e2e.tests.constants;

public class ErrorMessages {

    public static final String userIsNotAuthorizedMsg(String email){
        return email + " is not authorized or wrong email/password combination";
    }

    public static final String forgotPasswordEmailIsInvalid(String email){
        return "Email address '" + email + "' is not valid";
    }
}
