package com.daz.testAppium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class chromeTest {
	
	AppiumDriver <WebElement> driver;
	
	//@BeforeClass
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		//cap.setCapability(MobileCapabilityType.CH, value);
		cap.setCapability("browserName", "Chrome");
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	}
	
	
	
	
  //@Test
  public void googleSearch() {
	  driver.get("https://www.google.com/");
	  driver.findElement(By.xpath("//input[@name='q']")).sendKeys("appium");
	  driver.findElement(By.xpath("//a/h3[contains(text(),'Appium: Mobile App Automation Made Awesome.')]")).click();
	  
	  
  }
}
