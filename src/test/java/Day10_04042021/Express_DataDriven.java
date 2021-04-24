package Day10_04042021;

import Day9_04032021.ReusableMethod;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Express_DataDriven {
    public static void main(String[] args) throws InterruptedException, IOException, BiffException {

        WebDriver driver = ReusableMethod.defineTheDriver();
        //step 1: locate the path for readable file that we created in excel
        Workbook readable = Workbook.getWorkbook(new File("src/main/resources/Express_DataDriven.xls"));

        //Step 2: create a writable workbook that will mimic the data from readable
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/Express_datadriven_result.xls"), readable);

        //Ste3 : read everything from writable sheet
        WritableSheet writableSheet = writableWorkbook.getSheet(0);

        //Step 4: get the row count
        int rowCount = writableSheet.getRows();

        //this is where the for loop will start to iterate through your excel data
        for (int i = 1; i < rowCount; i++) {

            //columns are hard coded and row is dynamic(i)
            String Size = writableSheet.getCell(0, i).getContents();
            String Quantity = writableSheet.getCell(1, i).getContents();
            String FName = writableSheet.getCell(2, i).getContents();
            String LName = writableSheet.getCell(3, i).getContents();
            String Email = writableSheet.getCell(4, i).getContents();
            String Phone = writableSheet.getCell(5, i).getContents();
            String Saddress = writableSheet.getCell(6, i).getContents();
            String Zcode = writableSheet.getCell(7, i).getContents();
            String City = writableSheet.getCell(8, i).getContents();
            String State = writableSheet.getCell(9, i).getContents();
            String ccNumber = writableSheet.getCell(10, i).getContents();
            String Emonth = writableSheet.getCell(11, i).getContents();
            String Eyear = writableSheet.getCell(12, i).getContents();
            String Cvvcode = writableSheet.getCell(13, i).getContents();

            //navigate to express website
            Thread.sleep(2000);
            driver.navigate().to("https://www.express.com");
            //delete all cookies
            driver.manage().deleteAllCookies();
            Thread.sleep(2500);

            ReusableMethod.clickOnElement(driver,"//button[@id='closeModal']","close pop up");
            ReusableMethod.MouseHover(driver,"//a[text()='Men']","men's tab");
            ReusableMethod.clickOnElement(driver,"//a[text()='Sweatshirts & Hoodies']","Sweaters");
            ReusableMethod.clickOnElement(driver,"//*[text()='Black Logo Graphic Hoodie']","first hoodies");
            ReusableMethod.clickOnElement(driver,"//*[text()='"+Size+"']","size");
            ReusableMethod.clickOnElement(driver,"//*[text()='Add to Bag']","add to bag");
            ReusableMethod.clickOnElement(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ']","view bag");
            //click on size
            ReusableMethod.clickOnElement(driver,"//@[text()='"+ Size +"']","sizes");
            Thread.sleep(1000);
            //click on add to bag
            ReusableMethod.clickOnElement(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _3yOD6 _1Qp1L _2veMA']","Add to bag");
            Thread.sleep(1000);
            //click on view bag
            ReusableMethod.MouseHover(driver,"//*[text()='View Bag']","click on cart");
            //change the quantity
            ReusableMethod.clickOnElement(driver,"//*[@id='qdd-0-quantity'","click on quantity button");
            //CLick on checkout
            ReusableMethod.clickOnElement(driver,"//*[@id='continue-to-checkout'","continue to check out");
            Thread.sleep(1500);
            //click on continue as guest
            ReusableMethod.clickOnElement(driver,"//button[text()='Checkout as Guest']","continue to check out");
            //Enter first name
            // ReusableMethod.sendKeysMethod(driver,"//*[text()='"+FName+"']","");
            //Enter last name
            // ReusableMethod.sendKeysMethod(driver,"//*[@id='"+LName+"']","last name");
            //Enter Email
            //ReusableMethod.sendKeysMethod(driver," ",email,"email");
            //reenter email
           // ReusableMethod.sendKeysMethod(driver," ",email,"emaile");
            //Phone number
           // ReusableMethod.sendKeysMethod(driver," ",phone,"phonee");
            //click on continue
           // ReusableMethod.clickOnElement(driver," ","continueId");



        }//end of for loop

        }//end of main method
}//end of java
