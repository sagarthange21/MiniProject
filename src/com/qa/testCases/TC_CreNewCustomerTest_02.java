package com.qa.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pageObjects.LoginPage;
import com.qa.pageObjects.CrateNewCustomer;

public class TC_CreNewCustomerTest_02 extends BaseClass {

	@Test(description = "Adding new Customer and Verifying the newly Added customer")
	public void createNewCutomer() throws InterruptedException
	{

		LoginPage lp = new LoginPage(driver);
		lp.setUsername(passWord);	
		lp.setPassword(userName);
		lp.clickLoginbtn();

		CrateNewCustomer newCust= new CrateNewCustomer(driver);
		newCust.clickNewcustomerbtn();
		newCust.setCustoname("Test user");
		newCust.selectcustGender();
		newCust.setCustDateofBirth("10","11", "2001");
		Thread.sleep(3000);
		newCust.setCustoAddress("localaddresspune");
		newCust.setCustoCity("pune");
		newCust.setCustoState("Maharashtra");
		newCust.setCustoPin("412210");
		newCust.setCustoPhoneNumber(randomnum());
		Thread.sleep(3000);
		newCust.setCustoEmail(randomEmail());
		newCust.setCustoPassword("abcdef");
		newCust.clicksubmitbtn();
		Thread.sleep(10000);
		newCust.verifyNewlyCreatedCustomer();
	}




}
