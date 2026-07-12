package Runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
 
@CucumberOptions(
		features = "src/test/java/Features/FeaturedProduct.feature",
		glue = {"StepDef"},
		monochrome = true,
		name= {"User purchases a featured product successfully"},
		plugin = {
                "pretty",
                "html:target/featuredprod.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
 
		)
 
public class Featuredprodrunner extends AbstractTestNGCucumberTests{
 
}