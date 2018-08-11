/**
 * 
 */
package testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pageobjects.FlightFinder;
import pageobjects.LoginPage;
import pageobjects.Selectflight;

/**
 * @author hamza
 * Tests for Selectflight class
 */
public class SelectflightTest extends BaseClass{
	
	LoginPage log;
	FlightFinder flightfind;
	Selectflight flightselect;
	String triptypeselected;
	String departDate;
	String ArriveDate;
	
	@Before
	public void setup() throws InterruptedException{
		log = new LoginPage(driver);
		flightfind = log.LoginToNewTours(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(3000);
		flightfind.fill(prop.getProperty("trip"), prop.getProperty("depart"), prop.getProperty("arrive"), prop.getProperty("service"));
		triptypeselected = flightfind.triptypeselected();
		departDate = flightfind.DepartDayandMonth();
		ArriveDate = flightfind.ArriveDayandMonth();
		flightselect = flightfind.findflights_continue();
		Thread.sleep(3000);
	}
	
	// verifies page URL
	@Test
	public void VerifyURL(){
		
		Assert.assertEquals("The url for the flight selection page is incorrect",flightselect.pageURL(),"http://newtours.demoaut.com/mercuryreservation2.php");	
	}
	// verifies page title
	@Test
	public void VerifyTitle(){
		Assert.assertEquals("The title for the flight selection page is incorrect",flightselect.pagetitle(),"Select a Flight: Mercury Tours");	
	}
	// verifies whether the depart date on the ticket is what we want.
	@Test
	public void checkdateDepart(){
		Assert.assertEquals("The depart date on the page is not correct",flightselect.date(),departDate);
	}

	// checks if one way or return choice according to our input
	@Test
	public void Returnbooking(){
		if(triptypeselected.equals("oneway")){
		Assert.assertEquals("There shouldnt be a return flight",null,flightselect.selectreturnoption());
		}
	}
	
	
	@After
	public void teardown(){
		driver.quit();
	}

}
