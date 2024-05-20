package seleniumfirst;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

public class Steps {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("the user navigates to the web form")
    public void navigateToWebForm() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }
    @When("the user fills out the form")
    public void userFillsOutForm() {
        WebElement text = driver.findElement(By.name("my-text"));
        WebElement text2 = driver.findElement(By.name("my-password"));
        WebElement textArea = driver.findElement(By.name("my-textarea"));
        WebElement obtener = driver.findElement(By.name("my-readonly"));
        WebElement obtener2 = driver.findElement(By.xpath("//label[contains(text(),'Color picker')]"));

        String dato = "Color picker";

        text.clear();
        text.sendKeys("Andres Felipe Quimbayo");

        text2.clear();
        text2.sendKeys("Selenium");

        textArea.clear();
        textArea.sendKeys("La mayoría de los usuarios de Selenium ejecutan muchas sesiones y necesitan organizarlas para minimizar la duplicación y mantener el código más fácil de mantener. Continúe leyendo para aprender cómo poner este código en contexto para su caso de uso con el uso de Selenium.");

        String readonlyText = obtener.getAttribute("value");
        assertEquals("Readonly input", readonlyText, "El campo Entrada contiene el texto incorrecto");

        String visibleText = obtener2.getText().trim();
        System.out.println("El campo Entrada contiene el texto: " + visibleText);

        if (visibleText.equals(dato)) {
            System.out.println("Los campos son iguales");
        } else {
            System.out.println("Los campos no son iguales");
        }

        assertEquals(dato, visibleText, "Los campos no son iguales");
    }

    @Then("the page title should be {string}")
    public void verifyPageTitle(String expectedTitle) {
        String pageTitle = driver.getTitle();
        assertEquals(expectedTitle, pageTitle);
    }

    @When("the user submits the form")
    public void submitForm() {
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        submitButton.click();
    }

    @Then("the message should be {string}")
    public void verifyMessage(String expectedMessage) {
        WebElement message = driver.findElement(By.id("message"));
        String actualMessage = message.getText();
        assertEquals(expectedMessage, actualMessage);
    }
}
