package Day7_03272021;

import Day1_030621.StringIntExample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExcenptionClass {
    public static void main(String[] args) throws InterruptedException {

        //kill all chrome instances that are opened
    //Runtime.getRuntime().exec("taskkill /F /IM chromedriver /T");
    //set the path to the driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
//define the chromeoptions arguments
        ChromeOptions options = new ChromeOptions();
//maximize my driver
        options.addArguments("start-maximized");
//set the driver to incognito(private)
        options.addArguments("incognito");
//set it to headless
//options.addArguments("headless");
//define the webdriver
        WebDriver driver = new ChromeDriver(options);

//navigate to bing home page
        try {
            driver.navigate().to("https://www.bing.com");
        } catch (Exception e) {
            System.out.println("Unable to navigate to bing. " + e);
        }//end of navigate exception

        Thread.sleep(2500);

//enter a keyword on search field
        try{
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Cars");
        } catch (Exception e) {
            System.out.println("Unable to enter keyword on Search field. " + e);
        }//end of search exception

//click on search icon
        try{
            driver.findElement(By.xpath("//*[@for='sb_form_go']")).click();
        } catch (Exception e) {
            System.out.println("Unable to click on search icon. " + e);
        }//end of search icon exception

    }//end of main method

}//end of java class
