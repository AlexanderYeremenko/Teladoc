package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Driver {
    private static String propertyPath = "src/test/resources/conf/configuration.properties";
    private static WebDriver driver;




    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.readProperty("browser", propertyPath)) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    default:
                        System.out.println("Invalid browser type");
                }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            }
        return driver;
    }



    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null)
            driver.quit();
        driver = null;
    }}
