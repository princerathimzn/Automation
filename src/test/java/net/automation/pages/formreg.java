package net.automation.pages;

import com.typesafe.config.Config;
import cucumber.api.DataTable;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.seleniumhq.jetty9.util.PathWatcher;
import utilities.ConfigLoader;

import java.util.List;
import java.util.Map;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class formreg extends PageObject {
    @FindBy(name = "firstname")
    WebElement fname;
    @FindBy(id = "lastname")
    WebElement lname;
    @FindBy(id = "datepicker")
    WebElement date;
    @FindBy(id = "photo")
    WebElement profile;
    @FindBy(id = "continents")
    WebElement continents;
    @FindBy(id = "continentsmultiple")
    WebElement mulcon;
    @FindBy(id = "selenium_commands")
    WebElement selcom;
    @FindBy(id="submit")
    WebElement submit;
    private static Config config= ConfigLoader.load();
    //launch function is for launching browser and loading the url page
    public void launch(){
        String url=config.getString("URL");
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }
    //firstname function enters first name in form after fetching data from feature file
    public void firstname(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String fn = data.get(0).get("First Name");
        fname.sendKeys(fn);
    }
    //lastname function enters last name in form after fetching data from feature file
        public void lastname (DataTable dataTable) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            String ln = data.get(0).get("Last Name");
            lname.sendKeys(ln);
        }
    //sex function enters sex information in form after fetching data from feature file
        public void sex (DataTable dataTable) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            String gender = data.get(0).get("Sex");
            WebElement sex = getDriver().findElement(By.xpath("//input[@value='"+gender+"']"));
            sex.click();
        }
    //experience function enters experience period in form after fetching data from feature file
        public void experience (DataTable dataTable) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            String exp = data.get(0).get("Experience");
            withAction().click(getDriver().findElement(By.xpath("//input[@value='"+exp+"']"))).perform();
        }
    //date function enters date in form after fetching data from feature file
        public void date (DataTable dataTable) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            String dat = data.get(0).get("Date");
            date.sendKeys(dat);
        }
    //profession function enters profession information in form after fetching data from feature file
        public void profession (DataTable dataTable) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            String prof = data.get(0).get("Profession");
            WebElement profession = getDriver().findElement(By.xpath("//input[@value='"+prof+"']"));
            profession.click();
        }
    //profile_picture function enters profile_picture in form after fetching data from feature file
        public void profile_picture(DataTable dataTable) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            String photo = data.get(0).get("Profile Picture");
            profile.sendKeys(photo);
        }
    //automation_tool function enters automation_tool information in form after fetching data from feature file
        public void automation_tool(DataTable dataTable) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            String at = data.get(0).get("Automation Tool");
            withAction().click(getDriver().findElement(By.xpath("//input[@value='"+at+"']"))).perform();
        }
    //continents function enters continent information in form after fetching data from feature file
        public void continents(DataTable dataTable) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            String cont = data.get(0).get("Continents");
            Select sc = new Select(continents);
            sc.selectByVisibleText(cont);
        }
    //continents_multiple_select function enters multiple continents information in form after fetching data from feature file
        public void continents_multiple_select(DataTable dataTable) {
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            String arg = data.get(0).get("Continents – Multiple Select");
            String a[] = arg.split(" ");
            for (int i = 0; i < a.length; i++) {
                String b = a[i];
                Select msc = new Select(mulcon);
                mulcon.sendKeys(Keys.CONTROL);
                msc.selectByVisibleText(b);
            }
        }
    //selenium_commands function enters selenium command information in form after fetching data from feature file
        public void selenium_commands(DataTable dataTable){
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            String selc=data.get(0).get("Selenium Commands");
            Select sec=new Select(selcom);
            sec.selectByVisibleText(selc);
    }
    //submit function submit the value of form by tapping on submit button
    public void submit(){
        submit.click();
        getDriver().close();
    }
}
