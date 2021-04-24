package Day8_03282021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.lang.reflect.Type;
import java.net.Proxy;
import java.util.ArrayList;

public class ActionItem_28032021 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //define the chromeoptions arguments
        ChromeOptions options = new ChromeOptions();
        //maximize my driver
        //options.addArguments("start-maximized");
        //set the driver to incognito(private)
        options.addArguments("incognito");
        //set it to headless
        //options.addArguments("headless");

        //define the webdriver
        WebDriver driver = new ChromeDriver(options);
        //hover to send with mouse action
        Actions actions = new Actions(driver);

        //declare and define the array list
        ArrayList<String> ZipCode = new ArrayList<>();
        ZipCode.add("11106");
        ZipCode.add("11103");
        ZipCode.add("11101");

        ArrayList<String> Type = new ArrayList<>();
        Type.add("Collection Boxes");
        Type.add("Village Post Office");
        Type.add("Self-Service Kiosks");

        ArrayList<String> Mile = new ArrayList<>();
        Mile.add("10 Miles");
        Mile.add("20 Mile");
        Mile.add("25 Miles");

        for (int i = 0; i < ZipCode.size(); i++) {

            //navigate to usps home page
            try {
                driver.navigate().to("https://www.usps.com");
            } catch (Exception e) {
                System.out.println(" Unable to navigate to usps" + e);
            }//end of navigate exception

            Thread.sleep(3000);

            // match the title with condition
            String actualtitle = driver.getTitle();
            if (actualtitle.equals("Welcome")) {
                System.out.println(" title matches");

            } else {
                System.out.println(" tittle doesn't match " + "the actual title is " + actualtitle);
            }// end of condition


            //hover to send wih mouse action and find element of send
            try {
                WebElement send = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
                //using mouse action
                actions.moveToElement(send).perform();
            } catch (Exception e) {
                System.out.println(" Unable to hover the mouse" + e);
            }//end of exception

            //click on USPS Location
            try {
                WebElement uspslocation = driver.findElement(By.xpath("//a[text()='Find USPS Locations']"));
                actions.moveToElement(uspslocation).click().perform();
            } catch (Exception e) {
                System.out.println(" Unable to click on Find Locations" + e);
            }//end of exception


            Thread.sleep(3000);


            //Entering ZipCode
            try {
                WebElement Zip = driver.findElement(By.xpath("//*[@id='city-state-input']"));
                Zip.click();
                Zip.sendKeys(ZipCode.get(i));
            } catch (Exception e) {
                System.out.println("wrong element for ZipCode" + e);
            }//end exception

            //click on type locations
            try {
                WebElement dropdowm1 = driver.findElement(By.xpath("//*[@value='PO']"));
                dropdowm1.click();
                driver.findElement(By.xpath("//*[text() = '" + Type.get(i) + "']")).click();
                actions.moveToElement(dropdowm1).click().perform();

            } catch (Exception e) {
                System.out.println("try again " + e);
            }//end of exception

            //Enter the Miles
            try {
                WebElement drop2 = driver.findElement(By.xpath("//*[@id='within-select']"));
                drop2.click();
                driver.findElement(By.xpath("//*[text()='" + Mile.get(i) + "']")).click();
                actions.moveToElement(drop2).click().perform();
            } catch (Exception e) {
                //end of exception
                System.out.println(" wrong element " + e);
                Thread.sleep(2000);
                //click on search
                driver.findElement(By.xpath("//*[@id='searchLocations']")).click();
                Thread.sleep(3000);
            }//end fo exception

                // array list with if else condition
                try {


                    ArrayList<WebElement> searchlinks = new ArrayList<>(driver.findElements(By.xpath("//div[@class='add']")));
                    if (i == 0) {
                        searchlinks.get(0).click();
                    } else if (i == 1) {
                        searchlinks.get(1).click();
                    } else if (i == 2) {
                        searchlinks.get(2).click();
                    }// end of if else condition
                } catch (Exception e) {
                    System.out.println(" wrong element " + e);
                }// end of exception
                // capture address
                try {

                    String address = driver.findElement(By.xpath("//div[@class='address-wrapper']")).getText();
                    System.out.println(" the address is " + address);
                } catch (Exception e){
                    System.out.println(" wrong input for address result " + e);

                }// end of exception

                // capture hour
                try {

                    String hour = driver.findElement(By.xpath("//div[@class='col-md-5 col-sm-6 col-xs-12']")).getText();
                    System.out.println(" the hour is " + hour);
                } catch (Exception e) {
                    System.out.println(" wrong hour input" + e);
                }//end of  exception



                }//end of for loop

        driver.quit();

            }//end of main method
         }//end of java class

