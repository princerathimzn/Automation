package net.automation.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.automation.pages.IRCTCHomePage;

public class IRCTC_Steps {
    IRCTCHomePage irctcHomePage;
    @And("^I enter source as \"([^\"]*)\" and destianation as \"([^\"]*)\"$")
    public void iEnterSourceAsAndDestianationAs(String arg0, String arg1) throws Throwable {
       
    }

    @Given("^I am on irctc home page$")
    public void iAmOnIrctcHomePage() throws Throwable {
       irctcHomePage.gotoIRCTCHomePage();
    }


}
