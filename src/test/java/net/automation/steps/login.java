package net.automation.steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.automation.pages.workorder;
import org.yecht.Data;

import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

public class login {
    workorder work;
    @Given("^User is on workorder web$")
    public void userIsOnWorkorderWeb() throws Throwable {
       work.launch();
    }
    @When("^user enters data as following \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEntersDataAsFollowingAnd(String uname, String pass) throws Throwable {
        work.login(uname,pass);
    }
    @Then("^user must be redirected to login page$")
    public void userMustBeRedirectedToLoginPage() throws Throwable {
    work.redirected();
    }
}
