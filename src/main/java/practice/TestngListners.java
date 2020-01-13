package practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestngListners {
	static WebDriver driver;

	@BeforeClass
	public void setUp(ITestContext context)  {
			  
			  
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anubha.Gupta\\eclipse-workspace\\xperigo\\chromedriver.exe");
		driver = new ChromeDriver();
		context.setAttribute("WebDriver", driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.inviul.com/");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	@Test(priority = 1)
	public void getTitle() {
		System.out.println("Title is- " + driver.getTitle());
	}

	
	@Test(priority = 2)
	public void passTest() throws IOException {
		Reporter.log("check here");
		Assert.assertTrue(false);
	}
	
	
	
}