package com.qa.testCases;
import com.qa.pageObjects.LoginPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_01 extends BaseClass {



	@Test(description = "Logging into the banking application with valid credentials")
	public void loginTest() throws InterruptedException
	{

		LoginPage lp = new LoginPage(driver);
		lp.setUsername(passWord);	
		lp.setPassword(userName);
		lp.clickLoginbtn();
		Thread.sleep(3000);
		
		lp.verifyUserLoginSuccessfully();

	}


}
