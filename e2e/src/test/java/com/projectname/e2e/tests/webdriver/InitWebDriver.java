package com.projectname.e2e.tests.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

public class InitWebDriver {
    private static InitWebDriver singleInstance = null;

    private InitWebDriver(){
    }

    public static InitWebDriver getInstance(){
        if(singleInstance == null){
            singleInstance = new InitWebDriver();
        }

        return singleInstance;
    }

    public CustomWebDriver initialize(String platform){
        logStep("INFO: Try to initialize web driver for " + platform + " platform");
        if (platform == null || platform.contains("Chrome")) {
            WebDriverManager.chromedriver().setup();
            return new CustomWebDriver(new ChromeDriver());
        } else if (platform.contains("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new CustomWebDriver(new FirefoxDriver());
        } else if (platform.contains("Edge")) {
            WebDriverManager.edgedriver().setup();
            return new CustomWebDriver(new EdgeDriver());
        } else{
            throw new RuntimeException("Unable to initialize web driver for " + platform + " browser");
        }
    }
}
