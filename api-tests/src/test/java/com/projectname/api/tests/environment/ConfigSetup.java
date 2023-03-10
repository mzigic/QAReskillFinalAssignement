package com.projectname.api.tests.environment;

public class ConfigSetup extends ConfigReader {

    public ConfigSetup() {
    }

    public static String getDbUser() {
        return getValue("DB_USER");
    }

    public static String getDbPsw() {
        return getValue("DB_PSW");
    }

    public static String getDbUrl() {
        return getValue("DB_URL");
    }

    public static String getBaseUrl() {
        return getValue("BASE_URL");
    }

    public static String getUsername() {
        return getValue("USERNAME");
    }

    public static String getPassword() {
        return getValue("PASSWORD");
    }

}
