package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.tools;


public class toolsqa {

    tools tool = new tools();

    @Given("^I load the tools qa page$")
    public void loadTools() {
        tool.loadTools();
    }

    @When("^I click tutorials bar icon$")
    public void clickIcon() {
        tool.clickIcon();
    }

    @Then("^I validate the list of menus visible$")
    public void checkSearchBox() {
        tool.checkSearchBox();
    }

    @And("^I close the window$")
    public void closeWindow() {
        tool.closeWindow();
    }


}
