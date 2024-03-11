package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/sddToCart.feature",
                    glue = {"org.lightandwonder.stepDefinitions"},
                    monochrome = true,
                    dryRun = false,
                    plugin = { "pretty", "html:target/cucumber-reports" })
public class TestRunner {
}
