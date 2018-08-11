/**
 * 
 */
package testcases;

import org.junit.*;
import org.openqa.selenium.WebDriver;

import pageobjects.FlightFinder;
import pageobjects.LoginPage;
/**
 * @author hamza
 *
 */
public class LoginPageTest extends BaseClass{

	LoginPage log;
	FlightFinder flight;
	
	@Before
	public void setup(){
		log = new LoginPage(driver);
	}
	// URL verfication
	@Test
	public void VerifyHomeURL(){
		Assert.assertEquals("The home page url is incorrect",log.pageURL(),"http://newtours.demoaut.com/mercurywelcome.php");	
	}
	// title verification
	@Test
	public void VerifyHometitle(){
		Assert.assertEquals("The home page title is incorrect",log.homepagetitle(),"Welcome: Mercury Tours");	
	}
	// did we recieve the username feild empty
	@Test
	public void Verifyemptyusernamefeild(){
		Assert.assertEquals("The username feild is not empty",log.usernamefeildvalue(),"");	
	}
	// did we recieve the password feild empty
	@Test
	public void Verifyemptypasswordfeild(){
		Assert.assertEquals("The password feild is not empty",log.passwordfeildvalue(),"");	
	}
	// login possible or not.
	@Test
	public void loginvalidate(){
		flight = log.LoginToNewTours(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@After
	public void teardown(){
		driver.quit();
	}

	
}
