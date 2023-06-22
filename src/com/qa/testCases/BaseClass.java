package com.qa.testCases;
import com.qa.utilities.ReadConfig;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();


	public String baseURl=readconfig.getApplicationURL();
	public String userName=readconfig.getUsername();
	public String passWord=readconfig.getPassword();

	public static WebDriver driver;


	@BeforeClass
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.demo.guru99.com/v4");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}



	@AfterClass
	public void teaDown()
	{
		driver.quit();
	}


	public void failedTestcaseScreenshot(String testMethodName) 
	{
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// Save the screenshot to the specified path
			FileUtils.copyFile(srcFile, new File("C:\\Users\\UP2215\\eclipse-workspace\\Test_Banking_Automation_Project\\Screenshots\\"+testMethodName+".jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String randomEmail() 
	{
		String generateString= RandomStringUtils.randomAlphabetic(8)+"@gmail.com";
		return(generateString);
	}

	public String randomnum() 
	{
		String generateString= RandomStringUtils.randomNumeric(10);
		return(generateString);
	}



}
