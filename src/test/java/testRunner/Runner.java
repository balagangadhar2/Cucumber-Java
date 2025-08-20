package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = ".//Features//Customer.feature",      // Path to your .feature files
    glue = {"stepDefinitions"},                    // Package name for step definitions
    plugin = { "pretty", "html:target/cucumber-reports.html" },
    monochrome = true,
    tags= "@sanity",
    	// tags= "@sanity or @reg",

    dryRun = false
)
public class Runner {

}
