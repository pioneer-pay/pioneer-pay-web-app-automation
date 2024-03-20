package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features/",
                  glue = "StepDefinition", plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
        "junit:target/cucumber-reports/Cucumber.xml",
<<<<<<< HEAD
        "html:target/cucumber-reports/Cucumber.html",}, tags ="@WebsiteTransactionHistory"
=======
        "html:target/cucumber-reports/Cucumber.html",}, tags ="@SendMoney"
>>>>>>> 5bb5cf3b82924f9297de0a1469e58622acadeffb


)
public class Runner {

}
