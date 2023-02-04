package driver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static Utils.Config.*;


public class driver {

    protected static WebDriver driver;

    public static void createDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(getChromeOptions());

        driver.manage().window().setSize(DIMENSION);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITY_WAIT));
        driver.manage().deleteAllCookies();

    }

    public static WebDriver getDriver (){
        if(driver == null)
            createDriver();
        return driver;
    }

    public static void close() {
        driver.close();
    }

    public static void quit() {
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