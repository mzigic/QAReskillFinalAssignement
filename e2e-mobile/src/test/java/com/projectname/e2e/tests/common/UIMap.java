package com.projectname.e2e.tests.common;

import com.projectname.e2e.tests.data.model.common.Platforms;
import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


// THIS CLASS IS USED TO EXTRACT LOCATORS FROM PROPERTIES FILES BECAUSE THERE ARE TWO PLATFORMS (IOS, ANDROID) AND LOCATORS ARE DIFFERENT. IN THIS WAY WE SIMPLIFY OUR CODE AND OUR PAGES ARE MUCH CLEARER.
public class UIMap {
    private static Properties properties;

    public static Properties getProperties(String fileName) {
        if (properties == null || properties.isEmpty()) {
            properties = new Properties();
            try {
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                InputStream input = classLoader.getResourceAsStream(fileName);
                properties.load(input);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return properties;
    }

    public static By getLocator(String elementName, String platform) throws Exception {

        String locator = getProperties(platform.equals(Platforms.Platform.ANDROID.getValue()) ? "NameMapping_Android.properties"
                : platform.equals(Platforms.Platform.IOS.getValue())
                ? "NameMapping_IOS.properties" : "").getProperty(elementName);
        String locatorType = locator.substring(0, locator.indexOf("="));
        String locatorValue = locator.substring(locator.indexOf("=") + 1, locator.length());

        if (locatorType.equalsIgnoreCase("id"))
            return By.id(locatorValue);
        else if (locatorType.equalsIgnoreCase("name"))
            return By.name(locatorValue);
        else if ((locatorType.equalsIgnoreCase("classname")) || (locatorType.equalsIgnoreCase("class")))
            return By.className(locatorValue);
        else if ((locatorType.equalsIgnoreCase("tagname")) || (locatorType.equalsIgnoreCase("tag")))
            return By.tagName(locatorValue);
        else if ((locatorType.equalsIgnoreCase("linktext")) || (locatorType.equalsIgnoreCase("link")))
            return By.linkText(locatorValue);
        else if (locatorType.equalsIgnoreCase("partiallinktext"))
            return By.partialLinkText(locatorValue);
        else if ((locatorType.equalsIgnoreCase("cssselector")) || (locatorType.equalsIgnoreCase("css")))
            return By.cssSelector(locatorValue);
        else if (locatorType.equalsIgnoreCase("xpath"))
            return By.xpath(locatorValue);
        else
            throw new Exception("Locator type '" + locatorType + "' not defined!!");
    }

    public static String getLocatorAsString(String elementName, String platform) {
        return getProperties(platform.equals(Platforms.Platform.ANDROID.getValue()) ? "NameMapping_Android.properties"
                : platform.equals(Platforms.Platform.IOS.getValue())
                ? "NameMapping_IOS.properties" : "").getProperty(elementName);
    }
}
