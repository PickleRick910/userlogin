package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepDefinations", // Also, ensure this is correctly pointing to your step definitions' package
    publish = true // Optionally enable publishing to Cucumber Reports
)

public class TestRunner {
    // No need to add code here, the annotations will set everything up.
}
