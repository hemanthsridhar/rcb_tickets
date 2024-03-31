package org.test.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static WebDriver driver;

    public synchronized static WebDriver getDriver() {
        return driver;
    }

    private void setDriver(WebDriver driver) {
        DriverFactory.driver = driver;
    }

    @Before
    public void before() throws MalformedURLException {
        boolean isLocal = Boolean.parseBoolean(System.getProperty("IS_LOCAL").equals("false") ? "false" : "true");

        if(isLocal) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(chromeOptions);
        }
        else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--remote-allow-origins=*");
            options.merge(capabilities);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }

        setDriver(driver);
        driver.get("https://shop.royalchallengers.com/ticket");
    }

    @After
    public void after() {
        getDriver().quit();
    }
}
