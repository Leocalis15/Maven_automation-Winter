package Day6_03212021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Mlcalcassigment {
    public static void main(String[] args) throws InterruptedException {

        String[] Houseprice, Downpayment, MortgageTerm, InterestRate, PMI, StartMonth, StartYear;

        Houseprice = new String[3];
        Houseprice[0] = "345000";
        Houseprice[1] = "655000";
        Houseprice[2] = "850000";

        Downpayment = new String[3];
        Downpayment[0] = "22";
        Downpayment[1] = "35";
        Downpayment[2] = "52";

        MortgageTerm = new String[3];
        MortgageTerm[0] = "15";
        MortgageTerm[1] = "25";
        MortgageTerm[2] = "30";

        InterestRate = new String[3];
        InterestRate[0] = "2.7";
        InterestRate[1] = "4.5";
        InterestRate[2] = "6";

        PMI = new String[3];
        PMI[0] = "1.3";
        PMI[1] = "2.4";
        PMI[2] = "3.5";

        StartMonth = new String[3];
        StartMonth[0] = "Apr";
        StartMonth[1] = "Jun";
        StartMonth[2] = "Aug";

        StartYear = new String[3];
        StartYear[0] = "2022";
        StartYear[1] = "2023";
        StartYear[2] = "2024";


        //set the chrome path
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



        //set up for the loop
        for (int i = 0;i < Houseprice.length; i++){

            //navigate to mlcalc.com
        driver.navigate().to("https://www.mlcalc.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        String actualtitle = driver.getTitle();
            if(actualtitle.equals("mortgage calculator")) {
                System.out.println("Title Matches");

            }else {
                System.out.println("Title doesn't match" + actualtitle);
            }

        //store the loan amount first
            WebElement loanamount = driver.findElement(By.xpath("//*[@name='ma']"));

            //clear previous loan amount data
            loanamount.clear();
            //entering new loan amount
            loanamount.sendKeys(Houseprice[i]);

            //store previous loan term first
            WebElement downpayment = driver.findElement(By.xpath("//*[@name='dp']"));

                    //clear previous downpayment data
                    downpayment.clear();
            //entering new downpayment percent
            downpayment.sendKeys(Downpayment[i]);

            WebElement mortgageterm = driver.findElement(By.xpath("//*[@name='mt']"));
                    //clear mortgage term
                    mortgageterm.clear();
                    Thread.sleep(800);
            //entering new term
            mortgageterm.sendKeys(MortgageTerm[i]);

            //store the interest rate first
            WebElement interestrate = driver.findElement(By.xpath("//*[@name='ir']"));
                    //clear previous interest rate
                    interestrate.clear();
            //enter new interest rate
            interestrate.sendKeys(InterestRate[i]);
            //select May from drop down

            //entering start month
            WebElement month = driver.findElement(By.xpath("//*[@name='sm']"));
                    Select dropdown1 = new Select (month);
            dropdown1.selectByVisibleText(StartMonth[i]);

            //entering start year
            WebElement year = driver.findElement(By.xpath("//*[@name='sy']"));

            Select Dropdown2 = new Select(year);
            Dropdown2.selectByVisibleText(StartYear[i]);

            //click on calculate button

            Thread.sleep(2000);

            driver.findElements(By.xpath("//*[@value= 'Calculate']"));
            //capture the monthly payment using find elements with first
        String Monthlypayment = driver.findElements(By.xpath("//td[@class='big']")).get(0).getText();
        System.out.println(" monthlypayment is "+ Monthlypayment);

        }//end for loop
    }//end of main

}//end of java class
