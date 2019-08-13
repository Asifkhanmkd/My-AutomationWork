package com.nopCommerce.testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopCommerce.utilities.ReadConfig;

public class Base {
	public WebDriver driver;
	ReadConfig read = new ReadConfig();
	String url = read.getUrl();
    String email = read.getEmail();
    String password = read.getPassword();
	public Logger log;
    @Parameters("browser")
	@BeforeClass
	public void setUp(String bro) throws FileNotFoundException {
		
	    PropertyConfigurator.configure(read.getLog4j());
		log = Logger.getLogger("nopCommerce");
		if(bro.equals("chrome")) {
			System.setProperty(read.chrosysProp(), read.getChromePath());
			driver = new ChromeDriver();
			log.info(" Chrome Browser launched");
			
		} else if (bro.equals("firefox"))
		{
			System.setProperty(read.ffoxsysProp(), read.getFireFoxPath());
			driver = new FirefoxDriver();
			log.info(" FireFox Browser launched");
			
		}
		else if (bro.equals("ie"))
			
		{	
			System.setProperty(read.iesysProp(), read.getIePath());
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		
        
		driver.get(url);
		log.info("Navigate to " + url);
		driver.manage().window().maximize();

	} 
    
   
	@AfterClass
	public void TearDown() {
        driver.close();
		log.info("All windows closed");
	}

	
	
     public void takeScreenshot(String tname) throws IOException {
    	
    	
    	File target=new File(System.getProperty("user.dir")+"\\screenshot\\"+tname+".png");
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(source, target);
    }
     
     public String emailGenerate() 
     {
    	 String randEmail=RandomStringUtils.randomAlphabetic(6);
    	  return randEmail;
    	 
    	 
    	 
    	 
    	 
     }
}
