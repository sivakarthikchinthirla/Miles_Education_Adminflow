package com.Miles_admin.tests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Mile_admin_Baseclass.Baseclass;
import com.Miles_admin.PageObjects.LoginRegister;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Adminlogin extends Baseclass{
		

@Test(description="Performs an successful login")
public void login() throws InterruptedException, IOException {
	
	Reporter.log("URL opened");
	System.out.println("opened");	
	action.waitforvisibile(LoginRegister.register);
	System.out.println("is displayed");	
	action.click(LoginRegister.register);
	action.sendkeys(LoginRegister.firstname, action.randomAlpha());
	action.sendkeys(LoginRegister.lastname,  action.randomAlpha());
	action.sendkeys(LoginRegister.phone, "9505699463");
	
    action.captureScreenShot(driver, "submit"); 
    
}

}
