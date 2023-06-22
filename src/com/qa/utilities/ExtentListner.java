package com.qa.utilities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.testCases.BaseClass;

public  class ExtentListner extends BaseClass  implements ITestListener{

	ExtentSparkReporter htmlReporter;
	ExtentReports reports ;
	ExtentTest test;

	public void configureReport() 
	{

		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname="Test-Report-"+timestamp+".html";
		htmlReporter= new ExtentSparkReporter("C:\\Users\\UP2215\\eclipse-workspace\\Test_Banking_Automation_Project\\ExtentReports\\"+repname);
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);

		// adding info in system
		reports.setSystemInfo("Machine", "TestPC1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Browser", "CHrome");
		reports.setSystemInfo("Machine", "TestPC1");

		// Changes in FeelLike 
		htmlReporter.config().setDocumentTitle("Extent Report Demo Tittle");
		htmlReporter.config().setReportName("Basic Automation Test Cases");
		htmlReporter.config().setTheme(Theme.DARK);
	}


	public void onStart(ITestContext result) 
	{
		configureReport();
		System.out.println("Test Started ....");
	}

	public  void onFinish(ITestContext result) 
	{
		System.out.println("Test Finish ....");
		reports.flush();
	}

	public  void onTestStart(ITestResult result)
	{

	}

	public   void onTestSuccess(ITestResult result)
	{
		System.out.println("Name of test Method successfully executed : "+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passed Test Case : "+result.getName(), ExtentColor.GREEN));
	}

	public   void onTestFailure(ITestResult result) 
	{
		System.out.println("Name of test Method Failed : "+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed Test Case : "+result.getName(), ExtentColor.RED));

		failedTestcaseScreenshot(result.getMethod().getMethodName());


	}

	public  void onTestSkipped(ITestResult result) 
	{

	}

	public  void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}




}
