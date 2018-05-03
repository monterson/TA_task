package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "junit:target/cucumber.xml"},
        features = "src/test/resources/features",
        glue = {"stepDefinitions.core", "stepDefinitions.pageSteps"},
        tags = {"@SmokeTests"})
public class TrelloCucumberTest {
}
