package pageobjects;
/**
 * @author hamza
 *This class represents the first page(login page).
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage{
	// Important elements of the page
	WebDriver driver;
	By username = By.name("userName");
	By password = By.name("password");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	// gives title of the page
	public String homepagetitle(){
		return driver.getTitle();
	}
	// returns the text written in the user name feild
	public String usernamefeildvalue(){
		return driver.findElement(username).getText();
	}
	// returns the text written in the password feild
	public String passwordfeildvalue(){
		return driver.findElement(password).getText();
	}
	// automates the login process by entering user name, password and pressing enter
	public FlightFinder LoginToNewTours(String user,String pass){
		WebElement UserNameElement = driver.findElement(username);
		WebElement PasswordElement = driver.findElement(password);
		UserNameElement.sendKeys(user);
		PasswordElement.sendKeys(pass);
		PasswordElement.submit();
		
		return new FlightFinder(driver);
	}
	//return the url of the page
	public String pageURL(){
		return driver.getCurrentUrl();
	}
	//return the title of the page
	public String pagetitle(){
		return driver.getTitle();
	}
 		
}
