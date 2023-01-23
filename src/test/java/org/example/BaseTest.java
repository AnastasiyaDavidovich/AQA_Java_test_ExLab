package org.example;



import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.BasePage;


import java.time.Duration;

import static Utils.Config.THREAD_SLEEP;
import static driver.driver.*;


public class BaseTest {

protected WebDriver driver;
protected static Actions actions;
    protected WebDriverWait waiter;


    public BaseTest()
    {
        createDriver();
        driver = getDriver();
        actions = new Actions(driver);
        waiter = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public void Start (String url) {
        driver.get(url);

    }

    public void Finish() {
        quite();
    }


    public void moveTo(WebElement webElement) {
        actions.scrollToElement(webElement).build().perform();
    }

    public void Wait() throws InterruptedException {
        Thread.sleep(THREAD_SLEEP);
    }
    public String GetTitle() {
        return driver.getTitle();
    }

    public String GetUrl() {
        return driver.getCurrentUrl();
    }
   }
