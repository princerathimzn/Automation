package net.automation.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.automation.pages.Google;

public class StepsDummy {
    Google google;
    @And("^I select class \"([^\"]*)\"$")
    public void iSelectClass(String arg0) throws Throwable {

    }

    @Given("^I am on google$")
    public void iAmOnGoogle() throws Throwable {
       google.goToHomePage();
    }


}
