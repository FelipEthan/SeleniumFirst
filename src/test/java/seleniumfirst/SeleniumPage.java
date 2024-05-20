package seleniumfirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumPage extends BasePage {

    public SeleniumPage() {
        super(driver);
    }

    public void navegar() {
        navegar("https://www.selenium.dev/selenium/web/web-form.html");
    }
    public static void cerrar() {
        driver.quit();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void submitForm() {
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        submitButton.click();
    }

    public String getMessage() {
        WebElement message = driver.findElement(By.id("message"));
        return message.getText();
    }
   
}
