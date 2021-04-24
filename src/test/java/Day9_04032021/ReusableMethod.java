package Day9_04032021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ReusableMethod {

    public static void main(String[] args) {

    }

    //create a reusable method for navigate to a page
    public static WebDriver defineTheDriver() throws InterruptedException, IOException {
        //kill all chrome instances that are opened
        //Runtime.getRuntime().exec("taskkill /F /IM chromedriver/T");
        Thread.sleep(1000);
        //set the path to the driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
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

        return driver;
    }//end of navigate method

    public static WebDriver defineTheDriverByHeadless() throws InterruptedException, IOException {
        //kill all chrome instances that are opened
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        Thread.sleep(1000);
        //set the path to the driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //define the chromeoptions arguments
        ChromeOptions options = new ChromeOptions();
        //maximize my driver
        options.addArguments("start-maximized");
        //set the driver to incognito(private)
        options.addArguments("incognito");
        //set it to headless
        options.addArguments("headless");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }//end of navigate method with headless


    //method to click on any webelement by explicit wait
    public static void clickOnElement(WebDriver driver, String xpath, String elementName) {
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //use try catch to locate an element and click on it
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of click method

    //method to type on any webelement by explicit wait
    public static void sendKeysMethod(WebDriver driver, String xpathLocator, String userValue, String elementName) {
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //use try catch to locate an element and click on it
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to enter value on element " + elementName + " " + e);
        }

    }//end of sendkeys method

        public static void dropdownByText(WebDriver driver,String xpath,String userValue,String elementName){
            WebDriverWait wait = new WebDriverWait(driver,10);
            try{
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                Select dropDown = new Select(element);
                dropDown.selectByVisibleText(userValue);
            } catch (Exception e) {
                System.out.println("Unable to select a value from " + elementName + " " + e);
            }
        }//end of dropdown by text

        public static String captureText(WebDriver driver,String xpathLocator,int index,String elementName){
            WebDriverWait wait = new WebDriverWait(driver,10);
            String result = "";
            try{
                WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpathLocator))).get(index);
                result = element.getText();
            } catch (Exception e) {
                System.out.println("Unable to select a value from " + elementName + " " + e);
            }
            return result;

        }//end of dropdown by text

    public static void MouseHover (WebDriver driver,String xpath,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {


            Actions actions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("unable to click hover mouse" + e);
        }//end of exeption
    }//end of mousehover

        //method to submit on any webelement by explicit wait
        public static void submitOnElement(WebDriver driver,String xpathLocator, String elementName){
            //define by explicit wait
            WebDriverWait wait = new WebDriverWait(driver,10);
            //use try catch to locate an element and click on it
            try{
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).submit();
            } catch (Exception e) {
                System.out.println("Unable to submit on element " + elementName + " " + e);
            }
        }//end of submit method

    //method to click on any webelement by explicit wait
    public static void closePopupIfExist(WebDriver driver,String xpathLocator, String elementName){
        //define by explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        //use try catch to locate an element and click on it
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator))).click();
        } catch (Exception e) {
            System.out.println("Popup " + elementName + " is not present. Move on to the next step");
        }
    }//end of closePopupIfExist


}//end of java class
