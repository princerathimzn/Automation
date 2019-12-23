package net.automation.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.automation.pages.dragndrop;

public class dnd {
    dragndrop drag;
    @Given("^user is on respective page$")
    public void userIsOnRespectivePage() throws Throwable {
        drag.launch();
    }
    @When("^user drag random component to dropbox box$")
    public void userDragRandomComponentToDropboxBox() throws Throwable {
        drag.dragndrop();
    }
    @Then("^component must move to dropped item list$")
    public void componentMustMoveToDroppedItemList() throws Throwable {
        drag.verify();
    }
}
