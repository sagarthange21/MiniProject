package com.qa.testCases;
import com.qa.pageObjects.LoginPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_01 extends BaseClass {
	
	

	@Test
	public void loginTest() throws InterruptedException
	{
		driver.get(baseURl);
		Thread.sleep(5000);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(passWord);	
		lp.setPassword(userName);
		lp.clickLoginbtn();
		
		
		Thread.sleep(3000);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);	
		}


	}


}
