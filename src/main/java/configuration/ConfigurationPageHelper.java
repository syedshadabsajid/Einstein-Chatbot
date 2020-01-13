package configuration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilityHelper.PageHelper;

public class ConfigurationPageHelper {
	WebDriver driver;

    public ConfigurationPageHelper(WebDriver driver){
        this.driver = driver;
    }
    
    public void openConfiguration() throws InterruptedException {
    	System.out.println("Open configuration tab");
    	// PageHelper.click(driver, ConfigurationPagePo.configurationTab(driver), 2000);
    	WebElement el = ConfigurationPagePo.configurationTab(driver); 
		Thread.sleep(5000);
		System.out.println("wait 10 sec");
    	WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ConfigurationPagePo.configurationTab(driver)));
    	
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
    	executor.executeScript("arguments[0].click();", ConfigurationPagePo.configurationTab(driver));
    }
    
    public void openEinsteinConfig() {
    	System.out.println("Open side icon");
    	PageHelper.click(driver, ConfigurationPagePo.sideIcon(driver));
    	PageHelper.click(driver, ConfigurationPagePo.einsteinConfig(driver));
    }
    
    public void openPrediction() throws InterruptedException {
    	Thread.sleep(1000);
    	System.out.println("Open data set model tab");
    	PageHelper.click(driver, ConfigurationPagePo.datasetsModels(driver));
    	// PageHelper.waitToClickable(driver, ConfigurationPagePo.retain(driver));
    	Thread.sleep(3000);
    	System.out.println("Open prediction tab");
    	PageHelper.click(driver, ConfigurationPagePo.prediction(driver));
    }
    
    public void enterChatBoatText(String chatText) {
    	PageHelper.sendKey(driver, ConfigurationPagePo.chatBotInput(driver), chatText);
    	PageHelper.click(driver, ConfigurationPagePo.send(driver));
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void verifyResponseGrid(String responseExpected) {
    	String response = PageHelper.getText(driver, ConfigurationPagePo.responseGrid(driver).get(0));
    	System.out.println(response);
    	Assert.assertEquals(response, responseExpected, "Response: " + response + "should be " + responseExpected);
    }
}
