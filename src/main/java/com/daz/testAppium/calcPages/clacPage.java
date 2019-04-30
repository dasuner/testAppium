package com.daz.testAppium.calcPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class clacPage {
	
	Logger log = Logger.getLogger(getClass());
	
	
	public clacPage(AppiumDriver<WebElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id ="digit_7")
	public WebElement seven;
	
	@AndroidFindBy(id ="digit_3")
	public WebElement three;
	
	@AndroidFindBy(id ="op_add")
	public WebElement add;
	
	@AndroidFindBy(id ="eq")
	public WebElement equal;
	
	@AndroidFindBy(id ="result")
	public WebElement result;
	
	public void clickNumber(int number)
	{
		switch (number) {
		case 7:
			seven.click();
			log.info("Click 7");
			break;
		case 3:
			three.click();
			log.info("Click 3");
			break;

		default:
			break;
		}
	}
	
	public void addition()
	{
		add.click();
		log.info("Click +");
	}
	
	public void equalance()
	{
		equal.click();
		log.info("Click =");
	}
	
	public String getResult()
	{
		log.info("Send Results");
		return result.getText();
	}

}
