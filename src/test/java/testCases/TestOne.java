package testCases;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "src/test/java/features",
		glue = "stepDefinations"
		)
public class TestOne extends AbstractTestNGCucumberTests{
	
}
