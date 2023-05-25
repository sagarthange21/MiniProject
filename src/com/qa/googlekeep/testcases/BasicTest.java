package com.qa.googlekeep.testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTest {
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\UP2215\\Desktop\\Project\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://keep.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}


	@Test(description="To verify the User is able to create Note of Google Keep")
	public void verifyUserIsAbleToCreateNote () throws InterruptedException {

		// To verify wheather user is able to login with Valid Credentials

		WebElement userName=driver.findElement(By.id("identifierId"));
		userName.sendKeys("testuser21111994@gmail.com");
		WebElement nextButton1=driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextButton1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement passWord=driver.findElement(By.xpath("//input[@name='Passwd']"));
		passWord.sendKeys("Sagar@123");
		passWord.sendKeys(Keys.TAB);
		passWord.sendKeys(Keys.TAB);
		Thread.sleep(4000);
		WebElement nextButton2=driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		nextButton2.click();

		// To Verify Wheather User is able to login into Google Keep Account Successfully
		String actualTittle="Google Keep";
		Thread.sleep(5000);
		String expectedTittle=driver.getTitle();
		Assert.assertEquals(expectedTittle, actualTittle);

		// To Verify wheather user is able to create a Keep Note Successfully
		WebElement takeANoteTextbox=driver.findElement(By.xpath("//div[@aria-label='Take a note…']"));
		takeANoteTextbox.sendKeys("sample Note");
		WebElement closeButton=driver.findElement(By.xpath("//div[@class='IZ65Hb-yePe5c']//child::div[text()='Close']"));
		closeButton.click();
		Thread.sleep(5000);
		WebElement SampleNote=driver.findElement(By.xpath("//div[contains(text(),'sample Note')]"));
		
		boolean checkSampleNote=SampleNote.isDisplayed();
		Assert.assertTrue(checkSampleNote,"note is not displayed");

	}

	@AfterMethod
	public void tearDown() 
	{

		driver.quit();
	}
}
