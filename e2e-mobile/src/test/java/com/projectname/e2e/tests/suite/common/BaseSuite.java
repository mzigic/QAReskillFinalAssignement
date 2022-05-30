package com.projectname.e2e.tests.suite.common;

import com.projectname.e2e.tests.data.model.common.Platforms;
import com.projectname.e2e.tests.environment.ConfigSetup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.internal.BaseTestMethod;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseSuite implements ITest {

    public static RequestSpecification spec;
    private static String testName = new String();
    protected AppiumDriver driver;
    protected String url;
    protected String downloadLocation;
    protected String platform;
    protected String deviceIndex;
    protected DesiredCapabilities iosCapabilities;

    @BeforeSuite(groups = {"ui", "android", "ios"})
    public void beforeSuite(ITestContext context) {
        RestAssured.baseURI = ConfigSetup.getBaseURI();
    }

    @BeforeClass(groups = {"ui", "android", "ios"}, alwaysRun = true)
    public void beforeClass(ITestContext context) {
        ch.qos.logback.classic.Logger apache = (ch.qos.logback.classic.Logger) org.slf4j.LoggerFactory
                .getLogger("org.apache.http");
        ch.qos.logback.classic.Logger restassured = (ch.qos.logback.classic.Logger) org.slf4j.LoggerFactory
                .getLogger("io.restassured");
        ch.qos.logback.classic.Logger hibernate = (ch.qos.logback.classic.Logger) org.slf4j.LoggerFactory
                .getLogger("org.hibernate");
        apache.setLevel(ch.qos.logback.classic.Level.ERROR);
        restassured.setLevel(ch.qos.logback.classic.Level.ERROR);
        hibernate.setLevel(ch.qos.logback.classic.Level.ERROR);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        this.url = context.getCurrentXmlTest().getParameter("url");
        this.platform = context.getCurrentXmlTest().getParameter("platform");

        String downloadDirectory = context.getCurrentXmlTest().getParameter("downloadDirectory");
        this.downloadLocation = downloadDirectory != null ? downloadDirectory
                : System.getProperty("user.home") + "\\Downloads";
        this.deviceIndex = context.getCurrentXmlTest().getParameter("deviceIndex");

        if (this.platform != null) {
            if (platform.equals(Platforms.Platform.ANDROID.getValue())) {
                try {
                    this.driver = new AndroidDriver<>(new URL(context.getCurrentXmlTest().getParameter("hubUrl")),
                            getDesiredCapabilities(deviceIndex, this.getClass().getName(), "src/test/resources/parallel_conf_android.json"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (platform.equals(Platforms.Platform.IOS.getValue())) {
                try {
                    this.driver = new IOSDriver(new URL(context.getCurrentXmlTest().getParameter("hubUrl")),
                            getDesiredCapabilities(deviceIndex, this.getClass().getName(), "src/test/resources/parallel_conf_ios.json"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        } else {
            //Change value if you are running test on local device
            this.platform = Platforms.Platform.ANDROID.getValue();
            //Change value if you are using iOS Simulator or iOS real device
            this.iosCapabilities = this.getIosDesiredCapabilities();

            if (platform.equals(Platforms.Platform.ANDROID.getValue())) {
                try {
                    this.driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), this.getAndroidDesiredCapabilities());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (platform.equals(Platforms.Platform.IOS.getValue())) {
                try {
                    this.driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), this.iosCapabilities);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }
    }

    @BeforeMethod(groups = {"ui", "android", "ios"})
    public void beforeMethod(Method method, Object[] testData, ITestContext ctx, ITestResult iTestResult) {
        if (testData.length > 0) {
            testName = (method.getName() + "_" + testData[0]);
            try {
                BaseTestMethod baseTestMethod = (BaseTestMethod) iTestResult.getMethod();
                java.lang.reflect.Field f = baseTestMethod.getClass().getSuperclass().getDeclaredField("m_methodName");
                f.setAccessible(true);
                f.set(baseTestMethod, testName);
            } catch (Exception e) {
            }
        } else {
            testName = method.getName();
        }

    }

    private DesiredCapabilities getDesiredCapabilities(String deviceIndex, String sessionName, String propertiesFileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader(propertiesFileName));
        JSONArray envs = (JSONArray) config.get("environments");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, String> envCapabilities = (Map<String, String>) envs.get(Integer.parseInt(deviceIndex));
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (capabilities.getCapability(pair.getKey().toString()) == null) {
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }
        }

        String username = System.getenv("BROWSERSTACK_USERNAME");
        if (username == null) {
            username = ConfigSetup.getBSUser();
        }
        capabilities.setCapability("browserstack.user", username);

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if (accessKey == null) {
            accessKey = ConfigSetup.getBSKey();
        }
        capabilities.setCapability("browserstack.key", accessKey);

        String app = System.getenv("BROWSERSTACK_APP_ID");
        if (app != null && !app.isEmpty()) {
            capabilities.setCapability("app", app);
        }

        capabilities.setCapability("name", sessionName);
        capabilities.setCapability("autoDismissAlerts", true);
        //capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("autoGrantPermissions", true);

        return capabilities;
    }

    private DesiredCapabilities getAndroidDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", ConfigSetup.getAndroidDeviceName());
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "appPackage");
        capabilities.setCapability("appActivity", "appActivity.StartActivity");
        capabilities.setCapability("autoGrantPermissions", true);
        return capabilities;
    }

    private DesiredCapabilities getIosDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", ConfigSetup.getIosDeviceName());
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("bundleId", "bundleIdOfApplication");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", ConfigSetup.getIosIpaPath());
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("udid", ConfigSetup.getIosUdId());
        capabilities.setCapability("xcodeOrgId", ConfigSetup.getXcodeOrgId());
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        return capabilities;
    }

    private DesiredCapabilities getIosSimulatorDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", ConfigSetup.getIosSimulatorName());
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("bundleId", "application bundleId");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", ConfigSetup.getIosAppPath());
        capabilities.setCapability("autoAcceptAlerts", true);
        return capabilities;
    }

    @Override
    public String getTestName() { return testName; }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        this.driver.quit();
    }
}
