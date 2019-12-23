package net.automation.pages;

import com.typesafe.config.Config;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.ConfigLoader;

import java.util.concurrent.TimeUnit;

public class workorder extends PageObject {
   @FindBy(name = "userName")
    WebElement username;
   @FindBy(name = "password")
   WebElement password;
   @FindBy(xpath = "//button[@type='submit']")
   WebElement submit;
   @FindBy(xpath = "//div[text()=' Invalid credential. ']")
   WebElement msg;
    private static Config config= ConfigLoader.load();
    //launch function is for launching browser and loading the url page
     public void launch(){
        String url=config.getString("URL1");
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }
    //login function enters login details on workorder login page and hit submit button
    public void login(String uname,String pass){
        username.sendKeys(uname);
        password.sendKeys(pass);
        submit.submit();
        try {
            waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=' Invalid credential. ']")));
            unsuccess();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    //unsuccess function matches the value displayed when login is unsuccessful
    public void unsuccess(){
        if(msg.getText().equalsIgnoreCase(" Invalid credential. ")){
            System.out.println("login was unsuccessful");
        }
        else{
            System.out.println("Login was successful");
        }
    }
    //redirected function redirects the browser to wokrorder's login page
    public void redirected(){
        String url=config.getString("URL1");
        getDriver().get(url);
    }
}
