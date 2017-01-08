package com.rob.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
            format={"pretty",
                    "html:target/test-report",
                    "json:target/test-report.json",
                    "junit:target/test-report.xml"},
            glue = "com.rob.bdd",
            features = {"src/test/resources/test1.feature"}
        )
public class TestRunner {

}
