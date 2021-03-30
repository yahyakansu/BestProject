package stepDefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.ExtentReport;

public class Hook {
    @Before
    public void setup(Scenario scenario){
        ExtentReport.startTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            ExtentReport.fail();
        }else {
            ExtentReport.pass();
        }
        Driver.closeDriver();
    }
}
