package Day12_041120021;

import Day9_04032021.ReusableMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;

public class gettingLinkCount {
@Test
    public void linkCount() throws IOException, InterruptedException {
    WebDriver driver = ReusableMethod.defineTheDriver();

    driver.navigate().to("https://www.yahoo.com");
    Thread.sleep(2000);

    //store the arraylist with class attribute for the links
    ArrayList <WebElement> linkCount = new ArrayList(driver.findElements(By.xpath("//*[contains(@class,'_yb_12gb1')]")));
//print out the count of the links
    System.out.println("Link count is " + linkCount.size());

//I want to click on each link and navigate back to the home page
    for(int i = 0; i < linkCount.size();i++){
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(3500);
        linkCount  = new ArrayList(driver.findElements(By.xpath("//*[contains(@class,'_yb_12gb1')]")));
        linkCount.get(i).click();
        Thread.sleep(2000);
    }


    }//end of test
}//end of java class
