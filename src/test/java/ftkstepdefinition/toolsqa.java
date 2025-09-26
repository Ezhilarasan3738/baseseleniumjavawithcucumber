package ftkstepdefinition;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.tools;

import java.util.List;


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

    @When("I enter {string} in the searchbar")
    public void iEnterKeywordsInTheSearchbar(String keyword) {
        tool.enterValuesInSearchBox(keyword);
    }

    @When("I enter each keywords in the searchbar")
    public void iEnterEachKeywordsInTheSearchbar(List<List<String>> keywords) throws Throwable {
        tool.enterEachValuesInSearchBox(keywords);
    }

    @When("I enter each keywords using maps in the searchbar")
    public void iEnterEachKeywordsUsingMapsInTheSearchbar(DataTable keywords) {
        tool.enterEachValuesUsingMapsInSearchBox(keywords);
    }
}
