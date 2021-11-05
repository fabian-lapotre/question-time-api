package com.jlmedtech.questiontimeapi.acceptance;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(snippets = CAMELCASE, features = "src/test/resources/features",plugin = {"pretty","html:target/html-cucumber-report"})
public class RunCucumberIT {
}