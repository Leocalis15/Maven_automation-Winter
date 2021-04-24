package Day9_04032021;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = ReusableMethod.defineTheDriver();

//navigate to google
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2300);
//enter something on search field
        ReusableMethod.sendKeysMethod(driver,"//*[@name='q']","Cars","Search Field");
//click on google search
        ReusableMethod.clickOnElement(driver,"//*[@name='btnK']","Google Search");

    }//end of main method
}//end oj java class
