package org.test.selenium.pages;

import com.github.hemanthsridhar.pagefactory.FileBasedElementLocatorFactory;
import com.github.hemanthsridhar.pagefactory.SearchWithFieldDecorator;
import com.github.hemanthsridhar.pagefactory.dynamic.PageFactoryLoader;
import com.github.hemanthsridhar.support.FilePath;
import com.github.hemanthsridhar.support.SearchBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.selenium.constants.PageObjectsConfig;

import java.time.Duration;

/**
 * Created by hemanthsridhar on 1/6/19.
 */

@FilePath(value = PageObjectsConfig.LANDING_PAGE)
public class LandingPage extends PageInitializer {

    private final WebDriver driver;
    @SearchBy
    WebElement timings;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new SearchWithFieldDecorator(new FileBasedElementLocatorFactory(driver, this)), this);
    }

    public boolean waitUntilLSGMatchIsNotDisplayed() {
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofMinutes(5))
                        .pollingEvery(Duration.ofSeconds(1))
                        .ignoring(NoSuchElementException.class);
        wait.until(d -> timings.isDisplayed());
        return false;
    }
}