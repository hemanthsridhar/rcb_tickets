package org.test.selenium.test;

import org.junit.Assert;
import org.junit.Test;
import org.test.selenium.pages.PageInitializer;

/**
 * Created by hemanthsridhar on 1/6/19.
 */
public class RCBTest extends PageInitializer {

    @Test
    public void checkIfLsgMatchIsPresent() throws InterruptedException {
        Assert.assertTrue("LSG Match is still displayed",
                landingPage()
                .waitUntilLSGMatchIsNotDisplayed());
    }
}
