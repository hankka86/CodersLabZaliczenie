package pageobjectpattern;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/",
        plugin = {"pretty","html:out"})

public class RunGherkinTest {
}

