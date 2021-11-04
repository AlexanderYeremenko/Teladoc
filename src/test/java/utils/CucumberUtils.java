package utils;

import io.cucumber.java.Scenario;

import step_defintions.Hooks;

public class CucumberUtils {

    public static void logInfo(String msg, boolean takeScreenshot){
        Scenario scenario = Hooks.currentScenario;
        scenario.log(DatetTime.CURRENT_DATETIME + " INFO: " + msg);
        if (takeScreenshot)
            Screenshot.takeScreenshot();
    }
}
