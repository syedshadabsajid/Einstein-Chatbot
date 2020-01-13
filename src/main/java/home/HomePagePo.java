package home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePagePo {
	public static WebElement search(WebDriver driver){
		return driver.findElement(By.xpath("//input[contains(@title, 'Search')]"));
	}
	
	public static List<WebElement> listInfo(WebDriver driver){
		return driver.findElements(By.xpath("//table//a[@data-refid='recordId']"));
	}

	
	public static WebElement tabBarFirst(WebDriver driver){
		return driver.findElement(By.xpath("//ul[@class='tabBarItems slds-grid']//li//div//button[contains(@title, 'Close')]"));
	}
	
	
	public static List<WebElement> tabBarListTwo(WebDriver driver){
		return driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']//li//div//button[contains(@title, 'Close')]"));
	}
	
	public static WebElement searchDropdown(WebDriver driver){
		return driver.findElement(By.xpath("//input[@id='input-7']"));
	}
}
