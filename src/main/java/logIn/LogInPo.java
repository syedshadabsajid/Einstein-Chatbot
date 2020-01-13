package logIn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPo {

	public static WebElement myAccount(WebDriver driver){
		return driver.findElement(By.cssSelector(".dropdown.dropdown-login.dropdown-tab"));
	}
	
	public static WebElement loginButton(WebDriver driver){
		return driver.findElement(By.id("Login"));
	}
	
	public static WebElement userName(WebDriver driver){
		return driver.findElement(By.id("username"));
	}
	
	public static WebElement password(WebDriver driver){
		return driver.findElement(By.id("password"));
	}
}
