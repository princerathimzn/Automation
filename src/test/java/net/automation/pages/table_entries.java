package net.automation.pages;

import com.typesafe.config.Config;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigLoader;

import java.util.ArrayList;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class table_entries extends PageObject {
    @FindBy(name = "example_length")
    WebElement entries;
    @FindBy(id = "example_next")
    WebElement next_button;
    int count;
    List<String> list = new ArrayList<>();
    private static Config config = ConfigLoader.load();

    //launch function is for launching browser and loading the url page
    public void launch() {
        String url = config.getString("URL3");
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }

    //verify_ten_entries function confirms that only 10 entries per page are selected
    public void verify_ten_entries() {
        Select select = new Select(entries);
        String number = select.getFirstSelectedOption().getText();
        if (number.equalsIgnoreCase("10")) {
            System.out.println("10 entries per page are selected");
        } else {
            select.selectByVisibleText("10");
        }
    }

    //click_next function clicks the next button
    public void click_next() {
        for (int i = 1; i < 10; i++) {
            verify_ten_entries();
            count_entries();
            if (next_button.getAttribute("class").equals("paginate_button next")) {
                next_button.click();
            } else {
                System.out.println("\n\nYOU ARE ALREADY ON THE LAST PAGE");
                break;
            }
        }
    }

    //count_entries function counts the number of entries on the page in the table
    public void count_entries() {
            try{
            for (int i = 1; i <= 10; i++) {
                if (getDriver().findElement(By.xpath("//tr[@role='row'][" + i + "]")).isDisplayed()) {
                    list.add(getDriver().findElement(By.xpath("//tr[@role='row'][" + i + "]")).getText());
                } else {
                    System.out.println("No More Elements found");
                    break;
                }
            }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}
        //display_count function returns the count of number of entries present in the table
        public void display_count(){
        System.out.println("\n\nTHE NUMBER OF ENTRIES IN TABLE="+list.size());
        }
}
