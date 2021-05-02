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

public class CheckBoxTest {


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
	@DisplayName("Test : To verify checkbox list exist.")
	void testToVerifyCheckboxExist() {
		
		WebElement checkBox1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox1.isDisplayed());
		assertEquals(true, checkBox1.isEnabled());
		assertEquals(false, checkBox1.isSelected());
		
		WebElement checkBox2 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox2.isDisplayed());
		assertEquals(true, checkBox2.isEnabled());
		//default select for vehicle2
		assertEquals(true, checkBox2.isSelected());
		
		WebElement checkBox3 = driver.findElement(By.id("vehicle3"));
		assertEquals(true, checkBox3.isDisplayed());
		assertEquals(true, checkBox3.isEnabled());
		assertEquals(false, checkBox3.isSelected());		
		
	}
	
	@Test
	@DisplayName("Test : To verify checkbox1 select.")
	void testToVerifyRadioButtonSelected() throws InterruptedException {
		
		WebElement checkBox1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox1.isDisplayed());
		assertEquals(true, checkBox1.isEnabled());
		
		//select checkbox
		checkBox1.click();
		Thread.sleep(2000);
		assertEquals(true, checkBox1.isSelected());	
		
	}
	
	
	@Test
	@DisplayName("Test : To verify checkbox 2 de-select.")
	void testToVerifyRadioButton2Selected() throws InterruptedException {
		
		WebElement checkBox2 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox2.isDisplayed());
		assertEquals(true, checkBox2.isEnabled());
		
		//de-select checkbox
		checkBox2.click();
		Thread.sleep(2000);
		assertEquals(false, checkBox2.isSelected());	
		
	}
}
