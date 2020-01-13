package practice;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HTMLReport {
	static WebDriver driver;

    @Test
    public void HTMLReportOne(){
        
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anubha.Gupta\\eclipse-workspace\\xperigo\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        Reporter.log("Browser Maximized");
        
        driver.get("http://www.google.com");
        
        Reporter.log("Application started");
        
        driver.quit();
        
        Reporter.log("Application closed");
        
    }

}

