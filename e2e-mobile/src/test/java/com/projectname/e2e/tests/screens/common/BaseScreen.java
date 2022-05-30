package com.projectname.e2e.tests.screens.common;

import com.projectname.e2e.tests.common.UIMap;
import com.projectname.e2e.tests.data.model.common.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class BaseScreen {
    protected AppiumDriver driver;
    protected String platform;
    protected String username;
    protected String password;

    public BaseScreen(AppiumDriver driver, String platform, String username, String password) {
        this.driver = driver;
        this.platform = platform;
        this.username = username;
        this.password = password;
    }

    public abstract BaseScreen show();

    public abstract boolean isDisplayed();

    public abstract WebElement getScreen();

    public BaseScreen swipeFromUpToBottom() {
        Dimension dim = driver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width / 2;
        int top_y = (int) (height * 0.80);
        int bottom_y = (int) (height * 0.20);
        TouchAction ts = new TouchAction(driver);
        ts.longPress(PointOption.point(x, top_y)).moveTo(PointOption.point(x, bottom_y)).release().perform().waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)));
        return this;
    }

    public BaseScreen swipeFromBottomToUp() {
        Dimension dim = driver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width / 2;
        int top_y = (int) (height * 0.80);
        int bottom_y = (int) (height * 0.20);
        TouchAction ts = new TouchAction(driver);
        ts.longPress(PointOption.point(x, bottom_y)).moveTo(PointOption.point(x, top_y)).release().perform().waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)));
        return this;
    }

    public BaseScreen swipeToRefresh() {
        Dimension dim = driver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width / 2;
        int top_y = (int) (height * 0.80);
        int bottom_y = (int) (height * 0.20);
        TouchAction ts = new TouchAction(driver);
        ts.press(PointOption.point(x, bottom_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(x, top_y)).release().perform();
        return this;
    }

    public WebElement fetchElement(String elementName, WebElement screen, String screenTitle) {
        try {
            return screen.findElement(UIMap.getLocator(elementName, this.platform));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find " + elementName + " on " + screenTitle + " screen", e);
        }
    }

    public WebElement fetchElementWithVariableId(String elementName, WebElement screen, Integer id, String screenTitle) {
        String locator = UIMap.getLocatorAsString(elementName, platform);
        String locatorValue = locator.substring(locator.indexOf("=") + 1, locator.length()) + id;
        try {
            return screen.findElement(By.id(locatorValue));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find " + elementName + " on " + screenTitle + " screen", e);
        }
    }

    public WebElement fetchElementWithVariableXPath(String elementName, WebDriver driver, String variableXPath, String screenTitle) {
        String locator = UIMap.getLocatorAsString(elementName, platform) + variableXPath;
        try {
            return driver.findElement(By.xpath(locator));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find " + elementName + " on " + screenTitle + " screen", e);
        }
    }

    public WebElement fetchChildElementWithVariableId(WebElement parentElement, String childElement, Integer id, String screenTitle) {
        String locator = UIMap.getLocatorAsString(childElement, platform);
        String locatorValue = locator.substring(locator.indexOf("=") + 1, locator.length()) + id;
        try {
            return parentElement.findElement(By.id(locatorValue));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find " + childElement + " on " + screenTitle + " screen", e);
        }
    }

    public WebElement fetchChildElement(WebElement parentElement, String childElement, String screenTitle) {
        try {
            return parentElement.findElement(UIMap.getLocator(childElement, this.platform));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find " + childElement + " on " + screenTitle + " screen", e);
        }
    }

    public List<WebElement> fetchChildListOfElements(WebElement parentElement, String childElements, String screenTitle) {
        try {
            return parentElement.findElements(UIMap.getLocator(childElements, this.platform));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find list of elements of " + childElements + " on " + screenTitle + " screen", e);
        }
    }

    public List<WebElement> fetchListOfElements(String elementsLocator, WebElement screen, String screenTitle) {
        try {
            return screen.findElements(UIMap.getLocator(elementsLocator, this.platform));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find list of" + elementsLocator + " on " + screenTitle + " screen", e);
        }
    }

    public WebElement fetchElementFromListOfElementsByIndex(List<WebElement> listOfWebElements, String childElement, int index, String screenTitle) {
        try {
            return listOfWebElements.get(index).findElement(UIMap.getLocator(childElement, this.platform));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not find element of " + childElement + " on " + screenTitle + " screen", e);
        }
    }

    public WebElement fetchElementByAccessibilityId(String accessibilityId) {
        return driver.findElement(MobileBy.AccessibilityId(accessibilityId));
    }

    public BaseScreen swipeFromToElement(WebElement fromElement, WebElement toElement) {
        try {
            int fromX = fromElement.getLocation().getX() + (fromElement.getSize().getWidth() / 2);
            int fromY = fromElement.getLocation().getY() + (fromElement.getSize().getHeight() / 2);

            int toX = toElement.getLocation().getX() + (toElement.getSize().getWidth() / 2);
            int toY = toElement.getLocation().getY() + (toElement.getSize().getHeight() / 2);
            if (this.platform.equals(Platforms.Platform.ANDROID.getValue())) {
                new TouchAction(driver)
                        .longPress(PointOption.point(fromX, fromY))
                        .moveTo(PointOption.point(toX, toY))
                        .release().perform()
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)));
                return this;
            } else if (this.platform.equals(Platforms.Platform.IOS.getValue())) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                Map<String, Object> params = new HashMap<>();
                params.put("duration", 1.0);
                params.put("fromX", fromX);
                params.put("fromY", fromY);
                params.put("toX", toX);
                params.put("toY", toY);
                js.executeScript("mobile: dragFromToForDuration", params);
                return this;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not swipe from: " + fromElement + " to: " + toElement, e);
        }
        return this;
    }

    // THIS METHOD IS USED TO OBTAIN THE VALUE OF THE SWITCH ELEMENT IN RELATION TO THE PLATFORM WE USE
    public Boolean getSwitchValue(WebElement element) {
        if (platform.equals(Platforms.Platform.IOS.getValue())) {
            return element.getAttribute("value").equals("1");
        }
        return Boolean.parseBoolean(element.getAttribute("checked"));
    }

    public Boolean isWebElementDisplayed(String elementLocator, WebElement screen, String screenTitle) {
        if(fetchListOfElements(elementLocator, screen, screenTitle).size() > 0) {
            return true;
        }
        return false;
    }
}
