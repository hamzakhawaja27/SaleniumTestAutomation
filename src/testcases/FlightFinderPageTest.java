/**
 * 
 */
package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pageobjects.FlightFinder;
import pageobjects.LoginPage;

/**
 * @author hamza
 * Test for flight finder
 */
public class FlightFinderPageTest extends BaseClass{
	LoginPage log;
	FlightFinder flightfind;
	@Before
	public void setup() throws InterruptedException{
		log = new LoginPage(driver);
		flightfind = log.LoginToNewTours(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(3000);
	}
	// verfies title of the page. Cannot check URL since its dynamic.
	@Test
	public void VerifyPageTitle(){
		Assert.assertEquals("The title for the flight finding page is incorrect",flightfind.pagetitle(),"Find a Flight: Mercury Tours:");	
	}
	
	@After
	public void teardown(){
		driver.quit();
	}

}
