package logIn;

import org.openqa.selenium.WebDriver;

import utilityHelper.PageHelper;

public class LogInHelpe {
	WebDriver driver;

    public LogInHelpe(WebDriver driver){
        this.driver = driver;
    }
    
    public void clickMyAccount() {
    	LogInPo.myAccount(driver).click();
    }
    
    //Set user name in textbox

    public void setUserName(String strUserName){

        LogInPo.userName(driver).sendKeys(strUserName);

    }

    //Set password in password textbox

    public void setPassword(String strPassword){

    	LogInPo.password(driver).sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){
    	PageHelper.click(driver, LogInPo.loginButton(driver));
    }


    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void loginToPage(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();        
    }
}
