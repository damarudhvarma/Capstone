package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/Features/ContactUs.feature",
		glue = {"StepDef"},
		monochrome = true,
		name= {"Submit Contact Us form successfully"},
		plugin = {
                "pretty",
                "html:target/ContactUS.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }

		)

public class ContactUsRunner extends AbstractTestNGCucumberTests{

}
