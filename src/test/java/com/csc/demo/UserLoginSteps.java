package com.csc.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserLoginSteps {
	
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.firefox());
	    baseUrl = "https://login.salesforce.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	@Given("^user is on https://login\\.salesforce\\.com/$")
	public void user_is_on_https_login_salesforce_com() throws Throwable {
		driver.get(baseUrl + "/");
	}

	@When("^user enters a valid credential$")
	public void user_enters_a_valid_credential() throws Throwable {
		driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("binhnguyen@hcmsfdg.vn");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("a7654321");
	    driver.findElement(By.id("Login")).click();
	}

	@Then("^user goes to salesforce home page$")
	public void user_goes_to_salesforce_home_page() throws Throwable {
		for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.id("ForceCom_font")).isDisplayed()) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    assertEquals("Force.com Home", driver.findElement(By.id("ForceCom_font")).getText());
	}

	@Given("^user is logged$")
	public void user_is_logged() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user click logout$")
	public void user_click_logout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^user goes back to https://login\\.salesforce\\.com/$")
	public void user_goes_back_to_https_login_salesforce_com() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
