package integration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
/**
 *
 * @author matleino
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})
public class RunCukesTest {
    @ClassRule
    public static ServerRule server = new ServerRule();
}
