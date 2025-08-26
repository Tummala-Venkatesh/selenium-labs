package com.orangehrm.stepdefinitations;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\java\\aug\\src\\test\\resources\\Features"
,glue= {"com.orangehrm.stepdefinitations"}
,dryRun=false
,monochrome=true)

public class TestRunner {

}
