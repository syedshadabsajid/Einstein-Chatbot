package utilityHelper;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PageHelper {

	public static void click(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public static void click(WebDriver driver, WebElement element, int staticWait) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			Thread.sleep(staticWait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public static void waitToClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void sendKey(WebDriver driver, WebElement element, String keyValue) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.clear();
		element.sendKeys(keyValue);
	}
	
	public static String getText(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element.getText();
	}
	
	public static String getText(WebDriver driver, WebElement element, boolean staticWait) throws InterruptedException {
		if (staticWait) {
			Thread.sleep(2000);
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element.getText();
	}

	public static void lineBreak() {
		System.out.println(" ");
		System.out.println("***************************************************************************");
		System.out.println("***************************************************************************");
		System.out.println(" ");
	}

	public static void emptyLine() {
		System.out.println(" ");
		System.out.println(" ");
	}

	public static void takeScreenShot(String methodName, WebDriver driver) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test method name
		try {
			FileUtils.copyFile(scrFile,
					new File("C:\\Users\\Anubha.Gupta\\eclipse-workspace\\xperigo\\src\\main\\java\\practice"
							+ methodName + ".png"));
			System.out.println("***Placed screen shot in " + "" + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isDisplayed(WebElement element, WebDriver driver, String elementName) {
		boolean flag = false;
		try {
			flag = element.isDisplayed();
			System.out.println(elementName + "is present");
			Reporter.log(elementName + "is present");
		} catch (NoSuchElementException e) {
			System.out.println(elementName + "is not present");
			Reporter.log(elementName + "is not present");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static void scrollToElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(element));
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
