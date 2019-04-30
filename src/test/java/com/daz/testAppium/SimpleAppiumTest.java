package com.daz.testAppium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.daz.testAppium.calcPages.clacPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SimpleAppiumTest {
	
	
	//Create instance for Appium Driver
	AppiumDriver <WebElement> driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	}
	
	
  @Test
  public void simpleTest() {
	  
	  //Assert.assertNotNull(driver.getContext());
	  
//	  driver.findElement(By.id("digit_7")).click();
//	  driver.findElement(By.id("op_add")).click();
//	  driver.findElement(By.id("digit_3")).click();
//	  driver.findElement(By.id("eq")).click();
//	  Assert.assertEquals(driver.findElement(By.id("result")).getText(), "10");
	  
	  
	  clacPage cal = new clacPage(driver);
	  cal.clickNumber(7);
	  cal.addition();
	  cal.clickNumber(3);
	  cal.equalance();
	  
	  Assert.assertEquals(cal.getResult(), "10");
	  
	  


  }
  
  
  @Test
  public void sample()
  {
	  System.out.println("Test I am");
  }
  
  @AfterClass
  public void teatDown()
  {
	  driver.quit();
  }
}
