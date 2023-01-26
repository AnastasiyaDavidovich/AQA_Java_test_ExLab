package pageobject;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static driver.driver.getDriver;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void ifLogoDisplayed(){
        logo.isDisplayed();
    }

    public void ifLinkAboutUS(){
        linkAboutUS.isDisplayed();
    }

    public LandingPage linkAboutUsClick() {
        linkAboutUS.click();
        return this;
    }

    public void ifSectionAboutUsTitle(){
        sectionAboutUsTitle.isDisplayed();
    }

    public void ifLinkProjects(){
        linkProjects.isDisplayed();
    }

    public LandingPage linkProjectsClick() {
        linkProjects.click();
        return this;
    }

    public void ifSectionProjectsTitle(){
        sectionProjectsTitle.isDisplayed();
    }

    public void ifLinkMentors(){
        linkMentors.isDisplayed();
    }

    public LandingPage linkMentorsClick() {
        linkMentors.click();
        return this;
    }

    public void ifSectionMentorsTitle(){
        sectionMentorsTitle.isDisplayed();
    }

    public void ifLinkStartUp(){
        linkStartUps.isDisplayed();
    }

    public LandingPage linkStartUpClick() {
        linkStartUps.click();
        return this;
    }

    public void ifSectionStartUpTitle(){
        sectionStartUpTitle.isDisplayed();
    }

    public void ifThemeIcon(){
        themeIcon.isDisplayed();
    }

    public void ifJoinButton(){
        joinButton.isDisplayed();
    }

    public LandingPage joinButtonClick() {
        joinButton.click();
        return this;
    }

    public void changeToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
    }


    public Integer countMentors(){
        List<WebElement> list = mentorsBlock.findElements(By.xpath("//div[@id='mentors']/div/div/div"));
        return list.size();
    }


    @FindBy(xpath = "//*[@id='logo_mobile']")
    WebElement logo;

    @FindBy(xpath = "//*[@id='header']/div[1]//li[1]/a")
    WebElement linkAboutUS;

    @FindBy(xpath = "//*[@id='header']/div[1]//li[2]/a")
    WebElement linkProjects;

    @FindBy(xpath = "//*[@id='header']/div[1]//li[3]/a")
    public WebElement linkMentors;

    @FindBy(xpath = "//*[@id='header']/div[1]//li[4]/a")
    public WebElement linkStartUps;

    @FindBy(xpath = "//*[@id='header']/div[1]/div[2]/div[2]/div[1]/div")
    public WebElement themeIcon;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")
    public WebElement rootImg;

//    @FindBy(xpath = "//*[@id='header']/div[1]/div[2]/div[2]/div[1]/div")
//    private WebElement themeIcon;

    @FindBy(xpath = "//*[@id='logo_mobile']")
    public WebElement joinButton;


//    @FindBy(xpath = "//*[@id='header']//div[2]/a")
//    private WebElement joinButtonLink;
//
////    === general description
//    @FindBy(xpath = "//*[@id='header']//img")
//    private WebElement bigLogo;
//    @FindBy(xpath = "//*[@id='header']/div[2]/div/div[1]/div")
//    private WebElement headerList;
//    @FindBy(xpath = "//*[@id='header']//ol/li[1]/span[1]")
//    private WebElement firstNumberList;
//    @FindBy(xpath = "//*[@id='header']//ol/li[2]/span[1]")
//    private WebElement secondNumberList;
//    @FindBy(xpath = "//*[@id='header']//ol/li[3]/span[1]")
//    private WebElement thirdNumberList;
//    @FindBy(xpath = "//*[@id='header']//ol/li[4]/span[1]")
//    private WebElement fourthNumberList;
////   ===
//    @FindBy(xpath = "//*[@id='header']//ol/li[1]/span[2]")
//    private WebElement firstTextList;
//    @FindBy(xpath = "//*[@id='header']//ol/li[2]/span[2]")
//    private WebElement secondTextList;
//    @FindBy(xpath = "///*[@id='header']//ol/li[3]/span[2]")
//    private WebElement thirdTextList;
//    @FindBy(xpath = "//*[@id='header']//ol/li[4]/span[2]")
//    private WebElement fourthTextList;
////    ===
//    @FindBy(xpath = "//*[@id='header']//ul/li/span[1]")
//    private WebElement plusInList;
//    @FindBy(xpath = "//*[@id='header']//ul/li/span[2]")
//    private WebElement plusTextInList;
//    ==== About Us
    @FindBy(xpath = "//*[@id='about']/div[1]")
    public WebElement sectionAboutUsTitle;
    @FindBy(xpath = "//*[@id='about']/div[2]/p")
    public WebElement sectionAboutUsText;
    @FindBy(xpath = "//*[@id='about']/div[3]/div[1]")
    public WebElement sectionAboutUsListTitle;
    @FindBy(xpath = "//*[@id='about']/div[3]/ol")
    public WebElement sectionAboutUsListText;
//    @FindBy(xpath =  "//*[@id='about']//li[1]/span[1]")
//    private WebElement aboutUsListFirstNumber;
//    @FindBy(xpath = "//*[@id='about']//li[2]/span[1]")
//    private WebElement aboutUsListSecondNumber;
//    @FindBy(xpath = "//*[@id='about']//li[3]/span[1]")
//    private WebElement aboutUsListThirdNumber;
//    @FindBy(xpath = "//*[@id='about']//li[4]/span[1]")
//    private WebElement aboutUsListFourthNumber;
////     ===
//    @FindBy(xpath = "//*[@id='about']//li[1]/span[2]")
//    private WebElement aboutUsListFirstText;
//    @FindBy(xpath = "//*[@id='about']//li[2]/span[2]")
//    private WebElement aboutUsListSecondText;
//    @FindBy(xpath = "//*[@id='about']//li[3]/span[2]")
//    private WebElement aboutUsListThirdText;
//    @FindBy(xpath = "//*[@id='about']//li[4]/span[2]")
//    private WebElement aboutUsListFourthText;
////    ===
    @FindBy(xpath = "//*[@id='about']/div[3]/div[2]")
    public WebElement aboutUsJoinButton;
//    @FindBy(xpath = "//*[@id='about']/div[3]/div[2]/a")
//    public WebElement aboutUsJoinButtonText;
////    ==== Projects
    @FindBy(xpath = "//*[@id='projects-title-wrapper']/div")
    public WebElement sectionProjectsTitle;
//    @FindBy(xpath = "//*[@id='projects']//div[1]/h2")
//    private WebElement firstProjectName;
    @FindBy(xpath = "//*[@id='projects']//div[1]/img")
    public WebElement firstProjectLogo;
    @FindBy(xpath = "//*[@id='projects']//div[1]/p")
    public WebElement firstProjectText;
//    @FindBy(xpath = "//*[@id='projects']//div[1]/span")
//    private WebElement firstProjectOwner;
////   ===
//    @FindBy(xpath = "//*[@id='projects']//div[2]/h2")
//    private WebElement secondProjectName;
    @FindBy(xpath = "//*[@id='projects']//div[2]/img")
    public WebElement secondProjectLogo;
    @FindBy(xpath = "//*[@id='projects']//div[2]/p")
    public WebElement secondProjectText;
//    @FindBy(xpath = "//*[@id='projects']//div[2]/span")
//    private WebElement secondProjectOwner;
////   ===
//    @FindBy(xpath = "//*[@id='projects']//div[3]/h2")
//    private WebElement thirdProjectName;
    @FindBy(xpath = "//*[@id='projects']//div[3]/img")
    public WebElement thirdProjectLogo;
    @FindBy(xpath = "//*[@id='projects']//div[3]/p")
    public WebElement thirdProjectText;
//    @FindBy(xpath = "//*[@id='projects']//div[3]/span")
//    private WebElement thirdProjectOwner;
////  ====== Mentors
    @FindBy(xpath = "//*[@id='mentors']/div[1]")
    public WebElement sectionMentorsTitle;
    @FindBy (xpath = "//div[@id='mentors']/div/div/div")
    private WebElement mentorsBlock;
    @FindBy(xpath = "//*[@id='mentors']//div[1]/div[1]/p[1]")
    public WebElement firstMentorName;
//    @FindBy(xpath = "//*[@id='mentors']//div[1]/div[1]/p[2]")
//    private WebElement firstMentorJobTitle;
    @FindBy(xpath = "//*[@id='mentors']//div[1]/div[1]/span")
    public WebElement firstMentorSpoiler;
    @FindBy(xpath = "//*[@id='mentors']//div[1]/div[2]/ul")
    public WebElement firstMentorSkillsList;
//    @FindBy(xpath = "//*[@id='mentors']//div[1]//img")
//    private WebElement firstMentorPhoto;
////    ===
    @FindBy(xpath = "//*[@id='mentors']//div[2]/div[1]/p[1]")
    public WebElement secondMentorName;
//    @FindBy(xpath = "//*[@id='mentors']//div[2]/div[1]/p[2]")
//    private WebElement secondMentorJobTitle;
    @FindBy(xpath = "//*[@id='mentors']//div[2]/div[1]/span")
    public WebElement secondMentorSpoiler;
//    @FindBy(xpath = "//*[@id='mentors']//div[2]/div[2]/ul")
//    private WebElement secondMentorSkillsList;
    @FindBy(xpath = "//*[@id='mentors']//div[2]/div[2]/img")
    public WebElement secondMentorPhoto;
////    ===
//    @FindBy(xpath = "//*[@id='mentors']//div[3]/div[1]/p[1]")
//    private WebElement thirdMentorName;
//    @FindBy(xpath = "//*[@id='mentors']//div[3]/div[1]/p[2]")
//    private WebElement thirdMentorJobTitle;
//    @FindBy(xpath = "//*[@id='mentors']//div[3]/div[1]/span")
//    private WebElement thirdMentorSpoiler;
//    @FindBy(xpath = "//*[@id='mentors']//div[3]/div[2]/ul")
//    private WebElement thirdMentorSkillsList;
//    @FindBy(xpath = "//*[@id='mentors']//div[3]//img")
//    private WebElement thirdMentorPhoto;
////    ===
//    @FindBy(xpath = "//*[@id='mentors']//div[4]/div[1]/p[1]")
//    private WebElement fourthMentorName;
//    @FindBy(xpath = "//*[@id='mentors']//div[4]/div[1]/p[2]")
//    private WebElement fourthMentorJobTitle;
//    @FindBy(xpath = "//*[@id='mentors']//div[4]/div[1]/span")
//    private WebElement fourthMentorSpoiler;
//    @FindBy(xpath = "//*[@id='mentors']//div[4]/div[2]/ul")
//    private WebElement fourthMentorSkillsList;
//    @FindBy(xpath = "//*[@id='mentors']//div[4]//img")
//    private WebElement fourthMentorPhoto;
////    ===
    @FindBy(xpath = "//*[@id='mentors']/div[2]/div[2]/a")
    public WebElement mentorsJoinButton;
//    @FindBy(xpath = "//*[@id='mentors']/div[2]/div[2]/a/text()")
//    private WebElement mentorsJoinButtonText;
////    ==== StartUp
    @FindBy(xpath = "//*[@id='startup-title-wrapper']/div")
    public WebElement sectionStartUpTitle;
    @FindBy(xpath = "//*[@id='startup']/div[2]")
    public WebElement sectionStartUpText;
//    @FindBy(xpath = "//*[@id='startup-title-wrapper']//div[1]/h2")
//    private WebElement startUpForJunTitle;
//    @FindBy(xpath = "//*[@id='startup-title-wrapper']//div[1]/p[1]")
//    private WebElement startUpForJunText1;
//    @FindBy(xpath = "//*[@id='startup-title-wrapper']//div[1]/p[2]")
//    private WebElement startUpForJunText2;
//    @FindBy(xpath = "//*[@id='startup-title-wrapper']//div[1]/p[3]")
//    private WebElement startUpForJunText3;
//    @FindBy(xpath = "//*[@id='startup-title-wrapper']//div[2]/h2")
//    private WebElement startUpForRecruiterTitle;
//    @FindBy(xpath = "//*[@id='startup-title-wrapper']//div[2]/p[1]")
//    private WebElement startUpForRecruiterText;
    @FindBy(xpath = "//*[@id='startup']/div[2]/div[2]/div")
    public WebElement findButton;
//    @FindBy(xpath = "//*[@id='startup']/div[2]/div[2]/div/a")
//    private WebElement findButtonText;
////    ===== Help Project
    @FindBy(xpath = "//*[@id='descrBg']/div[6]/div/div[1]")
    public WebElement sectionHelpProjectTitle;
    @FindBy(xpath = "//*[@id='descrBg']/div[6]/div/div[2]/div[1]")
    public WebElement sectionHelpProjectText;
//    @FindBy(xpath = "//*[@id='descrBg']/div[6]/div//div[1]/div[1]")
//    private WebElement sectionHelpProjectText1;
//    @FindBy(xpath = "//*[@id='descrBg']/div[6]/div//div[1]/div[2]")
//    private WebElement sectionHelpProjectText2;
    @FindBy(xpath = "//*[@id='descrBg']/div[6]//a[1]")
    public WebElement boostyButton;
//    @FindBy(xpath = "//*[@id='descrBg']/div[6]//a[1]/text()")
//    private WebElement boostyButtonText;
    @FindBy(xpath = "//*[@id='descrBg']/div[6]//a[2]")
    public WebElement patreonButton;
//    @FindBy(xpath = "//*[@id='descrBg']/div[6]//a[2]/text()")
//    private WebElement patreonButtonText;
////    ===== Contacts
    @FindBy(xpath = "//*[@id='footer']/div[1]/div[1]")
    public WebElement sectionContactsTitle;
    @FindBy(xpath = "//*[@id='footer']/div[1]/div[2]")
    public WebElement contactsText;
//    @FindBy(xpath = "//*[@id='footer']/div[3]/div[1]/div[1]")
//    private WebElement sectionContactsLogo;
////    ===
//    @FindBy(xpath = "//*[@id='footer']/div[3]//li[1]")
//    private WebElement contactsLinkedinText;
//    @FindBy(xpath = "//*[@id='footer']/div[3]//li[1]/a")
//    private WebElement contactsLinkedinLink;
//    @FindBy(xpath = "//*[@id='footer']/div[3]//li[2]")
//    private WebElement contactsInstaText;
//    @FindBy(xpath = "//*[@id='footer']/div[3]//li[2]/a")
//    private WebElement contactsInstaLink;
//    @FindBy(xpath = "//*[@id='footer']/div[3]//li[3]")
//    private WebElement contactsTelegramText;
//    @FindBy(xpath = "//*[@id='footer']/div[3]//li[3]/a")
//    private WebElement contactsTelegramLink;
//    @FindBy(xpath = "//*[@id='footer']/div[3]//li[4]")
//    private WebElement contactsYoutubeText;
//    @FindBy(xpath = "//*[@id='footer']/div[3]//li[4]/a")
//    private WebElement contactsYoutubeLink;
//    @FindBy(xpath = "//*[@id='footer']/div[3]/div[2]/a")
//    private WebElement contactsMailLink;







}



