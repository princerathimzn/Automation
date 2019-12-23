package net.automation.pages;

import com.typesafe.config.Config;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigLoader;

public class dragndrop extends PageObject {
    @FindBy(id = "mydropzone")
    WebElement drop;
    private static Config config= ConfigLoader.load();
    //launch function is for launching browser and loading the url page
    public void launch(){
        String url=config.getString("URL2");
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }
    //dragndrop function selects and components and drops it to drop box
    public void dragndrop(){
        for(int i=1;i<=4;i++){
            waitABit(2000);
            withAction().dragAndDrop(getDriver().findElement(By.xpath("//span[text()='Draggable "+i+"']")),drop).perform();

        }
    }
    //verify function verifies whether components are dropped to drop list or not
    public void verify(){
        for(int i=1;i<=4;i++){
            String id=getDriver().findElement(By.xpath("//span[text()='Draggable "+i+"']")).getAttribute("id");
            if(id=="droppedlist"){
                System.out.println("Dropped Element"+i+" successfully");
            }
            else{
                System.out.println("Dropping of Element "+i+" failed");
            }
        }
    }
}
