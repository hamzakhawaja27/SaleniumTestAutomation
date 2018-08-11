/**
 * 
 */
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author hamza
 *  This class represents the fourth page. This page requires user information for ticketing and billing.
 */
public class Bookflight {
	
	WebDriver driver;
	// Important elements/feilds in the page
	By firstname = By.name("passFirst0");
	By lastname = By.name("passLast0");
	
	By meal = By.name("pass.0.meal");
	
	By cardtype = By.name("creditCard");
	By credit_card = By.name("creditnumber");
	By credit_card_expiry_month = By.name("cc_exp_dt_mn");
	By credit_card_expiry_year = By.name("cc_exp_dt_yr");
	By credit_card_firstname = By.name("cc_frst_name");
	By credit_card_middlename = By.name("cc_mid_name");
	By credit_card_lastname = By.name("cc_last_name");
	
	By ticketless = By.name("ticketLess");
	
	By billing_address_address1 = By.name("billAddress1");
	By billing_address_address2 = By.name("billAddress2");
	By billing_address_city = By.name("billCity");
	By billing_address_state = By.name("billState");
	By billing_address_postalcode = By.name("billZip");
	By billing_address_country = By.name("billCountry");
	
	
	By delivery_address_address1 = By.name("delAddress1");
	By delivery_address_address2 = By.name("delAddress2");
	By delivery_address_city = By.name("delCity");
	By delivery_address_state = By.name("delState");
	By delivery_address_postalcode = By.name("delZip");
	By delivery_address_country = By.name("delCountry");
	
	By completebooking_buy = By.name("buyFlights");

	public Bookflight(WebDriver driver){
		this.driver = driver;
	}
	// fills in the first and last name
	public void fill_name(String first_name, String last_name){
		driver.findElement(firstname).sendKeys(first_name);
		driver.findElement(lastname).sendKeys(last_name);
	}
	// fills credit card information
	public void fill_credit_card_info(String number){
		driver.findElement(credit_card).sendKeys(number);	
	}
	// checks ticketless option
	public void ticketing(){
	driver.findElement(ticketless).click();
	}
	// confirm and enter, go to the next page
	public Confirmflight Buyflight(){
	driver.findElement(completebooking_buy).click();
	return new Confirmflight(driver);
	}
	// One method to fill in all the details at once and press enter
	public Confirmflight fill(String first_name, String last_name,String Cnumber){
		Bookflight book = new Bookflight(driver);
		book.fill_name(first_name, last_name);
		book.fill_credit_card_info(Cnumber);
		book.ticketing();
		driver.findElement(completebooking_buy).click();
	return new Confirmflight(driver);
	}
	// returns the url of this page
	public String pageURL(){
		return driver.getCurrentUrl();
	}
	// return the title of this page
	public String pagetitle(){
		return driver.getTitle();
	}
	
}
