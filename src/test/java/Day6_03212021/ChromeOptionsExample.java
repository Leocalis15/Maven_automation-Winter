package Day6_03212021;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsExample {
    public static void main(String[] args) {

        //set the path the driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //define the chromeoptions arguments
        ChromeOptions options = new ChromeOptions();
        //maximize my driver
        //options.addArguments("start-maximize");
        //set the driver to incognito(private)
        options.addArguments("incognito");
        // set the headless
        //options.addArguments("headless");

        //define the webdriver
        WebDriver driver =  new ChromeDriver(options);

        //navigate to yahoo page
        driver.navigate().to("https://www.yahoo.com");

    }//end of method
}//end of java class
