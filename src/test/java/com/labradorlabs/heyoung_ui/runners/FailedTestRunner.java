package com.labradorlabs.heyoung_ui.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/labradorlabs/heyoung_ui/steps_definitions",
        features = "@target/rerun.txt"
)

public class FailedTestRunner {
}
