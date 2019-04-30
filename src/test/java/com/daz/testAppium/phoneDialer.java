package com.daz.testAppium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.MobileCapabilityType;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;




public class phoneDialer {
	
	//AndroidDriver <AndroidElement> driver;
	WebDriver driver;
	
	//@BeforeClass
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		cap.setCapability("appPackage", "com.google.android.dialer");
		cap.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
		
		driver  = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
	}
	
  //@Test
  public <T> void f() {
	  
	  
	  driver.findElement(By.id("floating_action_button")).click();
	  
	  WebElement zero = driver.findElement(By.id("zero"));
	  
	  new TouchAction((PerformsTouchActions) driver)
	  			.longPress(longPressOptions()
	  			.withElement(element(zero))
	  			.withDuration(Duration.ofMillis(10000)))
	  			.release()
	  			.perform();
	  
	  zero.click();
	
	  Assert.assertEquals(driver.findElement(By.id("digits")).getText(), "+0");
	  
	  
  }
}
