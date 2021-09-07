package com.mailtravel;

import com.mailtravel.utilities.Setup;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format ={"html:target/cucumber-html-report", "json:target/cucumber.json"},
        tags = {"@booking"},
        features ="src/test/resources/features",
        glue = {"com.mailtravel.utilities",
                "com.mailtravel.stepdefinitions"})

public class RunCuckesTests extends Setup {
}
