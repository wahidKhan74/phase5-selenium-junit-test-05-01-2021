package com.ecom.webapp.amazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class AmazonProductSearchTest {

	final String siteURL = "https://www.amazon.in/";
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
		// close driver
		driver.close();
	}

	@Test
	@DisplayName("Amazon Test :: Search for Iphone 12")
	void testForSearchProduct() {
		// find search box 
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		assertTrue(searchBox.isDisplayed());
		assertTrue(searchBox.isEnabled());
		
		// enter data into search field.
		searchBox.sendKeys("Iphone 12");
		
		//submit
		searchBox.submit();
		
	}
	
	
	@Test
	@DisplayName("Amazon Test :: Search for One Plus")
	void testForSearchProduct2() {
		// find search box 
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		assertTrue(searchBox.isDisplayed());
		assertTrue(searchBox.isEnabled());
		
		// enter data into search field.
		searchBox.sendKeys("One Plus Nord");
		
		//submit
		searchBox.submit();		
	}

	// TODO : Search test for min 3 more product.
}
