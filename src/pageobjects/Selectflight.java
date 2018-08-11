/**
 * 
 */
package pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author hamza
 * This class represents the third page. This page requires user to choose the company they want to fly with
 */
public class Selectflight {

	WebDriver driver;
	// Important elements/feilds in the page
	By Airline_price_depart = By.name("outFlight");
	By Airline_price_arrival = By.name("inFlight");
	By reserveflight = By.name("reserveFlights");
	By departdate = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/b/font");
	By optionreturn = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[1]/td/table/tbody/tr[1]/td[1]/font/b/font");
	
	public Selectflight(WebDriver driver){
		this.driver = driver;
	}
	// confirm airline choosen, go to next page
	public Bookflight flightreservation_complete(){
		driver.findElement(reserveflight).click();
		return new Bookflight(driver);
	}
	// selects the airline for departure
	public void select_departure_airline(String airline){
		List<WebElement> airlines = driver.findElements(Airline_price_depart);
		for (WebElement option : airlines) {
		    if(option.getAttribute("value").equals(airline)) option.click();
		    
		}
	}
	// selects the airline for arrival
	public void select_arrival_airline(String airline){
		List<WebElement> airlines = driver.findElements(Airline_price_arrival);
		for (WebElement option : airlines) {
		    if(option.getAttribute("value").equals(airline)) option.click();
		    
		}
		
	}
	public String selectreturnoption(){
		WebElement optreturn  = driver.findElement(optionreturn);
		return optreturn.getText();
	}
	// return the url of this page	
	public String pageURL(){
		return driver.getCurrentUrl();
	}
	// returns the title of the page
	public String pagetitle(){
		return driver.getTitle();
	}
	public String date(){
		List<WebElement> x =driver.findElements(departdate);
		return x.get(0).getText();
	}
	
	
	
}
