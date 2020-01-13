package home;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utilityHelper.PageHelper;

public class HomePageHelper {
	WebDriver driver;

    public HomePageHelper(WebDriver driver){
        this.driver = driver;
    }
    
    public void verifyNavigation() {
    	Assert.assertTrue(HomePagePo.search(driver).isDisplayed());
	}
    
    public void closeTabIfExist() throws InterruptedException {
    	Thread.sleep(1000);
    	int size = HomePagePo.tabBarListTwo(driver).size();
    	System.out.println("Total opened tabs are " + size);
    	int index = 0;
    	while (index < size) {
    		System.out.println("Tab number " + index + " closed");
    		this.closeTabBarByIndex(0);
    		index++;
    	}
    	System.out.println("All tabs are closed");
    }
    
    public void verifyNoTabExist() throws InterruptedException {
    	int size = HomePagePo.tabBarListTwo(driver).size();
    	System.out.println("Total opened tabs are " + size);
    	int index = 0;
    	while (index < size) {
    		System.out.println("Tab number " + index + "closed");
    		this.closeTabBarByIndex(0);
    		index++;
    	}
    	size = HomePagePo.tabBarListTwo(driver).size();
    	Assert.assertEquals(size, 0);
    }
    
	public void enterSearch(String searchValue) throws InterruptedException {
		System.out.println("Enter search key " + searchValue);
		HomePagePo.search(driver).clear();
		Thread.sleep(1000);
		HomePagePo.search(driver).sendKeys(searchValue);
		Thread.sleep(1000);
		HomePagePo.search(driver).sendKeys(Keys.RETURN);
	}
	
	public void openVehicleInfo() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Open Vehicle details");
		HomePagePo.listInfo(driver).get(0).click();
	}
	
	public void openContactInfo() throws InterruptedException {
		Thread.sleep(1000);
		HomePagePo.listInfo(driver).get(3).click();
	}
	
	public void closeTabBar() throws InterruptedException {
		Thread.sleep(1000);
		PageHelper.click(driver, HomePagePo.tabBarFirst(driver));
		Thread.sleep(1000);
	}
	
	public void closeTabBarByIndex(int index) throws InterruptedException {
		Thread.sleep(1000);
		PageHelper.click(driver, HomePagePo.tabBarListTwo(driver).get(index));
		Thread.sleep(1000);
	}
	
	public int getSizePolicy() {
		System.out.println("Total policies associated are " + HomePagePo.listInfo(driver).size());
		return HomePagePo.listInfo(driver).size();
	}
	
	public void openPolicyInfoBMW(int index) {
		HomePagePo.listInfo(driver).get(index).click();
	}
	
	public void openContactBMW() throws InterruptedException {
		Thread.sleep(1000);
		PageHelper.click(driver, HomePagePo.listInfo(driver).get(0));
	}
	
	public void openAccount() throws InterruptedException {
		System.out.println("Open account details");
		Thread.sleep(1000);
		if(HomePagePo.listInfo(driver).get(0).isDisplayed()) {
			PageHelper.click(driver, HomePagePo.listInfo(driver).get(0));
		}
		else {
			Thread.sleep(1000);
			PageHelper.click(driver, HomePagePo.listInfo(driver).get(0));
		}
	}
}