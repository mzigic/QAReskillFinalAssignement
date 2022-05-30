package com.projectname.api.tests.init;

import com.projectname.api.client.constants.GlobalParams;
import com.projectname.api.client.utils.rest.GsonFunctions;
import com.projectname.api.client.utils.reporting.MethodNGListener;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.internal.BaseTestMethod;

import java.lang.reflect.Method;

//Use this class for common functions by using extend inside test classes
@Listeners({MethodNGListener.class})
public class SandboxTestBase implements ITest {
    static final Logger logger = LoggerFactory.getLogger(SandboxTestBase.class);

    //    Use for allure reports
    private static String testName = new String();

    //    Use to set base url for test methods; If not set, localhost:8080 is used as default
    @BeforeSuite(groups = {"integration", "regression", "smoke", "knownBugs"})
    public void beforeSuite(ITestContext context) {
        RestAssured.baseURI = GlobalParams.BASE_API_URL;
    }
    
    @BeforeClass(groups = {"integration", "regression", "smoke", "knownBugs"})
    public void beforeClass() {
        logger.debug("Before class test execution");
    }

    // Used for allure reports to read fist param from test data
    // if test method is public void testExample() add data like this public void testExample(String allureSuffix)
    // Use this for data that is loaded through TestNG's DataProviders so in Allure report you can know for each data test run what was the data setup
    @BeforeMethod(groups = {"integration", "regression", "smoke", "knownBugs"})
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

    @Override
    public String getTestName() {
        return testName;
    }

    // Use to clean validationResponse memory after each integration test
    @AfterMethod(groups = {"integration"})
    public void revalidate() {
        GsonFunctions.revalidateResponseValidationList();
    }

}
