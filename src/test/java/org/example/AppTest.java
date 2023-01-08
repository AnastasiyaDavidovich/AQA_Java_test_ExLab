package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.example.factory.WebDriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class AppTest {

    @Test
    public void ifOpened()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
//        webDriver.get("http://test.exlab.team/");
        webDriver.get("http://exlab.team/");

//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        String url = webDriver.getCurrentUrl();
        String title = webDriver.getTitle();

        Assert.assertEquals(url, "http://exlab.team/");
        Assert.assertEquals(title, "ExLab Landing");


//        System.out.println(title);

//        WebElement firstResult = new WebDriverWait(webDriver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='header']//img")));
//
//        WebElement logo = webDriver.findElement(By.xpath("//div[@id='header']//img"));
//        Assert.assertTrue(logo.isDisplayed());

        webDriver.close();
        webDriver.quit();

    }
}
