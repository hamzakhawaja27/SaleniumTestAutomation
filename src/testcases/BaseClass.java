/**
 * 
 */
package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author hamza
 *
 */
public class BaseClass {
	public WebDriver driver;
	public Properties prop;
	public BaseClass(){
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\hamza\\Desktop\\RevIT\\src\\testcases\\CredentialsConfig.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}

		System.setProperty(prop.getProperty("browser").toString(), prop.getProperty("driverpath").toString());
		this.driver = new ChromeDriver();
		this.driver.get(prop.getProperty("url"));
		this.driver.manage().window().maximize();
	}	
}
