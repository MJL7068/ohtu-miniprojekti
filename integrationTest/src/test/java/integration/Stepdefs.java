package integration;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Stepdefs {

    WebDriver driver = new ChromeDriver();
    String baseUrl = "http://localhost:8080/";

    @Given("^uusi viite is selected$")
    public void uusi_viite_is_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("Uusi viite"));
        element.click();
    }

    @Given("^user is in the main page and there is a reference with the title \"([^\"]*)\" in the database$")
    public void user_is_in_the_main_page_and_there_is_a_reference_with_the_title_testireferenssi(String title) throws Throwable {
        driver.get(baseUrl);
        pageHasContent("Lähdeviitteet");

        teeTestiReferenssi(title);
    }

    @When("^button with the text \"([^\"]*)\" next to the reference with the title \"([^\"]*)\" is pressed$")
    public void button_poista_next_to_the_testireferenssi_is_pressed(String text, String title) throws Throwable {
        WebElement element = driver.findElement(By.id(title));
        element.click();
    }

    @When("^\"([^\"]*)\" is selected and title \"([^\"]*)\" and author \"([^\"]*)\" and publisher \"([^\"]*)\" and year \"([^\"]*)\" and address \"([^\"]*)\" and edition \"([^\"]*)\" are entered$")
    public void book_is_selected_and_nimi_and_kirjoittaja_and_publisher_and_julkaisuvuosi_and_julkaisijan_osoite_and_painos_are_entered(String entrytype, String title, String author, String publisher, String year, String address, String edition) throws Throwable {
        pageHasContent("Lisää uuden lähdeviitteen tiedot");

        Select dropdown = new Select(driver.findElement(By.name("entrytype")));
        dropdown.selectByVisibleText(entrytype);

        WebElement element = driver.findElement(By.name("entrykey"));
        element.sendKeys("1");

        element = driver.findElement(By.name("author"));
        element.sendKeys(author);

        element = driver.findElement(By.name("title"));
        element.sendKeys(title);

        element = driver.findElement(By.name("publisher"));
        element.sendKeys(publisher);

        element = driver.findElement(By.name("year"));
        element.sendKeys(year);

        element = driver.findElement(By.name("address"));
        element.sendKeys(address);

        element = driver.findElement(By.name("edition"));
        element.sendKeys(edition);

        element = driver.findElement(By.xpath("//button[contains(.,'Lisää')]"));

        element.click();
    }

    @When("^\"([^\"]*)\" is selected and title \"([^\"]*)\" and author \"([^\"]*)\" and journal \"([^\"]*)\" and year \"([^\"]*)\" and volume \"([^\"]*)\" and number \"([^\"]*)\" are entered$")
    public void article_is_selected_and_title_and_author_and_journal_and_year_and_volume_and_number_are_entered(String entrytype, String title, String author, String journal, String year, String volume, String number) throws Throwable {
        pageHasContent("Lisää uuden lähdeviitteen tiedot");

        Select dropdown = new Select(driver.findElement(By.name("entrytype")));
        dropdown.selectByVisibleText(entrytype);

        WebElement element = driver.findElement(By.name("entrykey"));
        element.sendKeys("1");

        element = driver.findElement(By.name("author"));
        element.sendKeys(author);

        element = driver.findElement(By.name("title"));
        element.sendKeys(title);

        element = driver.findElement(By.name("journal"));
        element.sendKeys(journal);

        element = driver.findElement(By.name("year"));
        element.sendKeys(year);

        element = driver.findElement(By.name("volume"));
        element.sendKeys(volume);

        element = driver.findElement(By.name("number"));
        element.sendKeys(number);

        element = driver.findElement(By.xpath("//button[contains(.,'Lisää')]"));

        element.click();
    }

    @When("^\"([^\"]*)\" is selected and title \"([^\"]*)\" and author \"([^\"]*)\" and booktitle \"([^\"]*)\" and year \"([^\"]*)\" and pages \"([^\"]*)\" and publisher \"([^\"]*)\" are entered$")
    public void inproceedings_is_selected_and_title_and_author_and_booktitle_and_year_and_pages_and_publisher_are_entered(String entrytype, String title, String author, String booktitle, String year, String pages, String publisher) throws Throwable {
        pageHasContent("Lisää uuden lähdeviitteen tiedot");

        Select dropdown = new Select(driver.findElement(By.name("entrytype")));
        dropdown.selectByVisibleText(entrytype);

        WebElement element = driver.findElement(By.name("entrykey"));
        element.sendKeys("GvG00");

        element = driver.findElement(By.name("author"));
        element.sendKeys(author);

        element = driver.findElement(By.name("title"));
        element.sendKeys(title);

        element = driver.findElement(By.name("booktitle"));
        element.sendKeys(booktitle);

        element = driver.findElement(By.name("year"));
        element.sendKeys(year);

        element = driver.findElement(By.name("pages"));
        element.sendKeys(pages);

        element = driver.findElement(By.name("publisher"));
        element.sendKeys(publisher);

        element = driver.findElement(By.xpath("//button[contains(.,'Lisää')]"));

        element.click();
    }

    @And("^value \"([^\"]*)\" is entered to a field with name \"([^\"]*)\"$")
    public void valueIsEnteredToAFieldWithName(String val, String fieldName) throws Throwable {
        WebElement field = driver.findElement(By.cssSelector("input[name=" + fieldName + "]"));
        field.clear();
        field.sendKeys(val);
    }

    @And("^edit is confirmed$")
    public void editIsConfirmed() throws Throwable {
        driver.findElement(By.cssSelector("input[value=Muokkaa]")).click();
    }

    @And("^edit button for reference titled \"([^\"]*)\" is clicked$")
    public void editButtonForReferenceTitledIsClicked(String title) throws Throwable {
        List<WebElement> refs = driver.findElements(By.cssSelector(".allReferences li"));
        refs.stream()
                .filter(r -> r.getText().contains("title: " + title))
                .findFirst()
                .get()
                .findElement(By.cssSelector("input[value=Muokkaa]"))
                .click();
    }

    @Then("^the reference is added and user is returned to the front page$")
    public void the_reference_is_added_and_user_is_returned_to_the_front_page() throws Throwable {
        pageHasContent("Lähdeviitteet");
    }

    @Then("^the reference with the title \"([^\"]*)\" is removed$")
    public void the_reference_with_the_title_is_removed(String title) throws Throwable {
        assertTrue(!driver.getPageSource().contains(title));
    }

    @Then("^the reference is not added and user stays on new reference page$")
    public void theReferenceIsNotAddedAndUserStaysOnNewReferencePage() throws Throwable {
        pageHasContent("Lisää uuden lähdeviitteen tiedot");
    }

    @Then("^page has reference titled \"([^\"]*)\"$")
    public void pageHasReferenceTitled(String title) throws Throwable {
        pageHasContent("title: " + title);
    }

    @After
    public void tearDown() {
        driver.navigate().to(baseUrl);
        By selector = By.cssSelector("input[value=Poista]");
        while (driver.findElements(selector).size() > 0) {
            driver.findElement(selector).click();
        }
        driver.quit();
    }

    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private static void sleep(int n) throws Throwable {
        Thread.sleep(n * 1000);
    }

    private void teeTestiReferenssi(String title) throws Throwable {
        WebElement element = driver.findElement(By.linkText("Uusi viite"));
        element.click();

        book_is_selected_and_nimi_and_kirjoittaja_and_publisher_and_julkaisuvuosi_and_julkaisijan_osoite_and_painos_are_entered("book", title, "kirjoittaja", "julkaisija", "1999", "osoite", "22");

        pageHasContent("Lähdeviitteet");
    }
}
