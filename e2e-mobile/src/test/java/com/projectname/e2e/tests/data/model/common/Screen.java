package com.projectname.e2e.tests.data.model.common;

public enum Screen {

    EXAMPLE_DASHBOARD("Example Dashboard", "dashboardScreen"),
    EXAMPLE_LOGIN("Example Login", "loginScreen");

    private String name;
    private String locator;

    Screen(String name, String locator) {
        this.name = name;
        this.locator = locator;
    }

    public String getName() { return name; }

    public String getLocator() { return locator; }

}
