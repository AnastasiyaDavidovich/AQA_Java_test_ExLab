package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.BasePage;
import pageobject.LandingPage;

import java.time.Duration;

import static driver.driver.*;

public class LandingPageTest extends BaseTest  {

    public  LandingPage LandingPage;
    @BeforeTest
    public void start () {
        super.Start("http://test.exlab.team/");
        LandingPage = new LandingPage(driver);
    }

    @AfterTest
    public void finish() {
        super.Finish();
    }

    @Test  // Test 1 ExLab landing is availible by URL /http://test.exlab.team
    public void pageOpened() {
        String url = GetUrl();
        Assert.assertEquals(url, "http://test.exlab.team/", "Test failed: Url is not the same");
        String title = GetTitle();
        Assert.assertEquals(title,"ExLab Landing", "Test failed: title is not the same");
        Assert.assertTrue(LandingPage.logo.isDisplayed());
        System.out.println("________________________\ntest passed: website is opened:\n- URL is the same\n- Title is the same" +
                "\n- Logo is visible\n________________________");
    }


    @Test   // Test 2 По умолчанию открывается темная тема лендинга
    public void isDarkTheam() {
        String sunIconClass = LandingPage.themeIcon.getAttribute("Class");
        String rootImgClass = LandingPage.rootImg.getAttribute("Class");
        Assert.assertEquals(sunIconClass, "sc-fnykZs fEkGUM","Test failed: sun icon is not dark" );
        Assert.assertEquals(rootImgClass, "sc-gsnTZi kjBOCW", "Test failed: Root img is not dark");
    }

    @Test  // Test 3 ExLab logo is displayed
    public void isLogoVisible() {
        Assert.assertTrue(LandingPage.logo.isDisplayed());
    }

    @Test  // Test 4 Menu item О нас is displayed
    public void isLinkAboutUSVisible() {
        Assert.assertTrue(LandingPage.linkAboutUS.isDisplayed());
    }

    @Test // Test 5 Menu О нас link is equal to "#about"
    public void aboutLinkExist() {
        String aboutLink = LandingPage.linkAboutUS.getAttribute("href");
        Assert.assertTrue(aboutLink.contains("#about"));
    }

    @Test // Test 6 Menu item Проекты is displayed
    public void isLinkProjectsVisible() {
        Assert.assertTrue(LandingPage.linkProjects.isDisplayed());
    }

    @Test  // Test 7 Menu Проекты link is equal to "#projects"
    public void projectsLinkExist() {
        String aboutLink = LandingPage.linkProjects.getAttribute("href");
        Assert.assertTrue(aboutLink.contains("#projects"));
    }

    @Test  // Test 8 Menu item Менторы is displayed
    public void isLinkMentorsVisible() {
        Assert.assertTrue(LandingPage.linkMentors.isDisplayed());
    }

    @Test  // Test 9 Menu Менторы link is equal to "#mentors"
    public void mentorsLinkExist() {
        String aboutLink = LandingPage.linkMentors.getAttribute("href");
        Assert.assertTrue(aboutLink.contains("#mentors"));
    }

    @Test  // Test 10 Menu item StartUp для is displayed
    public void isLinkStartUpsVisible() {
        Assert.assertTrue(LandingPage.linkStartUps.isDisplayed());
    }

    @Test  // Test 11 Menu StartUp link is equal to "#startup"
    public void startUpsLinkExist() {
        String aboutLink = LandingPage.linkStartUps.getAttribute("href");
        Assert.assertTrue(aboutLink.contains("#startup"));
    }

    @Test  // Test 12 Button Sun Icon is displayed
    public void isThemeIconVisible() {
        Assert.assertTrue(LandingPage.themeIcon.isDisplayed());
    }


    @Test  // Test 13 Button Sun Icon changes background color
    public void isSunIconButtonChangesBackground() {
        String sunIconClass = LandingPage.themeIcon.getAttribute("Class");
        String rootImgClass = LandingPage.rootImg.getAttribute("Class");
        Assert.assertEquals(sunIconClass, "sc-fnykZs fEkGUM");
        Assert.assertEquals(rootImgClass, "sc-gsnTZi kjBOCW");
        LandingPage.themeIcon.click();
        String sunIconClass1 = LandingPage.themeIcon.getAttribute("Class");
        String rootImgClass1 = LandingPage.rootImg.getAttribute("Class");
        Assert.assertEquals(sunIconClass1, "sc-fnykZs lfkjFc");
        Assert.assertEquals(rootImgClass1, "sc-gsnTZi khsHPC");
    }


    @Test  // Test 14 Отображение кнопки [Присоединиться]
    public void isJoinButtonVisible() {
        Assert.assertTrue(LandingPage.joinButton.isDisplayed());
    }

    @Test  // Test 16 Отображение надписи О нас
    public void isSectionAboutUsTitleVisible() throws InterruptedException {
        LandingPage.linkAboutUS.click();
        Wait();
        Assert.assertTrue(LandingPage.sectionAboutUsTitle.isDisplayed());
    }

    @Test  // Test 17 -Отображение текста под надписью О нас
    public void isSectionAboutUsTextVisible() throws InterruptedException {
        LandingPage.linkAboutUS.click();
        Wait();
        Assert.assertTrue(LandingPage.sectionAboutUsText.isDisplayed());
    }

    @Test  // Test 18 -Отображение надписи Почему ExLab?
    public void isSectionAboutUsListTitleVisible()  {
        LandingPage.linkAboutUS.click();
        moveTo(LandingPage.sectionAboutUsListTitle);
        Assert.assertTrue(LandingPage.sectionAboutUsListTitle.isDisplayed());
    }

    @Test  // Test 19 --Отображение текста под надписью Почему ExLab?
    public void isSectionAboutUsListTextVisible()  {
        LandingPage.linkAboutUS.click();
        moveTo(LandingPage.sectionAboutUsListText);
        Assert.assertTrue(LandingPage.sectionAboutUsListText.isDisplayed());
    }

    @Test  // Test 20 Отображение кнопки [Присоединиться] в разделе О нас
    public void isAboutUsJoinButton() throws InterruptedException {
        LandingPage.linkAboutUS.click();
        moveTo(LandingPage.sectionAboutUsListTitle);
        Wait();
        Assert.assertTrue(LandingPage.aboutUsJoinButton.isDisplayed());
    }

    @Test  // Test 21 Отображение надписи Проекты
    public void isSectionProjectsTitle() throws InterruptedException {
        LandingPage.linkProjects.click();
        Wait();
        Assert.assertTrue(LandingPage.sectionProjectsTitle.isDisplayed());
    }



}
