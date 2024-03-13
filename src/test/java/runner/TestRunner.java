package runner;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features"},
        glue={"classpath:stepDefinitions"},
        monochrome = true,
        dryRun = false,
        plugin = { "pretty", "html:target/cucumber-reports" })
public class TestRunner extends AbstractTestNGCucumberTests {
}

