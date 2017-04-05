import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class Stepdefs {
    List<String> inputLines = new ArrayList<>();

    @Given("^uusi viite is selected$")
    public void uusi_viite_is_selected() throws Throwable {
        inputLines.add("login");
    }

    @When("^nimi \"([^\"]*)\" and kirjoittaja \"([^\"]*)\" and publisher \"([^\"]*)\" and julkaisuvuosi (\\d+) and julkaisijan osoite \"([^\"]*)\" and painos \"([^\"]*)\" are entered$")
    public void nimi_and_kirjoittaja_and_publisher_and_julkaisuvuosi_and_julkaisijan_osoite_and_painos_are_entered(String nimi, String kirjoittaja, String publisher, int vuosi, String osoite, String painos) throws Throwable {
        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

    @Then("^the reference is added and user is returned to the front page$")
    public void the_reference_is_added_and_user_is_returned_to_the_front_page(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

}