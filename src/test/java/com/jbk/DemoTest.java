package com.jbk;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoTest {
	    WebDriver driver;
	    String nodeURL;
	    
	    @Parameters({"Port"})
	    @BeforeClass
	    public void setUp(String Port) throws MalformedURLException
	    {           
	        if(Port.equalsIgnoreCase("4455")){
	            nodeURL = "http://192.168.0.101:4444/wd/hub";
	            System.out.println("Chrome Browser Initiated");
	            DesiredCapabilities capabilities = DesiredCapabilities.chrome();            
	            capabilities.setBrowserName("chrome");
	            capabilities.setPlatform(Platform.WINDOWS);
	            driver = new RemoteWebDriver(new URL(nodeURL),capabilities);
	            driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        }
	        if(Port.equalsIgnoreCase("4456")){
	                nodeURL = "http://192.168.0.101:4444/wd/hub";
	                System.out.println("Firefox Browser Initiated");
	                DesiredCapabilities capabilities1 = DesiredCapabilities.firefox();
	                capabilities1.setBrowserName("firefox");
	                capabilities1.setPlatform(Platform.WINDOWS);
	                driver = new RemoteWebDriver(new URL(nodeURL),capabilities1);   
	                driver.get("file:///C:/Users/Administrator/Desktop/Offline%20Website/Offline%20Website/index.html");
	                driver.manage().window().maximize();
	                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        }
	    }
    
	    @Test
		public void test01() {
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.tagName("button")).click();
		}
		
		@Test
		public void test02() {
			String title= driver.getTitle();
			Assert.assertEquals(title, "JavaByKiran | Dashboard");
		}

	    
	   
	
}
