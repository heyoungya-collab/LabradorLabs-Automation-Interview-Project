package com.labradorlabs.heyoung_ui.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver() {
    }

    // Private static driver, visible only inside the class
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "headless-chrome":
                    ChromeOptions option = new ChromeOptions();
                    option.addArguments("--headless=new");
                    driver = new ChromeDriver(option);
                    break;
                default:
                    throw new RuntimeException("Unsupported browser type: " + browserType);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
