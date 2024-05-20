package seleniumfirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;

    static {
        String chromeDriver = "C:\\Users\\andre\\Documentos\\Selenium\\SeleniumZajuna\\software\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromeDriver );
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        actions = new Actions(driver);
    }
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    public static void navegar(String url){
        driver.get(url);
    }
    public static void cerrar(){
        driver.quit();
    }

}
