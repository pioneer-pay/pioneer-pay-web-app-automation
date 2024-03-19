package StepDefinition;

import CommonUtility.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks extends BaseClass {

    //WebDriver driver;
    static Scenario scenario;


    @Before
    public void beforeScenario(Scenario scenario) throws Exception {
            Hooks.scenario = scenario;
            setUp();
            navigateToUrl();
    }

    public static Scenario getScenario(){
        return scenario;
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
