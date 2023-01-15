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


    @Test  // Test 14 Join button is displayed
    public void isJoinButtonVisible() {
        Assert.assertTrue(LandingPage.joinButton.isDisplayed());
    }

    @Test  // Test 16 About Us header is displayed
    public void isSectionAboutUsTitleVisible() throws InterruptedException {
        LandingPage.linkAboutUS.click();
        Wait();
        Assert.assertTrue(LandingPage.sectionAboutUsTitle.isDisplayed());
    }

    @Test  // Test 17 About Us text is displayed
    public void isSectionAboutUsTextVisible() throws InterruptedException {
        LandingPage.linkAboutUS.click();
        Wait();
        Assert.assertTrue(LandingPage.sectionAboutUsText.isDisplayed());
    }

    @Test  // Test 18 Why ExLab subheader is displayed
    public void isSectionAboutUsListTitleVisible()  {
        moveTo(LandingPage.sectionAboutUsListTitle);
        Assert.assertTrue(LandingPage.sectionAboutUsListTitle.isDisplayed());
    }

    @Test  // Test 19 Why ExLab text is displayed
    public void isSectionAboutUsListTextVisible()  {
        moveTo(LandingPage.sectionAboutUsListText);
        Assert.assertTrue(LandingPage.sectionAboutUsListText.isDisplayed());
    }

    @Test  // Test 20 Join button is displayed в разделе О нас
    public void isAboutUsJoinButton() {
        moveTo(LandingPage.aboutUsJoinButton);
        Assert.assertTrue(LandingPage.aboutUsJoinButton.isDisplayed());
    }

    @Test  // Test 22 Projects header is displayed
    public void isSectionProjectsTitle() throws InterruptedException {
        LandingPage.linkProjects.click();
        Wait();
        Assert.assertTrue(LandingPage.sectionProjectsTitle.isDisplayed());
    }

    @Test  // Test 23_1 ExLab logo is displayed at Projects module
    public void isExLabLogoDisplayed() {
        moveTo(LandingPage.firstProjectLogo);
        Assert.assertTrue(LandingPage.firstProjectLogo.isDisplayed());
    }

    @Test  // Test 23_2 HealthyLife logo is displayed at Projects module
    public void isHealthyLifeLogoDisplayed() {
        moveTo(LandingPage.secondProjectLogo);
        Assert.assertTrue(LandingPage.secondProjectLogo.isDisplayed());
    }

    @Test  // Test 23_3 Easyhelp logo is displayed at Projects module
    public void isEasyhelpLogoDisplayed() {
        moveTo(LandingPage.thirdProjectLogo);
        Assert.assertTrue(LandingPage.thirdProjectLogo.isDisplayed());
    }

    @Test  // Test 24_1 ExLab text is displayed at Projects module
    public void isExLabTextDisplayed() {
        moveTo(LandingPage.firstProjectText);
        Assert.assertTrue(LandingPage.firstProjectText.isDisplayed());
    }

    @Test  // Test 24_2 HealthyLife text is displayed at Projects module
    public void isHealthyLifeTextDisplayed() {
        moveTo(LandingPage.secondProjectText);
        Assert.assertTrue(LandingPage.secondProjectText.isDisplayed());
    }

    @Test  // Test 24_3 Easyhelp text is displayed at Projects module
    public void isEasyhelpTextDisplayed() {
        moveTo(LandingPage.thirdProjectText);
        Assert.assertTrue(LandingPage.thirdProjectText.isDisplayed());
    }

    @Test  // Test 25 Mentors header is displayed
    public void isSectionMentorsTitletDisplayed() throws InterruptedException {
        LandingPage.linkMentors.click();
        Wait();
        Assert.assertTrue(LandingPage.sectionMentorsTitle.isDisplayed());
    }

    @Test  // Test 26 Mentors info opens by "+" click
    public void isMentorsInfoOpensByClick() throws InterruptedException {
        LandingPage.linkMentors.click();
        Wait();
        LandingPage.firstMentorSpoiler.click();
        Wait();
        Assert.assertTrue(LandingPage.firstMentorName.isDisplayed());
        Assert.assertTrue(LandingPage.firstMentorSkillsList.isDisplayed());
    }

    @Test  // Test 27 Mentors foto is displayed
    public void isMentorsMentorsFotoDisplayed() throws InterruptedException {
        LandingPage.linkMentors.click();
        Wait();
        LandingPage.secondMentorSpoiler.click();
        Wait();
        Assert.assertTrue(LandingPage.secondMentorName.isDisplayed());
        Assert.assertTrue(LandingPage.secondMentorPhoto.isDisplayed());
    }

    @Test  // Test 29 Mentors info is closed by clicking "-"
    public void isMentorsInfoClosedByClick() throws InterruptedException {
        LandingPage.linkMentors.click();
        Wait();
        Assert.assertTrue(LandingPage.sectionMentorsTitle.isDisplayed());
        LandingPage.secondMentorSpoiler.click();
        Wait();
        Assert.assertTrue(LandingPage.secondMentorPhoto.isDisplayed());
        LandingPage.secondMentorSpoiler.click();
        Wait();
        Assert.assertFalse(LandingPage.secondMentorPhoto.isDisplayed());
    }

    @Test  // Test 30 Became mentor button is displayed
    public void isMentorsJoinButtonDisplayed() {
        moveTo(LandingPage.mentorsJoinButton);
        Assert.assertTrue(LandingPage.mentorsJoinButton.isDisplayed());
    }





}
