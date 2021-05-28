package com.Miles_admin.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.transform.Result;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.Mile_admin_Baseclass.Baseclass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReporting extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter ;
	public ExtentReports extent=new ExtentReports()  ;
	public ExtentTest test ;

	
 public void onStart(ITestContext testcontext) {
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.SS").format(new Date());
		String repName = "Test-report-"+timestamp+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\Html\\"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		htmlReporter.config().setDocumentTitle("MilesAutomationReport");
		htmlReporter.config().setReportName("MilesEducation_Automation_Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "karthik");
		
}

public void onTestSuccess(ITestResult tr) {
	ExtentTest logger = extent.createTest(tr.getName());
	logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
}

public void onTestFailure(ITestResult tr) {
	
	ExtentTest logger = extent.createTest(tr.getName());
	logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));

	WebDriver driver= ((Baseclass)tr.getInstance()).driver;
	String screenshotpath = takescreenshotmethod(driver, tr.getName());
	File f = new File(screenshotpath);
	if(f.exists()){
		try {
			logger.fail("Screenshot is below: " +logger.addScreenCaptureFromPath(screenshotpath));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

public void onTestSkipped(ITestResult tr) {
	
	ExtentTest 	logger = extent.createTest(tr.getName());
	logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	
}
public void onFinish(ITestContext testContext) {

	extent.flush();
	System.out.println("flush");
	
}

private static String getReportname() {
	String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.SS").format(new Date());
	String Screenshot = "Miles_Automation_report" +timestamp.toString()+".png ";
	return Screenshot;
	
}

 public  static String takescreenshotmethod(WebDriver driver , String screenshot) {
	 String Screenshotpath = getReportname();
	  String directory = System.getProperty("user.dir") +"\\Screenshots\\Failed\\";
	  new File(directory).mkdirs();
	 
	 String destination  = directory + Screenshotpath;;
	try {
		TakesScreenshot scrn = (TakesScreenshot) driver;
			File source = scrn.getScreenshotAs(OutputType.FILE);
			File target = new File(destination);
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot captured");
	} catch (WebDriverException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return destination;
	
	 
 }
 
 public  static String takescreenshotmethodpass(WebDriver driver , String screenshot) {
	 String Screenshotpath = getReportname();
	  String directory = System.getProperty("user.dir") +"\\Screenshots\\Passed\\";
	  new File(directory).mkdirs();
	 
	 String destination  = directory + Screenshotpath;;
	try {
		TakesScreenshot scrn = (TakesScreenshot) driver;
			File source = scrn.getScreenshotAs(OutputType.FILE);
			File target = new File(destination);
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot captured");
	} catch (WebDriverException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return destination;
	
	 
 }

}
