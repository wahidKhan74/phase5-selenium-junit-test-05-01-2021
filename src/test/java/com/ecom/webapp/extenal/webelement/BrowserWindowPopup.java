package com.ecom.webapp.extenal.webelement;

import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserWindowPopup {
	
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
	@DisplayName("Amazon Test :: Amazon Location popup window")
	void testToVerifyLocationBrowserWindowPopup() throws InterruptedException {
		
		Thread.sleep(1000);
		// find location popup and click
		driver.findElement(By.id("nav-global-location-popover-link")).click();		
		Thread.sleep(3000);
		
		//1. main window 
		String mainWindow = driver.getWindowHandle();
		
		//2. get all windows list
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		
		while(itr.hasNext()) {
			String childWindow =  itr.next();
			//switch to child window
			driver.switchTo().window(childWindow);
			
			// find popup based element
			driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("500038");
			
			Thread.sleep(2000);
			
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();
		}
		
		// child to main
		driver.switchTo().window(mainWindow);
		Thread.sleep(2000);
	}
}
