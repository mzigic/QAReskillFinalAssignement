package com.projectname.e2e.tests.environment;

public class ConfigSetup extends ConfigReader {

    private static final String TEST = "test";
    private static final String STAGING = "staging";
    private static final String WEB = "web";

    public ConfigSetup() {
    }

    //related to project and structure of url by environment, logic for initialization of baseUrl should be implemented
    public static String getUIBaseURL() {
        String currentEnv = System.getProperty("environment");
        System.out.println(currentEnv);
        String env = currentEnv != null && !currentEnv.isEmpty() ? currentEnv : TEST;
        String base_url = "https://" + env + "reqres.in/";
        System.out.println(base_url);
        return base_url;
    }

    public static String getAdminUser() {
        return getValue("ADMIN");
    }

    public static String getAdminPsw() {
        return getValue("ADMIN_PSW");
    }

    public static String getBSUser() {
        return getValue("BROWSERSTACK_USERNAME");
    }

    public static String getBSKey() {
        return getValue("BROWSERSTACK_ACCESS_KEY");
    }

    public static String getUser() {return getValue("USER"); }

    public static String getUserPsw() {return getValue("USER_PSW"); }

}
