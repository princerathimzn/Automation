package net.automation.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.automation.pages.table_entries;

public class table {
    table_entries table;

    @Given("^User is on table page$")
    public void userIsOnTablePage() throws Throwable {
        table.launch();
    }

    @When("^user calculates entries from the table$")
    public void userCalculatesEntriesFromTheTable() throws Throwable {
        table.click_next();
    }

    @Then("^number of entries comes equals to the total number of entries displayed at the bottom of the table$")
    public void numberOfEntriesComesEqualsToTheTotalNumberOfEntriesDisplayedAtTheBottomOfTheTable() throws Throwable {
        table.display_count();
    }
}
