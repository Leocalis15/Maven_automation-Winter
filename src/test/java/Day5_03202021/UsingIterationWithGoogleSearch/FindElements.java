package Day5_03202021.UsingIterationWithGoogleSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {
    public static void main(String[] args) throws InterruptedException {

        //set the property of thr chromedriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        //define the WebDriver
        WebDriver driver = new ChromeDriver();

        //navigate to google home
        driver.navigate().to("https://www.google.com");

        //maximize
        driver.manage().window().maximize();

        Thread.sleep(3000);

        //using findElement click on store link from the class group
        driver.findElements(By.xpath("//*[@class='MV3Tnb']")).get(1).click();



    }//end of method


}//end of java class
