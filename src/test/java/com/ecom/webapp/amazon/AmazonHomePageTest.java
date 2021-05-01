package com.ecom.webapp.amazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class AmazonHomePageTest {

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
		// 7 .close driver
		driver.close();
	}

	@Test
	@DisplayName("Amazon Test :: Home Page Title Verification")
	void testHomePageTile() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		assertEquals(expected, driver.getTitle());
	}
	
	@Test
	@DisplayName("Amazon Test :: Home Page Source Verification")
	void testSourceURL() {
		assertEquals(siteURL, driver.getCurrentUrl());
	}

}
