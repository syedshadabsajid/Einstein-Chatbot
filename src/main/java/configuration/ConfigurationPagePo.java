package configuration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigurationPagePo {
	public static WebElement sideIcon(WebDriver driver){
		return driver.findElement(By.xpath("//div[contains(@class, 'slds-icon-waffle')]"));
	}
	
	public static WebElement einsteinConfig(WebDriver driver){
		return driver.findElement(By.linkText("Einstein Intent Configuration"));
	}

	public static WebElement datasetsModels(WebDriver driver){
		return driver.findElement(By.xpath("//a[contains(@data-label,'Datasets and Models')]"));
	}
	
	public static WebElement prediction(WebDriver driver){
		return driver.findElement(By.xpath("//a[@data-label='3. Prediction']"));
	}
	
	public static WebElement retain(WebDriver driver){
		return driver.findElement(By.xpath("//button[contains(text(),'Retrain')]"));
	}
	
	public static WebElement send(WebDriver driver){
		return driver.findElement(By.xpath("//button[contains(text(),'Send')]"));
	}
	
	public static WebElement chatBotInput(WebDriver driver){
		return driver.findElement(By.xpath("//textarea[contains(@class, 'slds-textarea')]"));
	}
	
	public static List<WebElement> responseGrid(WebDriver driver){
		return driver.findElements(By.xpath("//div[@class='slds-p-around_small slds-grow']"));
	}
	
	public static WebElement configurationTab(WebDriver driver){
		return driver.findElement(By.xpath("//one-app-nav-bar-item-root[2]/a/span"));
	}
}
