package com.Mile_admin_Baseclass;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Miles_admin.utilities.ReadConfig;
import com.Miles_admin.utilities.Readme;
import com.beust.jcommander.Parameter;

public class Baseclass {

	ReadConfig config = new ReadConfig();
	public Readme action;
	public String baseurl = config.geturl();

	public static WebDriver driver;
	public static Logger logger;

	@BeforeMethod
	@Parameters("Browser")
	public void setup(String browser) {

		if (browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", config.getFirefoxpath());
			driver = new FirefoxDriver();
			Reporter.log("Driver Closed After Testing");
			logger = Logger.getLogger("Miles_Education_admin");
			PropertyConfigurator.configure("log4j.properties");
			action = new Readme(driver);
			driver.manage().window().maximize();
			driver.get(baseurl);
		}

		else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", config.getIEpath());
			driver = new InternetExplorerDriver();
			Reporter.log("Driver Closed After Testing");
			logger = Logger.getLogger("Miles_Education_admin");
			PropertyConfigurator.configure("log4j.properties");
			action = new Readme(driver);
			driver.manage().window().maximize();
			driver.get(baseurl);
		}

		else if (browser.equalsIgnoreCase("GC")) {
			System.setProperty("webdriver.chrome.driver", config.getchromepath());
			driver = new ChromeDriver();
			Reporter.log("Driver Closed After Testing");
			logger = Logger.getLogger("Miles_Education_admin");
			PropertyConfigurator.configure("log4j.properties");
			action = new Readme(driver);
			driver.manage().window().maximize();
			driver.get(baseurl);
		} else if (browser.equalsIgnoreCase("ME")) {
			System.setProperty("webdriver.edge.driver", config.getEdgepath());
			driver = new EdgeDriver();
			Reporter.log("Driver Closed After Testing");
			logger = Logger.getLogger("Miles_Education_admin");
			PropertyConfigurator.configure("log4j.properties");
			action = new Readme(driver);
			driver.manage().window().maximize();
			driver.get(baseurl);
		}

	}

	@AfterMethod
	public void Teardown() {
		driver.quit();
	}

	

}
