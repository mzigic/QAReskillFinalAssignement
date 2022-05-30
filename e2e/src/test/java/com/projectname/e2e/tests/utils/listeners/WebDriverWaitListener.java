package com.projectname.e2e.tests.utils.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.projectname.api.client.utils.reporting.Allure.logStep;

//not used for now
public class WebDriverWaitListener extends AbstractWebDriverEventListener {

    private static final Duration TIMEOUT_IN_SECONDS = Duration.ofSeconds(30);
    private final WebDriverWait wait;

    public WebDriverWaitListener(WebDriver driver) {
        wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        long startTime = System.currentTimeMillis();
        logStep("Wait for element to be clickable :: start");
        wait.until(ExpectedConditions.elementToBeClickable(element));
        long endTime = System.currentTimeMillis();
        logStep("Wait for element to be clickable :: end, took " + (endTime - startTime) + " milliseconds");
    }

    public void beforeGetText(WebElement element, WebDriver driver) {
        long startTime = System.currentTimeMillis();
        logStep("Wait for element to be visible:: start");
        wait.until(ExpectedConditions.visibilityOf(element));
        long endTime = System.currentTimeMillis();
        logStep("Wait for element to be visible:: end, took " + (endTime - startTime) + " milliseconds");
    }

}
