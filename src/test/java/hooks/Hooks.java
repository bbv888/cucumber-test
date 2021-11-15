package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

import java.time.LocalDateTime;

public class Hooks {

    @AfterStep
    public void afterStepHooks(Scenario scenario) {
        //scenario.write("string entered after step");
        try {
            Thread.sleep((long) (Math.random() * 130));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After //TODO:will need to inject console contents into cuke Scenario
    public void afterScenarioHooks(Scenario scenario) {
        String dataToWrite = "string entered after scenario: " + scenario.getName()
                + " at date: " + LocalDateTime.now();
        scenario.log(dataToWrite);
    }
}
