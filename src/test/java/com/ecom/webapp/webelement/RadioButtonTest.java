package com.ecom.webapp.webelement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioButtonTest {


	final String siteURL = "file:///home/wahidkhan74gmai/PG-Workspace/phase5-selenium-junit-test-05-01-2021/static/web-elements.html";
	final String driverPath = "driver/geckodriver";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		// setup up
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();	
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}
	
	@Test
	@DisplayName("Test : To verify radio button exist.")
	void testToVerifyRadioButtonExist() {
		
		WebElement radio1 = driver.findElement(By.id("male"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		assertEquals(false, radio1.isSelected());
		
		WebElement radio2 = driver.findElement(By.id("female"));
		assertEquals(true, radio2.isDisplayed());
		assertEquals(true, radio2.isEnabled());
		assertEquals(false, radio2.isSelected());
		
		WebElement radio3 = driver.findElement(By.id("other"));
		assertEquals(true, radio3.isDisplayed());
		assertEquals(true, radio3.isEnabled());
		assertEquals(false, radio3.isSelected());		
		
	}
	
	@Test
	@DisplayName("Test : To verify radio1 button select.")
	void testToVerifyRadioButtonSelected() throws InterruptedException {
		
		WebElement radio1 = driver.findElement(By.id("male"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		
		//select radio button
		radio1.click();
		Thread.sleep(2000);
		assertEquals(true, radio1.isSelected());	
		
	}
	
	
	@Test
	@DisplayName("Test : To verify radio2 button select.")
	void testToVerifyRadioButton2Selected() throws InterruptedException {
		
		WebElement radio2 = driver.findElement(By.id("female"));
		assertEquals(true, radio2.isDisplayed());
		assertEquals(true, radio2.isEnabled());
		
		//select radio button
		radio2.click();
		Thread.sleep(2000);
		assertEquals(true, radio2.isSelected());	
		
	}
}
