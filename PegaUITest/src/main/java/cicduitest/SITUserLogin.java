package cicduitest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.*;

public class SITUserLogin {
    
   static WebDriver driver;
    
   @BeforeClass
   public static void setup() {
        
       driver = new FirefoxDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                
   }
    
   @Test
   public void successfulLoginLogout() {
        
       driver.get("http://localhost:9090/prweb");
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
