package Day10_04042021;

import Day9_04032021.ReusableMethod;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class MlCalc_DataDriven {
    public static void main(String[] args) throws InterruptedException, IOException, BiffException, WriteException {

        //set the driver using reusable methods
        WebDriver driver = ReusableMethod.defineTheDriver();

        //step 1: locate the path for readable file thar we created in excel
        Workbook readable =Workbook.getWorkbook(new File("src/main/resources/mlcalc-datadriven.xls"));

        //Step 2: create a writable workbook that will mimic the data from readable
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(new File("src/main/resources/MlCalc_DataDriven_result.xls"),readable);

        //Ste3 : read everything from writable sheet
        WritableSheet writableSheet = writableWorkbook.getSheet(0);

//Step 4: get the row count
        int rowCount = writableSheet.getRows();

//this is where the for loop will start to iterate through your excel data
        for(int i =1; i <rowCount; i++){

            //columns are hard coded and row is dynamic(i)
            String pPrice = writableSheet.getCell(0,i).getContents();
            String dPayment = writableSheet.getCell(1,i).getContents();
            String mTerm = writableSheet.getCell(2,i).getContents();
            String iRate = writableSheet.getCell(3,i).getContents();
            String stMonth = writableSheet.getCell(4,i).getContents();
            String stYear = writableSheet.getCell(5,i).getContents();

            //navigate to mlcalc
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(3000);
            //enter the purchase price
            ReusableMethod.sendKeysMethod(driver,"//input[@id='ma']",pPrice,"Purchase Price");
            //enter the down payment
            ReusableMethod.sendKeysMethod(driver,"//input[@id='dp']",dPayment,"Down Payment");
            //enter mortgage term
            ReusableMethod.sendKeysMethod(driver,"//input[@id='mt']",mTerm,"Mortgage Term");
            //enter interest rate
            ReusableMethod.sendKeysMethod(driver,"//input[@id='ir']",iRate,"Interest Rate");
            //select start month
            ReusableMethod.dropdownByText(driver,"//select[@name='sm']",stMonth,"Start Month");
            //select start year
            ReusableMethod.dropdownByText(driver,"//select[@name='sy']",stYear,"Start Year");
            //click on Calculate
            ReusableMethod.clickOnElement(driver,"//input[@value='Calculate']","Calculate");

            //capture monthly payment
            String monthlyPayment = ReusableMethod.captureText(driver,"//td[@class='big']",0,"Monthly Payment");

            //create a label so you can add it to a cell
            Label label = new Label(6,i,monthlyPayment);
            //add the label back to the sheet
            writableSheet.addCell(label);
        }//end of loop

//outside of the cell write back to writable workbook
        writableWorkbook.write();
//close it
        writableWorkbook.close();

    }//end of main

}//end of class

