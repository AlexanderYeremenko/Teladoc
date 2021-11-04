package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_definitions",
        plugin = {
                "pretty",
                "html:target/cucumber-report/cucumber-pretty",
                "json:target/cucumber-report/CucumberTestReport.json"
        },
        tags = "@AlexTest",
        dryRun = false
)
public class cukesRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = false)
    public Object[][] scenarios() {

        return super.scenarios();
    }
}
