package integration;

import org.junit.rules.ExternalResource;
/**
 *
 * @author matleino
 */
public class ServerRule extends ExternalResource {

    public ServerRule() {
    }
    
    @Override
    protected void before() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "chromedriverkansio/chromedriver");
    }
    
    protected void after() {
        
    }
}
