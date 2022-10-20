package com.nextbasecrm.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                //"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber/report.html",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"

        },
        features = "src/test/resources/features",
        glue = "com/nextbasecrm/step_definitions",
        dryRun = false,  // browser will open when false
        tags = "@regression and @comment",
        publish = true
)
public class CukesRunner {
}
