/**
 * 
 */
package pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


/**
 * @author hamza
 *This class represents the second page. This page requires user to fill flight details
 */
public class FlightFinder {

	WebDriver driver;
	// Important elements/feilds in the page
	By trip_type = By.name("tripType");
	By no_passengers = By.name("passCount");
	By depart = By.name("fromPort");
	By leave_Month = By.name("fromMonth");
	By leave_Date = By.name("fromDay");
	By arrival = By.name("toPort");
	By return_Month = By.name("toMonth");
	By return_date = By.name("toDay");
	By service_class = By.name("servClass");
	By Airline = By.name("airline");
	By find_flights = By.name("findFlights");
	public FlightFinder(WebDriver driver){
		this.driver = driver;
	}
	// helps in choosing the trip type i.e. oneway or round
	public void Triptype(String trip){
		List<WebElement> triptype = driver.findElements(trip_type);
		for (WebElement option : triptype) {
		    if(option.getAttribute("value").equals(trip)) option.click();
		    
		}
	}
	// helps in choosing the city of departure
	public void departure(String city_of_departure){
		Select departing = new Select(driver.findElement(depart));
		departing.selectByVisibleText(city_of_departure);
	}
	// helps in choosing the city of arrival
	public void Arrival(String city_of_arrival){
		Select arrive = new Select(driver.findElement(arrival));
		arrive.selectByVisibleText(city_of_arrival);
	}
	// helps in choosing the service class i.e. First,Buisiness or enonomy 
	public void seat_class(String seat){
		List<WebElement> classtype = driver.findElements(service_class);
		for (WebElement option : classtype) {
		    if(option.getAttribute("value").equals(seat)) option.click();
		}
	}
	// enter the information provided
	public Selectflight findflights_continue(){
		driver.findElement(find_flights).click();
		return new Selectflight(driver);
	}
	
	// One method to fill in all the details at once and press enter
	public void fill(String trip,String city_of_departure,String city_of_arrival,String seat){
		FlightFinder flight = new FlightFinder(driver);
		flight.Triptype(trip);
		flight.departure(city_of_departure);
		flight.Arrival(city_of_arrival);
		flight.seat_class(seat);
	}
	// returns depart month and day
	public String DepartDayandMonth(){
		WebElement departMonth = driver.findElement(leave_Month);
		WebElement departday = driver.findElement(leave_Date);
		String daydatedepart = departMonth.getAttribute("value") + "/" + departday.getAttribute("value") + "/2018";
		return daydatedepart;
	}
	// returns Arrive month and day
	public String ArriveDayandMonth(){
		WebElement ArrMonth = driver.findElement(return_Month);
		WebElement Arrday = driver.findElement(return_date);
		String daydateArr = ArrMonth.getAttribute("value") + "/" + Arrday.getAttribute("value") + "/2018";
		return daydateArr;
	}
	
	// returns this page's title
	public String pagetitle(){
		return driver.getTitle();
	}
 
	// returns the value of trip type selected
	public String triptypeselected(){
		List<WebElement> triptype = driver.findElements(trip_type);
		for (WebElement option : triptype) {
			if(option.isSelected()) return option.getAttribute("value");
		}
		 return null; 
	}
	
}
