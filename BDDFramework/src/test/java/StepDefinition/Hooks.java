package StepDefinition;

import CommonUtility.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks extends BaseClass {

    WebDriver driver;
    static Scenario scenario;


    @Before
    public void beforeScenario(Scenario scenario) throws Exception {
        if(scenario.getSourceTagNames().contains("@WebsiteRegistration")){
            if (driver == null){
                Hooks.scenario = scenario;
                setUp();
                navigateToUrl();
            }
        } else if (scenario.getSourceTagNames().contains("@WebsiteLogin")) {
            if (driver == null){
                Hooks.scenario =scenario;
                setUp();
                navigateToUrl();
            }
        }
        else if (scenario.getSourceTagNames().contains("@SendMoney") || scenario.getSourceTagNames().contains("@Regression")) {
            if (driver == null){
                Hooks.scenario =scenario;
                setUp();
                navigateToUrl();
            }
        }
    }

    public static Scenario getScenario(){
        return scenario;
    }

}
