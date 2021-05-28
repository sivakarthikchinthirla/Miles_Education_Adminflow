package com.Miles_admin.tests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Mile_admin_Baseclass.Baseclass;
import com.Miles_admin.PageObjects.LoginRegister;
import com.aventstack.extentreports.ExtentReports;


public class ResetPassword extends Baseclass{
	
	LoginRegister obj = new LoginRegister();
	
	
@Test()

public void startTest() {
	
	System.out.println("Test started");
	logger.info("test started");
}
	
@Test()
public void login() throws InterruptedException, IOException {
	
	Reporter.log("URL opened");
	System.out.println("opened");	
	action.waitforvisibile(LoginRegister.register);
	System.out.println("is displayed");	
	action.click(LoginRegister.register);
	action.sendkeys(LoginRegister.firstname, action.randomAlpha());
	action.sendkeys(LoginRegister.lastname,  action.randomAlpha());
	action.sendkeys(LoginRegister.phone, "9505699463");
	Reporter.log("phone");
    action.captureScreenShot(driver, "submit"); 
    
}
}