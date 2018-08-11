/**
 * 
 */
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author hamza
 * This is the last page  which confirms the booking details
 */
public class Confirmflight {

	WebDriver driver;
	By DepArr = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[3]/td/font/b");
	By ArrDep = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/table/tbody/tr[5]/td/font/b");
	
	public Confirmflight(WebDriver driver){
		this.driver = driver;
	}
	// returns journey from to locations
	public String FromTo(){
		return driver.findElement(DepArr).getText();
	}
	// returns journey to from locations
	public String ToFrom(){
		return driver.findElement(ArrDep).getText();
	}
	//returns page url
	public String pageURL(){
		return driver.getCurrentUrl();
	}
	// return page title 
	public String pagetitle(){
		return driver.getTitle();
	}
}
