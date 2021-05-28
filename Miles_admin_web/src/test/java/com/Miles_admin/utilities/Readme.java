package com.Miles_admin.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;




public class Readme {



	public WebDriver driver ;
	 public WebDriverWait wait;

	public  Readme(WebDriver driver) {

		this.driver= driver;
		PageFactory.initElements(driver, this);

	}



	public void waitforvisibile(String w) {


		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(w)));

	}

	public void click(String e) {

		try {
			driver.findElement(By.xpath(e)).click();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	}

	public void clear(String r) {
		try {
			driver.findElement(By.xpath(r)).clear();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void isvisibile(String v) {

		try {
			driver.findElement(By.xpath(v)).isDisplayed();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void sendkeys(String s,String txt) {

		try {
			driver.findElement(By.xpath(s)).sendKeys(txt);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void dropdown(String s,String v) {

		WebElement obj = driver.findElement(By.xpath(s)); 
		Select selection =new Select(obj);


		List<WebElement> options= selection.getOptions(); 

		for(WebElement option :options) {
         option.getText();

		} 

		selection.selectByVisibleText(v);
	}
	
	public String randomAlpha() {

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 7;
		for(int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());


			char randomChar = alphabet.charAt(index);

			sb.append(randomChar);
		}

		String randomString = sb.toString();
		randomString.trim();
		System.out.println("Random String is: " + randomString);
		return randomString;

	}

		public void randomAlphaNum() {

		String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 10;
		for(int i = 0; i < length; i++) {
			int index = random.nextInt(alphaNumeric.length());
			char randomChar = alphaNumeric.charAt(index);
			sb.append(randomChar);
		}

		String Alphanum = sb.toString();
		System.out.println("Random String is: " + Alphanum);

	}



public void randomNum() {

	
	String numbers = "0123456789";
	StringBuilder sb = new StringBuilder();
	Random random = new Random();
	int length = 10;
	for(int i = 0; i < length; i++) {
		int index = random.nextInt(numbers.length());
		char randomChar = numbers.charAt(index);
		sb.append(randomChar);
	}

	String Numbers = sb.toString();
	System.out.println("Random String is: " + Numbers);

}

public String readText(By elementLocation) {
    waitVisibility(elementLocation);
    return driver.findElement(elementLocation).getText();
}


public void waitVisibility(By by){
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
}

public String captureScreenShot(WebDriver driver, String tname) throws IOException {
	String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.SS").format(new Date());
	TakesScreenshot scrn = (TakesScreenshot) driver;
	File source = scrn.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" +tname + timestamp+".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot captured");
	return tname;
}

}





