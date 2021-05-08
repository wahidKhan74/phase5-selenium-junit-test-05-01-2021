package com.ecom.webapp.screenshot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.Dimension;
import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BrowserWindowScreenShotTest {

	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "driver/geckodriver";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		// setup up
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() throws Exception {
		// close driver
		driver.close();
	}

	@Test
	@DisplayName("Test :: Amazon Home Page Screenshot")
	void takeScreenShotTest() throws IOException {
		// step 1 : typescast driver object mobileinto takeScreenshot instance
		TakesScreenshot tsc = (TakesScreenshot) driver;

		// step 2: generate a screenshot as file
		File rsc = tsc.getScreenshotAs(OutputType.FILE);

		FileHandler.copy(rsc, new File("/home/wahidkhan74gmai/test-screanshot/amazon-home.png"));

	}

	@Test
	@DisplayName("Amazon Test : Mobile Link Verfication ScreenShot")
	void testMobileNavigationLink() throws IOException {
		
		System.out.println(driver.manage().window().getSize());
		
		Dimension d = new Dimension(480, 620);
		
		driver.manage().window().setSize(d);		
		
		// find mobile link & click
		driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)")).click();

		takeScreenShot("amazon-mobile.png");
	}
	

	@Test
	@DisplayName("Amazon Test : Tooday Deals Link Verfication")
	void testTodaysDealNavigationLink() throws IOException {		
		//find mobile link
		driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(4)")).click();
		takeScreenShot("amazon-todays-deals.png");
	}
	
	
	private void takeScreenShot(String filename) throws IOException {
		TakesScreenshot tsc = (TakesScreenshot) driver;

		// step 2: generate a screenshot as file
		File rsc = tsc.getScreenshotAs(OutputType.FILE);

		FileHandler.copy(rsc, new File("/home/wahidkhan74gmai/test-screanshot/"+filename));
	}
}
