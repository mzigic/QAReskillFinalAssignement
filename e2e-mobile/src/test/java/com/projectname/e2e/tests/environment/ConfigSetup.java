package com.projectname.e2e.tests.environment;

public class ConfigSetup extends ConfigReader{

    private static final String setupPropertiesPath = "src/test/resources/setup.properties";
    private static final String uiDevicePropertiesPath = "src/test/resources/uidevice.properties";

    public ConfigSetup() {

    }

    public static String getBaseURI() {
        return "baseUrl";
    }

    public static String getBSUser() {
        return getValue("BROWSERSTACK_USER", setupPropertiesPath);
    }

    public static String getBSKey() {
        return getValue("BROWSERSTACK_KEY", setupPropertiesPath);
    }

    public static String getDefaultPsw() {
        return getValue("USER_PSW", setupPropertiesPath);
    }

    public static String getDefaultUser() { return getValue("MAIN_USER"); }

    public static String getAndroidDeviceName() {return getValue("ANDROID_DEVICE_NAME", uiDevicePropertiesPath);}

    public static String getIosDeviceName() {return getValue("IOS_DEVICE_NAME", uiDevicePropertiesPath);}

    public static String getIosSimulatorName() {return getValue("IOS_SIM_NAME", uiDevicePropertiesPath);}

    public static String getIosAppPath() {return getValue("IOS_APP_PATH", uiDevicePropertiesPath);}

    public static String getIosIpaPath() {return getValue("IOS_IPA_PATH", uiDevicePropertiesPath);}

    public static String getXcodeOrgId() {return getValue("XCODE_ORG_ID", uiDevicePropertiesPath);}

    public static String getIosUdId() {return getValue("IOS_UDID", uiDevicePropertiesPath);}
}
