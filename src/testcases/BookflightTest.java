/**
 * 
 */
package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


import pageobjects.Bookflight;
import pageobjects.FlightFinder;
import pageobjects.LoginPage;
import pageobjects.Selectflight;

/**
 * @author hamza
 *	Test file for Bookflight
 */
public class BookflightTest extends BaseClass {
	
	LoginPage log;
	FlightFinder flightfind;
	Selectflight flightselect;
	Bookflight booking;
	String triptypeselected;
	
	@Before
	public void setup() throws InterruptedException{
		log = new LoginPage(driver);
		flightfind = log.LoginToNewTours(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(3000);
		flightfind.fill(prop.getProperty("trip"), prop.getProperty("depart"), prop.getProperty("arrive"), prop.getProperty("service"));
		triptypeselected = flightfind.triptypeselected();
		flightselect = flightfind.findflights_continue();
		Thread.sleep(3000);
		booking = flightselect.flightreservation_complete();
		Thread.sleep(3000);
	}
	// URL verification
	@Test
	public void VerifyURL(){
		Assert.assertEquals("The url for flight booking page is incorrect",booking.pageURL(),"http://newtours.demoaut.com/mercurypurchase.php");	
	}
	// Title verification
	@Test
	public void VerifyTitle(){
		Assert.assertEquals("The title for the flight booking page is incorrect",booking.pagetitle(),"Book a Flight: Mercury Tours");	
	}
	
	@After
	public void teardown(){
		driver.quit();
	}

	
	
	
	

}
