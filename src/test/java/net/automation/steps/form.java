package net.automation.steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.automation.pages.formreg;

import java.util.List;
import java.util.Map;

public class form {
    formreg form;
    @Given("^User is on form page$")
    public void userIsOnFormPage() throws Throwable {
       form.launch();
    }

    @When("^User enters details as following$")
    public void userEntersDetailsAsFollowing(DataTable dataTable) throws Throwable {
        form.firstname(dataTable);
        form.lastname(dataTable);
        form.sex(dataTable);
        form.experience(dataTable);
        form.date(dataTable);
        form.profession(dataTable);
        form.profile_picture(dataTable);
        form.automation_tool(dataTable);
        form.continents(dataTable);
        form.continents_multiple_select(dataTable);
        form.selenium_commands(dataTable);
    }


    @Then("^The form is submitted$")
    public void theFormIsSubmitted() throws Throwable {
        form.submit();
    }
}
