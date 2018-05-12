package pega.ui.unittest.headless;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.*;
import org.testng.*;

public class UserLogin {
    
   static WebDriver driver;
       
   @BeforeClass
   public static void setup() {
        
	   //driver = new FirefoxDriver();
	   driver = new HtmlUnitDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                
   }
    
   @Test
   public void successfulLoginLogout() {
        
       //driver.get("http://127.0.0.1:9090/prweb");
	   driver.get(PegaUIUnitTest.targetURL);
       Assert.assertEquals(driver.getTitle(), "Pega 7");
       driver.findElement(By.id("txtUserID")).sendKeys("User.SvcRq");
       driver.findElement(By.id("txtPassword")).sendKeys("rules");
       //driver.findElement(By.cssSelector("input[value='Log in']")).click();
       driver.findElement(By.id("sub")).click();
       Assert.assertEquals(driver.getTitle(), "Case Worker");
       //driver.findElement(By.linkText("User.SvcRq")).click();
       //driver.findElement(By.linkText("Log off")).click();
       //Assert.assertEquals(driver.getTitle(), "Pega 7");
   }
    
   @AfterClass
   public static void teardown() {
       driver.quit();
   }   

}
