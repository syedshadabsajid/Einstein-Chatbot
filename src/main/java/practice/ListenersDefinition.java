package practice;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersDefinition implements ITestListener {
	WebDriver driver=null;
	String filePath = "D:\\SCREENSHOTS";
	
    public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
       WebDriver driver = (WebDriver)context.getAttribute("WebDriver");
    	try {
			takeScreenShot(methodName, driver, result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void onTestSuccess(ITestResult result) {

    }
    
    public void takeScreenShot(String methodName, WebDriver driver, ITestResult result) throws IOException {
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	String uniqueID = UUID.randomUUID().toString();
    	uniqueID = uniqueID.substring(1, 8);
    	ITestContext context = result.getTestContext();
        String param = (String) context.getAttribute("param");
        String fileName = param + "-" + uniqueID;
        System.out.println(fileName);
		File screenShotName = new File ((String) ("C:\\Users\\Anubha.Gupta\\eclipse-workspace\\xperigo\\test-output\\helo\\"+ fileName +".png"));
    	FileUtils.copyFile(scrFile, screenShotName);
    	Reporter.log("Check report and " + fileName);
    	Reporter.log("<a href='"+ screenShotName.getAbsolutePath() + "'> <img src='"+ screenShotName.getAbsolutePath() + "' height='100' width='100'/> </a>");
    }
}  