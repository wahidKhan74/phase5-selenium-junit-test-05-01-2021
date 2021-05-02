package com.ecom.webapp.webelement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectDropDownTest {
	
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
	@DisplayName("Test : to verify select dropdown exist.")
	void testToVerifySelectDropDownExist() {
		
		WebElement select = driver.findElement(By.id("vehicle"));
		assertEquals(true, select.isDisplayed());
		assertEquals(true, select.isEnabled());
	}
	
	@Test
	@DisplayName("Test : to verify first select option from dropdown.")
	void testToVerifyFirstSelectedOption() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));		
		Select vehicleSelect = new Select(select);
		
		// select bike as first selected option
		vehicleSelect.selectByVisibleText("Bike");
		
		WebElement selectedOption = vehicleSelect.getFirstSelectedOption();
		
		assertEquals("Bike", selectedOption.getText());
		Thread.sleep(2000);
	}
	
	@Test
	@DisplayName("Test : to verify index based select option from dropdown.")
	void testToVerifyIndexBasedtSelectedOption() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));		
		Select vehicleSelect = new Select(select);
		
		// select index 3 as selected option
		vehicleSelect.selectByIndex(3);
		
		WebElement selectedOption = vehicleSelect.getFirstSelectedOption();
		
		assertEquals("Airplane", selectedOption.getText());
		Thread.sleep(2000);
	}
	
	@Test
	@DisplayName("Test : to verify value based select option from dropdown.")
	void testToVerifyValueBasedtSelectedOption() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));		
		Select vehicleSelect = new Select(select);
		
		// select value "car" as selected option
		vehicleSelect.selectByValue("car");
		
		WebElement selectedOption = vehicleSelect.getFirstSelectedOption();
		
		assertEquals("Car", selectedOption.getText());
		Thread.sleep(2000);
	}
}


