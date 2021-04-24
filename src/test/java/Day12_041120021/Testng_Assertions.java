package Day12_041120021;

import Day9_04032021.ReusableMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.sql.Driver;

public class Testng_Assertions {

    @Test
    public void assertions() throws IOException, InterruptedException {

        WebDriver driver = ReusableMethod.defineTheDriver();
        driver.navigate().to("https://www.google.com");

        //using hard assert verify the google title
        //Assert.assertEquals("google", driver.getTitle());

        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals("google",driver.getTitle());

        //enter something on google search
        ReusableMethod.sendKeysMethod(driver,"//*[@name = 'q']","cars","searchcar");

        //assertAll should be the last step on your test
        sAssert.assertAll();




    }//end of test
}//end of java class
