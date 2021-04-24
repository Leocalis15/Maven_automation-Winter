package Day5_03202021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchResult {

    public static void main(String[] args) throws InterruptedException {

        //set the property of the chromedriver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        //define the webdriver
        WebDriver driver = new ChromeDriver();

        //navigate to google home
        driver.navigate().to("https://www.google.com");

        //maximize the driver
        driver.manage().window().maximize();

        //sleep statement when you go to specific url page
        Thread.sleep(3000);

        //enter a keyword on google search field
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        Thread.sleep(1000);

        //hit submit on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //new page appears so put additional wait
        Thread.sleep(3000);

        //capture the search result but only print out the search number
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //split and extract out the search number
        String[] arrayResults = searchResult.split(" ");
        //print the search number
        System.out.println("My search number is " + arrayResults[1]);
    }// end of main method

}// end of java class
