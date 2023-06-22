package com.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.testCases.BaseClass;

public class LoginPage extends BaseClass {


	WebDriver ldriver;
	public LoginPage (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(xpath="//input[@name='uid']")
	@CacheLookup
	private WebElement txtUserID;

	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	private WebElement txtPassword;

	@FindBy(xpath="//input[@name='btnLogin']")
	@CacheLookup
	private WebElement loginBtn;


	public void setUsername(String Uname) 
	{
		txtPassword.sendKeys(Uname);
	}


	public void setPassword (String Paswrd) 
	{
		txtUserID.sendKeys(Paswrd);
	}


	public void clickLoginbtn() 
	{
		loginBtn.click();
	}

	public void verifyUserLoginSuccessfully() 
	{
		if(driver.getTitle().equals("Guru99 Bank Manager HomePageee"))
		{
			Assert.assertTrue(true);
		}else
		{
			Assert.assertTrue(false);	
		}

	}


}
