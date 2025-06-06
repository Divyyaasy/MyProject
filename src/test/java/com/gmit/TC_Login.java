package com.gmit;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Comparator;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TC_Login {


    WebDriver driver;
    WebDriverWait wait;
    Path tempProfileDir;


    @BeforeClass
    public void setup() throws IOException
    {
        WebDriverManager.chromedriver().setup();
    	 ChromeOptions options = new ChromeOptions();
    	 
    	 driver = new ChromeDriver(options);
    	 
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // System.setProperty("webdriver.edge.driver", "C:\\WebDriver\\msedgedriver.exe");
       // WebDriverManager.edgedriver().setup();
        //EdgeOptions options = new EdgeOptions();
         //  options.addArguments("headless");
        //options.addArguments("disable-gpu");
           // wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
     
            }

    @Test
    public void loginTest() throws IOException {
    	
   
      
    	// Wait and enter username
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        username.sendKeys("Admin");

        // Enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        // Click login button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6[text()='Dashboard']")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        
        System.out.println("Login successful. Current URL: " + currentURL);
    
    }

    @AfterClass
    public void tearDown() {
    	
    	 if (driver != null) {
            driver.quit();
         }
    	
    }
}
