package Day5_03202021.UsingIterationWithGoogleSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Java {
    public static void main(String[] args) throws InterruptedException {

        /** iterate through multiple cities on google search and print out the number each time **/

//declare and define the array list
        String[] cities = new String[3];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Bronx";


//set the driver path
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

//define the WebDriver
        WebDriver driver = new ChromeDriver();

//your actual use case from start to end should go inside for/while loop for multiple iterations
        for(int i = 0; i < cities.length; i++){
            //navigate to google home
            driver.navigate().to("https://www.google.com");

            //maximize the driver
            driver.manage().window().maximize();

            //sleep statement when you go to a specific url page
            Thread.sleep(3000);

            //enter a keyword on google search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities[i]);

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
            System.out.println("The city " + cities[i] + " search number is " + arrayResults[1]);

        }//end of for loop

//quit the driver
        driver.quit();

    }//end of main method


}//end of java class
