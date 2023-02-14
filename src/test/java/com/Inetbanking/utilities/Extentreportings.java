package com.Inetbanking.utilities;

import java.io.File;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extentreportings implements ITestListener {
	
	ExtentReports extent;
	ExtentTest test;
	public void onTestStart(ITestResult result)

	{
		
extent=new ExtentReports(".\\test-output\\html\\extent.html",true,DisplayOrder.NEWEST_FIRST);
		
		extent.loadConfig(new File("C:\\Users\\radkr\\eclipse-workspacenew\\Inetbanking\\Reportsconfig.xml"));
		
		
		test=extent.startTest(result.getName().toUpperCase());
		test.log(LogStatus.INFO, "Test Started");
		extent.flush();
		
	}
	
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.startTest(result.getName().toUpperCase());
		test.log(LogStatus.PASS, "Pass");
		test.log(LogStatus.INFO, "Test Passed");
		extent.endTest(test);
		extent.flush();
	}


}
