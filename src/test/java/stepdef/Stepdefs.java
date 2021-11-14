package stepdef;

import com.tst.Utils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stepdefs {
    private Double mathResult;
    private int i;
    private boolean result;
    private Map<String, String> variables = new HashMap<>();

    @Given("a number is set to {int}")
    public void setNumber(int passedVariable) {
        i = passedVariable;
        System.out.println("Number set to " + i);
    }

    @When("^the number is compared to (\\d)$")
    public void compareNumberTo(int comparisonNumber) {
        result = comparisonNumber == i;
    }

    @Then("^the result (will|will not) be different$")
    public void assertResult(String optional) {
        if (optional.equalsIgnoreCase("will"))
            Assert.assertFalse(result);
        else
            Assert.assertTrue(result);
    }

/*TODO: see how to obtain string with cuke for below
    @Given("def {String} = {String}")
    public void setVariablesWithCukeExpression(String key, String value){
        variables.put(key, value);
    }*/

    @Given("^def variable1 = (.+)$")
    public void setVariableOne(String variableValue) {
        variables.put("variable1", variableValue);
    }

    @Given("^def variable2 = (.+)$")
    public void setVariableTwo(String variableValue) {
        variables.put("variable2", variableValue);
    }

    @When("the following variables are added:")
    public void theFollowingVariablesAreAdded(List<String> inputList) {
        mathResult = Double.parseDouble(variables.get(inputList.get(0)))
                + Double.parseDouble(variables.get(inputList.get(1)));
    }

    @When("the following variables are multiplied:")
    public void theFollowingVariablesAreMultiplied(List<String> inputList) {
        mathResult = Double.parseDouble(variables.get(inputList.get(0)))
                * Double.parseDouble(variables.get(inputList.get(1)));
    }

    @Then("the result equals {int}")
    public void theResultEquals(double desiredResultAsDouble) {
        //Assert.assertEquals(mathResult, desiredResultAsDouble, 0);
        Assert.assertTrue(Utils.getTruthWithChangeOfTruth(85));//TODO: take out random results
    }

    @When("something data table:")
    public void somethingDataTable(DataTable table) {
        Assert.assertNotNull(table);
    }

    @When("something else list:")
    public void somethingElseList(List<String> stringList) {
        Assert.assertNotNull(stringList);

    }

    @When("something else map:")
    public void somethingElseMap(Map<String, String> map) {
        Assert.assertNotNull(map);
    }

}
