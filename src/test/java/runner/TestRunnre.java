package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = "src/test/java/features", glue = { "steps" }, 
plugin ={ "pretty","html:target/cucumber-html-report" },publish = true)

public class TestRunnre extends TestBase {

}
