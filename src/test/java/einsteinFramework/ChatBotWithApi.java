package einsteinFramework;

import org.testng.annotations.Test;

import configuration.ConfigurationPageHelper;
import dataProvider.CsvReader;
import dataProvider.ReadDataFromApi;
import home.HomePageHelper;
import dataProvider.ConfigFileReader;
import logIn.LogInHelpe;
import utilityHelper.PageHelper;
import utilityHelper.StringManipulation;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChatBotWithApi {
	ConfigFileReader configFileReader;
	WebDriver driver;
	LogInHelpe objLogin;
	HomePageHelper objHomePage;
	static String startRow;
	static String rowCount;
	static String columnCount;
	Logger log = LogManager.getLogger(ChatBot.class);
	
	@DataProvider
	public Object[][] Authentication() throws Exception {
		Object[][] testObjArray = ReadDataFromApi.getDataFromSales();
		System.out.println(testObjArray[0][0]);
		return (testObjArray);
	}
	
  @Test (priority=0, description = "Login into application")
  public void login() {
	  log.info("Test: Login into Application\n\n");
	  log.info("login application\n\n");
	  objLogin = new LogInHelpe(driver);
	  objLogin.loginToPage(configFileReader.getUserName(), configFileReader.getPassword());
  }
  
  @Test (priority=1, description = "Verify home page displayes", enabled= false)
  public void homeVerify() {
	  objHomePage = new HomePageHelper(driver);
	  objHomePage.verifyNavigation();
  }
  
  @Test (priority=2, description = "Verify Prediction open")
  public void verifyPredictionOpened() throws InterruptedException {
	  ConfigurationPageHelper configurationPageHelper = new ConfigurationPageHelper(driver);
	  configurationPageHelper.openEinsteinConfig();
	  configurationPageHelper.openConfiguration();
	  System.out.println("enter");
	  try {
		  configurationPageHelper.openPrediction();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  @Test (priority=3, dataProvider = "Authentication", description = "Verify chatbot information", dependsOnMethods = "verifyPredictionOpened")
  public void verifyChatBotREsponseData(String chat, String response, ITestContext context) throws InterruptedException, IOException {
	  objHomePage = new HomePageHelper(driver);
	  
	  // context.setAttribute("param", tabArray[0]);
	  System.out.println("Step1:");
	  System.out.println("first is " + chat);
	  System.out.println("second is " + response);
	  
	  ConfigurationPageHelper configurationPageHelper = new ConfigurationPageHelper(driver);
	  
	  System.out.println("enter");
	  configurationPageHelper.enterChatBoatText(chat);
	  configurationPageHelper.verifyResponseGrid(response);
	 }  
  
  @BeforeClass
  public void beforeTest(ITestContext context) {
	  configFileReader= new ConfigFileReader();
	  System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
	  driver = new ChromeDriver();
	  context.setAttribute("WebDriver", driver);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	  driver.get("https://test.salesforce.com/");
  }
  
  @AfterMethod
  public void afterMethod() {
	  PageHelper.lineBreak();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}

