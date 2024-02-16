package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static uitilities.DriverSetup.openABrowser;
import static uitilities.DriverSetup.quiteBrowser;

public class Hooks {

    public static String browserName = System.getProperty("browser", "Chrome");

    @Before
    public void startBrowser(){
        openABrowser(browserName);
    }

    @After
    public void closeBrowser(Scenario scenario){
        quiteBrowser(scenario);
    }
}
