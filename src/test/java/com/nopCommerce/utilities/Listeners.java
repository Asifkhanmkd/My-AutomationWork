package com.nopCommerce.utilities;

import java.awt.Color;
import java.io.IOException;
import java.util.Date;

import org.testng.ITestContext;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter {
	
	 ExtentHtmlReporter html;
	 ExtentReports extent;
	 ExtentTest logger;
	
	public void onStart(ITestContext tr) {
        Date d= new Date();
		String stamp = d.toString().replace(":", "_").replace(" ", "_");
		String extReport = stamp+".html";
		html=new ExtentHtmlReporter("C:\\Users\\asif\\SdetSelinium\\ExampleDemo1\\target\\"+extReport);
	   // html= new ExtentHtmlReporter(System.getProperty("user.dir")+"\\target\\myReport.html");
		//html=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\myReport.html");
		html.loadXMLConfig("C:\\Users\\asif\\SdetSelinium\\ExampleDemo1\\extent-config.xml");
		extent=new ExtentReports();
		extent.attachReporter(html);
		extent.setSystemInfo("User", "Asif");
		extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("O.S", "Windows");
		extent.setSystemInfo("Host", "Local");
		
		html.config().setDocumentTitle("Automatio Testing");
		html.config().setReportName("Functional Testing");
		html.config().setTheme(Theme.STANDARD);
		
	}
	
	public void onTestSuccess(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
		
		
	}
	
	public void onTestFailure(ITestResult tr)  {
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		
	  String screenshotpath= System.getProperty("user.dir")+"\\screenshot\\"+tr.getName()+".png";
      
		try {
		
			//logger.fail("Screenshot Attached "+logger.addScreenCaptureFromPath(screenshotpath));
		     logger.addScreenCaptureFromPath(screenshotpath);
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		
	}
    
	public void onTestSkipped(ITestResult tr) {
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
		
		
		
	}
	
	public void onFinish(ITestContext tr) {
	extent.flush();
		
		
	}
}