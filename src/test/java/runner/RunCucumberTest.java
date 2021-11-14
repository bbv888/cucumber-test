package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"stepdef", "hooks"},
        features = {"src/test/resources/demo.feature"},
        plugin = {"pretty",
                "html:target/cucumber",
                "json:target/cucumber.json"}
        , tags = "not @norun"
)
public class RunCucumberTest {

    @AfterClass
    public static void syncWithElastic() {
        try {
            ElasticSync.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
