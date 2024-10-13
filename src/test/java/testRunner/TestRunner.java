package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src//test//resources//Feature"
,glue="stepDefinition"
,tags="@FlightRoundTrip"
,monochrome=true
,plugin= {"pretty","html:target//htmlreport//report.html"})
public class TestRunner {

}
