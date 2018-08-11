/**
 * 
 */
package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjects.Bookflight;
import pageobjects.Confirmflight;
import pageobjects.FlightFinder;
import pageobjects.LoginPage;
import pageobjects.Selectflight;

/**
 * @author hamza
 *
 */
public class ConfirmflightTest extends BaseClass{
	
	LoginPage log;
	FlightFinder flightfind;
	Selectflight flightselect;
	Bookflight booking;
	Confirmflight flightconfirm;
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
		flightconfirm = booking.fill(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("creditcardnumber"));
		Thread.sleep(3000);
	}
	// URL verification
	@Test
	public void VerifyURL(){
		Assert.assertEquals("The url of confirm page is incorrect",flightconfirm.pageURL(),"http://newtours.demoaut.com/mercurypurchase2.php");	
	}
	// Title verification
	@Test
	public void VerifyTitle(){
		Assert.assertEquals("The title for the flight confirmation page is incorrect",flightconfirm.pagetitle(),"Flight Confirmation: Mercury Tours");	
	}
	// checks if the location of departure and arrival are exactly what we selected
	@Test
	public void verifyToFrom(){
		Assert.assertEquals("The location of departure/arrival is wrong",flightconfirm.FromTo(),prop.getProperty("depart")+" to " + prop.getProperty("arrive"));
	}
	// checks if the date of the flight is exactly what we selected
	@Test
	public void verifyFromToReturn(){
		if(triptypeselected.equals("oneway")){
		Assert.assertEquals("There should not be a return flight as per the user instruction",null,prop.getProperty("arrive")+" to " + prop.getProperty("depart"));
		}
		else if(triptypeselected.equals("roundtrip")){
		Assert.assertEquals("The location of departure/arrival is wrong for the return journey",flightconfirm.ToFrom(),prop.getProperty("arrive")+" to " + prop.getProperty("depart"));
		}
	}
	@After
	public void teardown(){
		driver.quit();
	}

}
