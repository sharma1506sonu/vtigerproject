package com.comcast.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.genericwebdriverutility.UtilityClassObject;

public class ListenerImplementationClass implements ITestListener, ISuiteListener{
	 public ExtentSparkReporter spark;
	  public static ExtentReports report;
	  public static ExtentTest test;
	public void onStart(ISuite suite) {
		System.out.println(" Report Configuration ");
		String time = new Date().toString().replace(" ","_").replace(":", "_");
		//spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_ "+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env information & create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		report.setSystemInfo("Browser","Chrome-100");
	}
	
	public void onFinish(ISuite suite) {
		System.out.println(" Report backup ");
		report.flush();
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("====="+result.getMethod().getMethodName()+"======");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,test+"====> Started <====");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("====="+result.getMethod().getMethodName()+"======");
		test.log(Status.INFO,test+"====> Completed <====");
	}
	
	public void onTestFailure (ITestResult result) {

		 String testName=result.getMethod().getMethodName();
     	
 		//step 1: create an object of screenshot
         TakesScreenshot eDriver = (TakesScreenshot)UtilityClassObject.getDriver();
 		
 		//step-2: use getScreenshotAs method to get file type of screenshot
         String filepath = eDriver.getScreenshotAs(OutputType.BASE64);    		
 		//step 3: store screenshot in local drive
 		String time=new Date().toString().replace(" ","_").replace(":", "_");

         test.addScreenCaptureFromBase64String(filepath, testName+"_"+time);
         test.log(Status.FAIL, result.getMethod().getMethodName()+"==> FAILED <===");
 		
		}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println(" Report Configuration ");
		test.log(Status.INFO,test+"====> Skipped <====");
	}
	
	public void onTestFailureButWithinSuccessPercentage (ITestResult result) {
		System.out.println("====="+result.getMethod().getMethodName()+"======");
	}
	public void onStart (ITestContext context) {
		//System.out.println("====="+result.getMethod().getMethodName()+"======");
	}
	
	public void onFinish (ITestContext context) {
		//System.out.println("====="+result.getMethod().getMethodName()+"======");
	}
}
