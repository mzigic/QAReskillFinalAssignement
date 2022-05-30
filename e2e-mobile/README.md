# htec-qa-e2e-mobile-template

### PRECONDITION

Android:
- After installing appium and appium inspector. Install Android studio, and set path to sdk in environment properties.
- Set desired capabilities in Base Suite class in getAndroidDesiredCapabilities() method and save them in Appium inspector.
- Turn on developer mode on your device and connect it with PC through USB cable. In developer options allow USB debugging and install via US
- Run appium server, and start session on appium inspector using saved desired capabilities in order to check if everything is set correctly
- After starting session, on mobile allow appium to install additional things. If your app is displayed in appium inspector everything is set correctly.
- Run your tests via IntelliJ
