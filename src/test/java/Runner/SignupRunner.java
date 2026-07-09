package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/Features/signup.feature",
		glue = {"StepDef","hooks"},
		monochrome = true,
		name= {
				"User signs up successfully",
				"Registration with mandatory fields empty"
			  },
		
		plugin = {
                "pretty",
                "html:target/signup.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }

		)

public class SignupRunner extends AbstractTestNGCucumberTests{

}
