package driver;

import Utils.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import static Utils.Config.DIMENSION;
import static Utils.Config.ON_HEADLESS;

public class driver {

    protected static WebDriver driver;

    public static void createDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().setSize(DIMENSION);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();

    }

    public static WebDriver getDriver (){
        if(driver == null)
            createDriver();
        return driver;
    }

    public static void quite() {
        driver.close();
        driver.quit();
    }

    protected static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (ON_HEADLESS) {
            chromeOptions.addArguments("--headless");
        }
        return chromeOptions;
    }

}