package step_defintions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Screenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    private static WebDriver driver;
    public static Scenario currentScenario;

    @Before
    public void setUp(Scenario scenario){
        driver = Driver.getDriver();
        currentScenario = scenario;
    }

   /** @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            Screenshot.takeScreenshot();
        }
        Driver.quitDriver();
    }
   */
}
