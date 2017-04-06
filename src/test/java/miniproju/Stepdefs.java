
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stepdefs {

    WebDriver driver = new ChromeDriver();
    String baseUrl = "https://pure-coast-94327.herokuapp.com/";

    @Given("^uusi viite is selected$")
    public void uusi_viite_is_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("Lisää uusi kirjaviite"));
        element.click();
    }

    @When("^nimi \"([^\"]*)\" and kirjoittaja \"([^\"]*)\" and publisher \"([^\"]*)\" and julkaisuvuosi \"([^\"]*)\" and julkaisijan osoite \"([^\"]*)\" and painos \"([^\"]*)\" are entered$")
    public void nimi_and_kirjoittaja_and_publisher_and_julkaisuvuosi_and_julkaisijan_osoite_and_painos_are_entered(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
        pageHasContent("Lisää uuden kirjaviitteen tiedot");

        WebElement element = driver.findElement(By.name("title"));
        element.sendKeys(arg1);

        element = driver.findElement(By.name("author"));
        element.sendKeys(arg2);

        element = driver.findElement(By.name("publisher"));
        element.sendKeys(arg3);

        element = driver.findElement(By.name("year"));
        element.sendKeys(arg4);

        element = driver.findElement(By.name("address"));
        element.sendKeys(arg5);

        element = driver.findElement(By.name("edition"));
        element.sendKeys(arg6);

        element = driver.findElement(By.xpath("//button[contains(.,'Lisää')]"));

        element.submit();
    }

    @Then("^the reference is added and user is returned to the front page$")
    public void the_reference_is_added_and_user_is_returned_to_the_front_page() throws Throwable {
        pageHasContent("Kirjaviitteet");
    }

    
    @After
    public void tearDown(){
        driver.quit();
    }

    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
}
