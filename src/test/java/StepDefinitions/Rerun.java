package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="@target/failedrerun.txt",

		glue= {"StepDefinitions"},
		monochrome=true,
		plugin= {"pretty","html:target/HtmlReports",
				"json:target/JSONReports/report.json",
				"junit:target/JunitReports/report.xml",
				 "message:target/TextReports/cucumber.txt",
				 "rerun:target/failedrerun.txt"
     
}
       
       


		)


public class Rerun {
	
	

}
