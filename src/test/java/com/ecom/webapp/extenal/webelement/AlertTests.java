package com.ecom.webapp.extenal.webelement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertTests {
	
	final String siteURL = "file:///home/wahidkhan74gmai/PG-Workspace/phase5-selenium-junit-test-05-01-2021/static/external-web-alert.html";
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
	@DisplayName("Test :: JavaScript Simple Alert Window Test")
	void testAlertDailogWindow() throws InterruptedException {
		
		// open alert popup window.
		WebElement alertButton = driver.findElement(By.cssSelector("body > p:nth-child(2) > button"));
		alertButton.click();
		
		// switch alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Are you sure !", alert.getText());
		Thread.sleep(3000);
		
		alert.accept();
	}
	
	
	@Test
	@DisplayName("Test :: JavaScript Confirmation Alert Test with Accept")
	void testConfirmationDailogWindow() throws InterruptedException {
		
		// open confirmation popup window.
		WebElement alertButton = driver.findElement(By.cssSelector("body > p:nth-child(4) > button"));
		alertButton.click();
		
		// switch alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Press a button !", alert.getText());
		Thread.sleep(3000);
		
		alert.accept();
	}
	
	@Test
	@DisplayName("Test :: JavaScript Confirmation Alert Test with Cancel")
	void testConfirmationDailogWindowWithCancel() throws InterruptedException {
		
		// open confirmation popup window.
		WebElement alertButton = driver.findElement(By.cssSelector("body > p:nth-child(4) > button"));
		alertButton.click();
		
		// switch alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Press a button !", alert.getText());
		Thread.sleep(3000);
		
		alert.dismiss();
		
	}
	
	@Test
	@DisplayName("Test :: JavaScript Prompt Window with accept")
	void testPromptDailogWindowWithAccept() throws InterruptedException {
		
		// open prompt popup window.
		WebElement alertButton = driver.findElement(By.cssSelector("body > p:nth-child(6) > button"));
		alertButton.click();
		
		// switch alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Please enter your name", alert.getText());
		Thread.sleep(3000);
		
		alert.accept();
		
	}
	
	@Test
	@DisplayName("Test :: JavaScript Prompt Window with Input data & accept")
	void testPromptInputDailogWindowWithAccept() throws InterruptedException {
		
		// open prompt popup window.
		WebElement alertButton = driver.findElement(By.cssSelector("body > p:nth-child(6) > button"));
		alertButton.click();
		
		// switch alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Please enter your name", alert.getText());
		
		alert.sendKeys("Iron Man !");
		Thread.sleep(3000);
		
		alert.accept();
		
	}
}
