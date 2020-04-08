package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/E2E.feature",
        glue = "Steps",tags="@e2e",
        plugin =    {"pretty","html:target/cucumber"}
)
public class TestRunner {
}
