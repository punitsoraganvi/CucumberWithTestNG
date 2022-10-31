package com.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		//usage and pretty
		plugin = { "pretty", "html:target/cucumber-reports/rpusage.html","json:target/cucumber-reports/rpusage2.json",
				"junit:target/cucumber-reports/rpusage3.xml", },
		monochrome = true,
		tags="",
		features = {"src/test/resources/features/Cart.feature" },
		glue = "com.stepdefination")

public class AmazonRunnerTest extends AbstractTestNGCucumberTests {

}
