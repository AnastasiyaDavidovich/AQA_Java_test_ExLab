package org.example;

import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.LandingPage;

import static Utils.Config.BASE_URL;

public class LandingPageTest extends BaseTest  {

    public LandingPage LandingPage;
    @BeforeMethod
    public void start () {
        LandingPage = new LandingPage(driver);
//        LandingPage.changeToNewTab(0);
        super.Start(BASE_URL);
    }

    @AfterTest
    public void finish() {
        //super.Finish();
        super.Quit();
    }

    @Test(description = "Test 1 ExLab landing is available by URL /http://test.exlab.team")
    public void pageOpened() {
        String url = GetUrl();
        Assert.assertEquals(url, "http://test.exlab.team/", "Test failed: Url is not the same");
        String title = GetTitle();
        Assert.assertEquals(title,"ExLab Landing", "Test failed: title is not the same");
        LandingPage.ifLogoDisplayed();
        System.out.println("________________________\ntest passed: website is opened:\n- URL is the same\n- Title is the same" +
                "\n- Logo is visible\n________________________");
    }


    @Test(description = "Test 2 Page opens with dark background")
    public void isDarkBackground() {
        String sunIconClass = LandingPage.themeIcon.getAttribute("Class");
        String rootImgClass = LandingPage.rootImg.getAttribute("Class");
        Assert.assertEquals(sunIconClass, "sc-fnykZs fEkGUM","Test failed: sun icon is not dark" );
        Assert.assertEquals(rootImgClass, "sc-gsnTZi kjBOCW", "Test failed: Root img is not dark");
    }

    @Test(description = "Test 3 ExLab logo is displayed")
    public void isLogoVisible() {
        LandingPage.ifLogoDisplayed();
    }

    @Test(description = "Test 4 Menu item About us is displayed")
    public void isLinkAboutUSVisible() {
        LandingPage.ifLinkAboutUS();
    }

    @Test(description = "Test 5 About us menu link opens About us module")
    public void aboutLinkExist() throws InterruptedException {
        LandingPage.linkAboutUsClick();
        Wait();
        LandingPage.ifSectionAboutUsTitle();
//        String aboutLink = LandingPage.linkAboutUS.getAttribute("href");
//        Assert.assertTrue(aboutLink.contains("#about"));
    }

    @Test(description = "Test 6 Menu item Projects is displayed")
    public void isLinkProjectsVisible() {
        LandingPage.ifLinkProjects();
    }

    @Test(description = "Test 7 Menu item Projects opens Projects module")
    public void projectsLinkExist() throws InterruptedException {
        LandingPage.linkProjectsClick();
        Wait();
        LandingPage.ifSectionProjectsTitle();
//        String aboutLink = LandingPage.linkProjects.getAttribute("href");
//        Assert.assertTrue(aboutLink.contains("#projects"));
    }

    @Test(description = "Test 8 Menu item Mentors is displayed")
    public void isLinkMentorsVisible() {
        LandingPage.ifLinkMentors();
    }

    @Test(description = "Test 9 Menu item Mentors opens Mentors module")
    public void mentorsLinkExist() throws InterruptedException {
        LandingPage.linkMentorsClick();
        Wait();
        LandingPage.ifSectionMentorsTitle();

//        String aboutLink = LandingPage.linkMentors.getAttribute("href");
//        Assert.assertTrue(aboutLink.contains("#mentors"));
    }

    @Test(description = "Test 10 Menu item StartUp для is displayed")
    public void isLinkStartUpsVisible() {
        LandingPage.ifLinkStartUp();
    }

    @Test(description = "Test 11 Menu item StartUp opens Start up module")
    public void startUpsLinkExist() throws InterruptedException {
        LandingPage.linkStartUpClick();
        Wait();
        LandingPage.ifSectionStartUpTitle();
//        String aboutLink = LandingPage.linkStartUps.getAttribute("href");
//        Assert.assertTrue(aboutLink.contains("#startup"));
    }

    @Test(description = "Test 12 Button Sun Icon is displayed")
    public void isThemeIconVisible() {
        LandingPage.ifThemeIcon();
    }


    @Test(description = "Test 13 Button Sun Icon changes background color")
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
        LandingPage.themeIcon.click();
    }


    @Test(description = "Test 14 Join button is displayed")
    public void isJoinButtonVisible() {
        LandingPage.ifJoinButton();
    }

    @Test(description = "Test 15 Join button opens telegram inviting page")
    public void isJoinButtonOpensInviting() {
        LandingPage.joinButton.click();
        LandingPage.changeToNewTab(1);
        String url = GetUrl();
        Assert.assertEquals(url,"https://t.me/ExLab_registration_bot", "TEST FAIL: Join button NOT opens telegram inviting page");
        Finish();
        LandingPage.changeToNewTab(0);
    }

    @Test(description = "Test 16 About Us header is displayed")
    public void isSectionAboutUsTitleVisible() {
        moveTo(LandingPage.sectionAboutUsTitle);
        Assert.assertTrue(LandingPage.sectionAboutUsTitle.isDisplayed());
    }

    @Test(description = "Test 17 About Us text is displayed")
    public void isSectionAboutUsTextVisible() {
        moveTo(LandingPage.sectionAboutUsText);
        Assert.assertTrue(LandingPage.sectionAboutUsText.isDisplayed());

//        LandingPage.linkAboutUS.click();
//        Wait();
//        Assert.assertTrue(LandingPage.sectionAboutUsText.isDisplayed());
    }

    @Test(description = "Test 18 Why ExLab subheader is displayed")
    public void isSectionAboutUsListTitleVisible()  {
        moveTo(LandingPage.sectionAboutUsListTitle);
        Assert.assertTrue(LandingPage.sectionAboutUsListTitle.isDisplayed());
    }

    @Test(description = "Test 19 Why ExLab text is displayed")
    public void isSectionAboutUsListTextVisible()  {
        moveTo(LandingPage.sectionAboutUsListText);
        Assert.assertTrue(LandingPage.sectionAboutUsListText.isDisplayed());
    }

    @Test(description = "Test 20 Join button is displayed в разделе О нас")
    public void isAboutUsJoinButton() {
        moveTo(LandingPage.aboutUsJoinButton);
        Assert.assertTrue(LandingPage.aboutUsJoinButton.isDisplayed());
    }

    @Test(description = "Test 21 Join button opens telegram inviting page")
    public void isJoinButtonOpensInvitingPage() {
        moveTo(LandingPage.aboutUsJoinButton);
        LandingPage.aboutUsJoinButton.click();
        LandingPage.changeToNewTab(1);
        String url = GetUrl();
        Assert.assertEquals(url,"https://t.me/ExLab_registration_bot", "TEST FAIL: Join button NOT opens telegram inviting page");
        Finish();
        LandingPage.changeToNewTab(0);
    }

    @Test(description = "Test 22 Projects header is displayed")
    public void isSectionProjectsTitle() {
        moveTo(LandingPage.sectionProjectsTitle);
        Assert.assertTrue(LandingPage.sectionProjectsTitle.isDisplayed());

//        LandingPage.linkProjects.click();
//        Wait();
//        Assert.assertTrue(LandingPage.sectionProjectsTitle.isDisplayed());
    }

    @Test(description = "Test 23_1 ExLab logo is displayed at Projects module")
    public void isExLabLogoDisplayed() {
        moveTo(LandingPage.firstProjectLogo);
        Assert.assertTrue(LandingPage.firstProjectLogo.isDisplayed());
    }

    @Test(description = "Test 23_2 HealthyLife logo is displayed at Projects module")
    public void isHealthyLifeLogoDisplayed() {
        moveTo(LandingPage.secondProjectLogo);
        Assert.assertTrue(LandingPage.secondProjectLogo.isDisplayed());
    }

    @Test(description = "Test 23_3 Easyhelp logo is displayed at Projects module")
    public void isEasyhelpLogoDisplayed() {
        moveTo(LandingPage.thirdProjectLogo);
        Assert.assertTrue(LandingPage.thirdProjectLogo.isDisplayed());
    }

    @Test(description = "Test 24_1 ExLab text is displayed at Projects module")
    public void isExLabTextDisplayed() {
        moveTo(LandingPage.firstProjectText);
        Assert.assertTrue(LandingPage.firstProjectText.isDisplayed());
    }

    @Test(description = "Test 24_2 HealthyLife text is displayed at Projects module")
    public void isHealthyLifeTextDisplayed() {
        moveTo(LandingPage.secondProjectText);
        Assert.assertTrue(LandingPage.secondProjectText.isDisplayed());
    }

    @Test(description = "Test 24_3 Easyhelp text is displayed at Projects module")
    public void isEasyhelpTextDisplayed() {
        moveTo(LandingPage.thirdProjectText);
        Assert.assertTrue(LandingPage.thirdProjectText.isDisplayed());
    }

    @Test(description = "Test 25 Mentors header is displayed")
    public void isSectionMentorsTitleDisplayed()  {
        moveTo(LandingPage.sectionMentorsTitle);
        Assert.assertTrue(LandingPage.sectionMentorsTitle.isDisplayed());
    }

    @Test(description = "Test 26 Mentors info opens by + click")
    public void isMentorsInfoOpensByClick() throws InterruptedException {
        LandingPage.linkMentors.click();
        Wait();
        LandingPage.firstMentorSpoiler.click();
        Wait();
        Assert.assertTrue(LandingPage.firstMentorName.isDisplayed());
        Assert.assertTrue(LandingPage.firstMentorSkillsList.isDisplayed());
    }

    @Test(description = "Test 27 Mentors foto is displayed")
    public void isMentorsFotoDisplayed() throws InterruptedException {
        LandingPage.linkMentors.click();
        Wait();
        LandingPage.secondMentorSpoiler.click();
        Wait();
        Assert.assertTrue(LandingPage.secondMentorName.isDisplayed());
        Assert.assertTrue(LandingPage.secondMentorPhoto.isDisplayed());
    }

    @Test(description = "Test 28 Info about 4 mentors is displayed")
    public void isInfo4MentorsDisplayed()  {
        moveTo(LandingPage.sectionMentorsTitle);
        Assert.assertEquals(LandingPage.countMentors(),4);
    }

    @Test(description = "Test 29 Mentors info is closed by clicking -")
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

    @Test(description = "Test 30 Became mentor button is displayed")
    public void isMentorsJoinButtonDisplayed() {
        moveTo(LandingPage.mentorsJoinButton);
        Assert.assertTrue(LandingPage.mentorsJoinButton.isDisplayed());
    }

    @Test(description = "Test 31 StartUp header is displayed")
    public void isStartUpTitleDisplayed() {
        moveTo(LandingPage.sectionStartUpTitle);
        Assert.assertTrue(LandingPage.sectionStartUpTitle.isDisplayed());
    }

    @Test(description = "Test 32 StartUp text is displayed")
    public void isStartUpTextDisplayed() {
        moveTo(LandingPage.sectionStartUpText);
        Assert.assertTrue(LandingPage.sectionStartUpText.isDisplayed());
    }

    @Test(description = "Test 33 Fined button is displayed")
    public void isFinedButtonDisplayed() {
        moveTo(LandingPage.findButton);
        Assert.assertTrue(LandingPage.findButton.isDisplayed());
    }

    @Test(description = "Test 34 Help project header is displayed")
    public void isHelpProjectTitleDisplayed() {
        moveTo(LandingPage.sectionHelpProjectTitle);
        Assert.assertTrue(LandingPage.sectionHelpProjectTitle.isDisplayed());
    }

    @Test(description = "Test 35 Help project text is displayed")
    public void isHelpProjectTextDisplayed() {
        moveTo(LandingPage.sectionHelpProjectText);
        Assert.assertTrue(LandingPage.sectionHelpProjectText.isDisplayed());
    }

    @Test(description = "Test 36 Boosty button is displayed")
    public void isBoostyButtonDisplayed() {
        moveTo(LandingPage.boostyButton);
        Assert.assertTrue(LandingPage.boostyButton.isDisplayed());
    }

    @Test(description = "Test 37 Boosty button opens ExLab.boosty page")
    public void isBoostyButtonOpensBoostyPage() {
        moveTo(LandingPage.boostyButton);
        LandingPage.boostyButton.click();
        LandingPage.changeToNewTab(1);
        String url = GetUrl();
        Assert.assertEquals(url,"https://boosty.to/exlab_startup", "TEST FAIL: Join button NOT opens ExLab.boosty page");
        Finish();
        LandingPage.changeToNewTab(0);
    }

    @Test(description = "Test 38 Patreon button is displayed")
    public void isPatreonButtonDisplayed() {
        moveTo(LandingPage.patreonButton);
        Assert.assertTrue(LandingPage.patreonButton.isDisplayed());
    }

    @Test(description = "Test 39 Contacts header is displayed")
    public void isContactsTitleDisplayed() {
        moveTo(LandingPage.sectionContactsTitle);
        Assert.assertTrue(LandingPage.sectionContactsTitle.isDisplayed());
    }

    @Test(description = "Test 40 Contacts text is displayed")
    public void isContactsTextDisplayed() {
        moveTo(LandingPage.contactsText);
        Assert.assertTrue(LandingPage.contactsText.isDisplayed());
    }

    @Test(description = "Test 41 Logo ExLab in Footer is displayed")
    public void isFooterLogoDisplayed() {
        moveTo(LandingPage.footerLogo);
        Assert.assertTrue(LandingPage.footerLogo.isDisplayed());
    }
    @Test(description = "Test 42 Logo Copywrite in footer is displayed")
    public void isFooterCopywriteDisplayed() {
        moveTo(LandingPage.footerCopywrite);
        Assert.assertTrue(LandingPage.footerCopywrite.isDisplayed());
    }

    @Test(description = "Test 43 Linkedin link in footer is displayed")
    public void isLinkedinLinkDisplayed() {
        moveTo(LandingPage.footerLinkedinText);
        Assert.assertTrue(LandingPage.footerLinkedinText.isDisplayed());
    }

    @Test(description = "Test 44 Linkedin link in footer opens correct page")
    public void isLinkedinLinkOpenLinkedinPage() {
        moveTo(LandingPage.footerLinkedinLink);
        LandingPage.footerLinkedinLink.click();
        LandingPage.changeToNewTab(1);
        String url = GetUrl();
        Assert.assertTrue(url.contains("linkedin.com"), "TEST FAIL: Join button NOT opens Linkedin page");
        Finish();
        LandingPage.changeToNewTab(0);
    }

    @Test(description = "Test 45 Instagram link in footer is displayed")
    public void isInstagramLinkDisplayed() {
        moveTo(LandingPage.footerInstaText);
        Assert.assertTrue(LandingPage.footerInstaText.isDisplayed());
    }

    @Test(description = "Test 46 Instagram link in footer opens correct page")
    public void isInstagramLinkOpenLinkedinPage() {
        moveTo(LandingPage.footerInstaLink);
        LandingPage.footerInstaLink.click();
        LandingPage.changeToNewTab(1);
        String url = GetUrl();
        Assert.assertTrue(url.contains("instagram.com"), "TEST FAIL: Join button NOT opens Instagram page");
        Finish();
        LandingPage.changeToNewTab(0);
    }

    @Test(description = "Test 47 Telegram link in footer is displayed")
    public void isTelegramLinkDisplayed() {
        moveTo(LandingPage.footerTelegramText);
        Assert.assertTrue(LandingPage.footerTelegramText.isDisplayed());
    }

    @Test(description = "Test 48 Telegram link in footer opens correct page")
    public void isTelegramLinkOpenLinkedinPage() {
        moveTo(LandingPage.footerTelegramLink);
        LandingPage.footerTelegramLink.click();
        LandingPage.changeToNewTab(1);
        String url = GetUrl();
        Assert.assertTrue(url.contains("t.me/ExLabChannel"), "TEST FAIL: Join button NOT opens Telegram page");
        Finish();
        LandingPage.changeToNewTab(0);
    }

    @Test(description = "Test 49 Youtube link in footer is displayed")
    public void isYoutubeLinkDisplayed() {
        moveTo(LandingPage.footerYoutubeText);
        Assert.assertTrue(LandingPage.footerYoutubeText.isDisplayed());
    }

    @Test(description = "Test 50 Telegram link in footer opens correct page")
    public void isYoutubeLinkOpenLinkedinPage() {
        moveTo(LandingPage.footerYoutubeLink);
        LandingPage.footerYoutubeLink.click();
        LandingPage.changeToNewTab(1);
        String url = GetUrl();
        Assert.assertTrue(url.contains("youtube.com"), "TEST FAIL: Join button NOT opens Youtube page");
        Finish();
        LandingPage.changeToNewTab(0);
    }

    @Test(description = "Test 51 Exlab e-mail link in footer is displayed")
    public void isMailLinkDisplayed() {
        moveTo(LandingPage.footerMailLink);
        Assert.assertTrue(LandingPage.footerMailLink.isDisplayed());
    }

}

