package com.Inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//listener class is used to generate extent reports
public class Extentreporting extends TestListenerAdapter{
	
	
	ExtentSparkReporter htmlreporter;
	ExtentReports extent;
	ExtentTest test;
	
	public void onStart(ITestContext result)
	{
		String timestamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm").format(new Date());
		String reportname="testreport"+timestamp+".html";
		htmlreporter=new ExtentSparkReporter(".\\test-output"+reportname);
		try {
			htmlreporter.loadXMLConfig("C:\\Users\\radkr\\eclipse-workspacenew\\Inetbanking\\Reportsconfig.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("environment", "QA");
		extent.setSystemInfo("user", "shanthi");
		
		htmlreporter.config().setDocumentTitle("Inetbanking testing project");
		htmlreporter.config().setReportName("Functional test report");
		htmlreporter.config().setTheme(Theme.STANDARD);
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		
		//String screenshotpath=".\\test-output\\"+result.getName()+".png";
		String screenshotpath;
		try {
			screenshotpath = Screenshot.CaptureScreenShot1(result.getName());
			test.fail("screenshot is below:"+test.addScreenCaptureFromPath(screenshotpath));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		File src=new File(screenshotpath);
//		
//		if(src.exists())
//		{
//			test.fail("screenshot is below:"+test.addScreenCaptureFromPath(screenshotpath));
//		}
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
		
	}

	public void onFinish(ITestContext result)
	{
		extent.flush();
	}


}
