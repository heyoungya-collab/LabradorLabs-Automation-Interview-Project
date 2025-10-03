package com.labradorlabs.heyoung_ui.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports/report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/labradorlabs/heyoung_ui/steps_definitions",
        dryRun = false,
        tags = "",
        publish = true
)


public class CukesRunner {
}
