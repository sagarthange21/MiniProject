package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.testCases.BaseClass;

public class CrateNewCustomer extends BaseClass{



	WebDriver ldriver;
	public CrateNewCustomer (WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}



	@FindBy(xpath="//a[text()='New Customer']")
	@CacheLookup
	private WebElement lnkAddNewcustomer;

	@FindBy(xpath="//input[@name='name']")
	@CacheLookup
	private WebElement custName;

	@FindBy(xpath="//input[@name='rad1'][1]")
	@CacheLookup
	private WebElement custGender;

	@FindBy(xpath="//input[@name='dob']")
	@CacheLookup
	private WebElement custDateofJoin;

	@FindBy(xpath="//textarea[@name='addr']")
	@CacheLookup
	private WebElement custAddt;

	@FindBy(xpath="//input[@name='city']")
	@CacheLookup
	private WebElement custCity;

	@FindBy(xpath="//input[@name='state']")
	@CacheLookup
	private WebElement custState;

	@FindBy(xpath="//input[@name='pinno']")
	@CacheLookup
	private WebElement custPin;

	@FindBy(xpath="//input[@name='telephoneno']")
	@CacheLookup
	private WebElement custTelephone;

	@FindBy(xpath="//input[@name='emailid']")
	@CacheLookup
	private WebElement custNewemail;

	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	private WebElement custNewPaswwrd;


	@FindBy(xpath="//input[@name='sub']")
	@CacheLookup
	private WebElement submitBtn;


	public void clickNewcustomerbtn() 
	{
		lnkAddNewcustomer.click();	
	}

	public void setCustoname(String custNamee) 
	{
		custName.sendKeys(custNamee);	
	}

	public void selectcustGender() 
	{
		custGender.click();	
	}

	public void setCustDateofBirth(String mm,String dd,String yy) 
	{
		custDateofJoin.sendKeys(mm);	
		custDateofJoin.sendKeys(dd);
		custDateofJoin.sendKeys(yy);
	}

	public void setCustoAddress(String addree) 
	{
		custAddt.sendKeys(addree);	
	}


	public void setCustoCity(String city) 
	{
		custCity.sendKeys(city);	
	}

	public void setCustoState(String state) 
	{
		custState.sendKeys(state);	
	}

	public void setCustoPin(String pin) 
	{
		custPin.sendKeys(pin);	
	}

	public void setCustoPhoneNumber(String phno) 
	{
		custTelephone.sendKeys(phno);	
	}

	public void setCustoEmail(String email) 
	{
		custNewemail.sendKeys(email);	
	}


	public void setCustoPassword(String passkey) 
	{
		custNewPaswwrd.sendKeys(passkey);	
	}


	public void clicksubmitbtn() 
	{
		submitBtn.click();	
	}

	public void verifyNewlyCreatedCustomer() 
	{
		boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res==true) 
		{
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);
		}

	}

}
