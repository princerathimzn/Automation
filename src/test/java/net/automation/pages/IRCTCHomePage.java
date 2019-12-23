package net.automation.pages;

import com.typesafe.config.Config;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigLoader;

import java.util.concurrent.TimeUnit;

import static utilities.LoadProperties.getValueFromPropertyFile;
import static utilities.LoadProperties.storeInSaveTestDataFile;

public class IRCTCHomePage extends PageObject {
    @FindBy(xpath = "")
    WebElementFacade hello;
    private static Config config=ConfigLoader.load();

    public static void setEnvironment(String environment){

     System.setProperty("env",environment);
     config=ConfigLoader.load();
 }
    public void gotoIRCTCHomePage() throws ConfigurationException {
        setEnvironment("dev");
        System.out.println(System.getProperty("env")+" :This Property");
        getDriver().get(config.getString("irctc_Home_URL"));
        storeInSaveTestDataFile("URL",config.getString("irctc_Home_URL"));
        String url = getValueFromPropertyFile("test_data", "URL");
        String username = getValueFromPropertyFile("test_data", "username");
        System.out.println(url+"URL retrieved"+username+" :User Name retrieved");
        waitABit(1000);
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(hello);
    }




}
