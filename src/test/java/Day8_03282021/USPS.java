package Day8_03282021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class USPS {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver" ,"src/main/resources/chromedriver");
        // define the chromeoption argument
        ChromeOptions options = new ChromeOptions();
        // maximize my driver
        //options.addArguments(" start- maximized");
        // set the driver to incognito(private)
        options.addArguments(" incognito");
        // set it to headless
        //option.addArguments("headless");

        // define web driver
        WebDriver driver = new ChromeDriver(options);
        // hover to send wih mouse action
        Actions actions = new Actions(driver);


        //declare array list

        ArrayList<String> Zipcode = new ArrayList<>();
        ArrayList<String>Type= new ArrayList<>();
        ArrayList<String> Mile = new ArrayList<>();
        Zipcode.add("11106");
        Zipcode.add("11102");
        Zipcode.add("11106");
        //type arrsylist
        Type.add("Collection Boxes");
        Type.add("Village Post Office");
        Type.add("Self-Service Kiosks");
        // mile arratlist
        Mile.add("10 Miles");
        Mile.add("1 Mile");
        Mile.add("20 Miles");
        // declare for loop

        for (int i = 0; i< Zipcode.size();i++) {


            // navigate to usps
            try {
                driver.navigate().to("https://www.usps.com");
            } catch (Exception e) {
                System.out.println(" unable to navigate to usps" + e);
            }// end of exception

            // match the title with conditon
            String actualtitle = driver.getTitle();
            if (actualtitle.equals("Welcome")) {
                System.out.println(" title matches");

            } else {
                System.out.println(" tittle doesnt match " + "the actual title is " + actualtitle);
            }// end of conditon

            // hover to send wih mouse action and find element of send
            try {
                WebElement send = driver.findElement(By.xpath(" //*[@id = 'mail-ship-width'] "));
                // using  mouse action
                actions.moveToElement(send).perform();
            } catch (Exception e) {
                System.out.println(" unable to hover the mouse" + e);
            }// end of exception


            // click on usps location
            try {

                WebElement uspslocation = driver.findElement(By.xpath("//a[text() = 'Find USPS Locations']"));
                actions.moveToElement(uspslocation).click().perform();
            } catch (Exception e) {
                System.out.println(" unable to click on find location" + e);
            }// end of exception


            // enter the zipcode
            try {
                WebElement zip = driver.findElement(By.xpath("//*[@id = 'city-state-input']"));
                zip.click();
                zip.sendKeys(Zipcode.get(i));
            } catch (Exception e) {
                System.out.println("wrong element for zipcode" + e);
            }// end of exception

            // enter the location type
            try {
                WebElement dropdown1 = driver.findElement(By.xpath("//*[@value= 'PO']"));
                dropdown1.click();
                driver.findElement(By.xpath("//*[text() = '" + Type.get(i) + "']")).click();
                actions.moveToElement(dropdown1).click().perform();

            } catch (Exception e) {
                System.out.println("try again " + e);
            }// end of exception

            // enter the mile
            try {
                WebElement drop2 = driver.findElement(By.xpath("//*[@id = 'within-select']"));
                drop2.click();
                driver.findElement(By.xpath("//*[text() = '" + Mile.get(i) + "']")).click();
                actions.moveToElement(drop2).click().perform();
            } catch (Exception e) {
                System.out.println(" wrong elemnet " + e);
            }// end of exception
            Thread.sleep(2000);
            //click on search
            driver.findElement(By.xpath("//*[@id = 'searchLocations']")).click();
            Thread.sleep(5000);

            // array list wuth if else condition
            try {


                ArrayList<WebElement> searchlinks = new ArrayList<>(driver.findElements(By.xpath("//div[@class = 'add']")));
                if (i == 0) {
                    searchlinks.get(0).click();

                } else if (i == 1) {
                    searchlinks.get(1).click();
                }else if (i==2)   {
                    searchlinks.get(2).click();

                }// end of if else condition
            }catch (Exception e ) {
                System.out.println(" wrong elemt " + e) ;
            }// end of exception
            // capture adres
            try {

                String adress = driver.findElement(By.xpath("//div[@class= ' address-wrapper']")).getText();
                System.out.println(" the adress is " + adress);
            }catch (Exception e){
                System.out.println(" wrong input for adresss result "+ e);

            }// end of exception

            // capture hour
            try {


                String hour = driver.findElement(By.xpath("//div[@class='col-md-5 col-sm-6 col-xs-12']'")).getText();
                System.out.println(" the hour is " + hour);
            }catch (Exception e){
                System.out.println(" wrong hr input" + e);
            }// end of exception


            driver.quit();






        }// end of for loop

    } // end of main method
}// end of java class