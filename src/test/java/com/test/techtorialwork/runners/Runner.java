package com.test.techtorialwork.runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//it means run cucumber classes
@CucumberOptions(//It is an annotation that has some special keywords
        features = "/Users/alinaperestoronina/IdeaProjects/CucumberB18/src/test/resources/features ",//This is the location of feature files but we provide folder
        glue = "com/test/techtorialwork/stepdefinitions",//This is the location of step definitions classes, but we provide folder(stepdefinitions)
        dryRun= false,//It is a way to get snips without executing the steps
        tags = "@regression",//it is a way to filter your test cases based on your request(Smoke,Regression)
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt",
        "json:target/cucumber-reports/cucumber.json"}


)

public class Runner {


}