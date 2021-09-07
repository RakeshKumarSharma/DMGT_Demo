package com.mailtravel.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver driver;

    private static ChromeOptions options;

    private static final String workingDir = System.getProperty("user.dir");

    private static String browser;

    TestContext testContext  = TestContext.getInstance();


    public void initialiseDriver() {
        if(driver!=null){
            return;
        }
        getLocalDriver();
    }

    private WebDriver getLocalDriver() {

        browser = testContext.readproperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = getChromeCustomOptions();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions ffOptions = new FirefoxOptions();
            ffOptions.addPreference("marionette", false);
            ffOptions.setAcceptInsecureCerts(true);
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(ffOptions);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public WebDriver getDriver(){
        return driver;
    }

    private ChromeOptions getChromeCustomOptions() {
        HashMap<String, String> chromePreferences = new HashMap();
        chromePreferences.put("profile.password_manager_enabled", "false");
        chromePreferences.put("credentials_enable_service", "false");
        chromePreferences.put("download.default_directory", workingDir + File.separator + "downloads");
        options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePreferences);
        options.addArguments("--disable-web-security");
        options.addArguments("--test-type");
        options.addArguments("--start-fullscreen");
        options.setCapability("chrome.switches", Collections.singletonList("--no-default-browser-check"));
        options.setCapability("chrome.switches", Collections.singletonList("--disable-logging"));
        options.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
        options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        options.setCapability("chrome.verbose", false);
        return options;
    }

    // runs a javascript command which does not need any element to be executed
    public Object runJavascript(String javascript) {
        return ((JavascriptExecutor) driver).executeScript(javascript);
    }

    // runs a javascript command which needs an element to be executed
    public Object runJavascript(String javascript, WebElement element) {
        return ((JavascriptExecutor) driver).executeScript(javascript, element);
    }

    // scroll to an specific element in the current browser window
    public void scrollToElement(WebElement element) {
        runJavascript("arguments[0].scrollIntoView(true);", element);
    }

}
