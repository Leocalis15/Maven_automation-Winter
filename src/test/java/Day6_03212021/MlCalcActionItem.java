package Day6_03212021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MlCalcActionItem {
    public static void main(String[] args) throws InterruptedException {


        String[] houseprice,Downpayment,Mortageterm,Interestrate,PMI,Startmonth,Startyear;
        houseprice=new String[3];
        houseprice[0]="250000";
        houseprice[1]="280000";
        houseprice[2]="400000";

        Downpayment=new String[3];
        Downpayment[0]="25";
        Downpayment[1]="30";
        Downpayment[2]="45";

        Mortageterm=new String[3];
        Mortageterm[0] ="20";
        Mortageterm[1]="25";
        Mortageterm[2]="30";

        Interestrate=new String[3];
        Interestrate[0]="2.5";
        Interestrate[1]="3.7";
        Interestrate[2]="4.8";

        PMI=new String[3];
        PMI[0]="0.5";
        PMI[1]="0.6";
        PMI[2]="0.9";

        Startmonth=new String[3];
        Startmonth[0]="Apr";
        Startmonth[1]="Jun";
        Startmonth[2]="Jul";

        Startyear=new String[3];
        Startyear[0]="2022";
        Startyear[1]="2023";
        Startyear[2]="2024";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        // Define the web driver
        WebDriver driver = new ChromeDriver();
        String actualtitile= driver.getTitle();
        if(actualtitile.equals("Mortgage Calculator")){
            System.out.println("title matches");
        }else {
            System.out.println("title does not match"  + actualtitile);
        }
        //end of condition

        for (int i=0;i< houseprice.length;i++) {

            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(2000);
// Find houseprice first
            WebElement Purchase = driver.findElement(By.xpath("//*[@name='ma']"));
            // Clear previous Purchase price Amount
            Purchase.clear();


            //Input New Purchase price Amount
            Purchase.sendKeys(houseprice[i]);


            // Find Down payment
            WebElement downpayment = driver.findElement(By.xpath("//*[@name='dp']"));
            // Clear the Down payment
            downpayment.clear();
            // Input the new Down payment
            downpayment.sendKeys(Downpayment[i]);


            WebElement mortage = driver.findElement(By.xpath("//*[@name='mt']"));
            // Clear the mortage term
            mortage.clear();
            // Input the Mortage term
            mortage.sendKeys(Mortageterm[i]);


            WebElement interestrate = driver.findElement(By.xpath("//*[@name='ir']"));
            // Clear the interest rate
            interestrate.clear();
            // Input the new interest rate
            interestrate.sendKeys(Interestrate[i]);


            WebElement pMI = driver.findElement(By.xpath("//*[@name='mi']"));
            // Clear the interest rate
            pMI.clear();
            // Input the new interest rate
            pMI.sendKeys(PMI[i]);


            // Select from drop down
            WebElement Month = driver.findElement(By.xpath("//*[@name='sm']"));
            Select dropdown = new Select(Month);
            dropdown.selectByVisibleText(Startmonth[i]);



            // Select from drop down
            WebElement Year = driver.findElement(By.xpath("//*[@name='sy']"));
            Select dropdown1 = new Select(Year);
            dropdown1.selectByVisibleText(Startyear[i]);

            // Click on Calculate button
            driver.findElement(By.xpath("//*[@type='submit']")).click();

            Thread.sleep(2000);
            String monpayment =driver.findElements(By.xpath("//td[@class='big']")).get(0).getText();


            System.out.println(" monthly pay is "+ monpayment);


        }//end of loop

    }//end of main method
}//end of java
