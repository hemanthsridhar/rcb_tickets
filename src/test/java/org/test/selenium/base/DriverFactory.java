package org.test.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public synchronized static WebDriver getDriver() {
        return driver;
    }

    private void setDriver(WebDriver driver) {
        DriverFactory.driver = driver;
    }

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        setDriver(driver);
        driver.get("https://shop.royalchallengers.com/ticket");
    }

    @After
    public void after() {
        getDriver().quit();
    }
}
