
package com.ontestautomation.selenium.ci;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumCITest {
     
    static WebDriver driver;
     
    @BeforeClass
    public static void setup() {
         
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                
    }
     
    @Test
    public void successfulLoginLogout() {
         
        driver.get("http://parabank.parasoft.com");
        Assert.assertEquals(driver.getTitle(), "ParaBank | Welcome | Online Banking");
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.cssSelector("input[value='Log In']")).click();
        Assert.assertEquals(driver.getTitle(), "ParaBank | Accounts Overview");
        driver.findElement(By.linkText("Log Out")).click();
        Assert.assertEquals(driver.getTitle(), "ParaBank | Welcome | Online Banking");
    }
     
    @AfterClass
    public static void teardown() {
        driver.quit();
    }   
}