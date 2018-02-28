package com.facebook.testcases.BaaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.facebook.basepage.Basepag;
import com.facebook.constants.Extentmanager;
import com.facebook.constants.FBconstatants;
import com.facebook.constants.Xls_Reader;
import com.facebook.pages.common.TopMenu;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest extends Basepag {
	public ExtentReports ext=Extentmanager.geInstance();
	public ExtentTest test;
	public WebDriver driver;
	public TopMenu menu;
	public Xls_Reader xls=new Xls_Reader(FBconstatants.DATA_XLS_PATH);
	public void init(String bType){
		test.log(LogStatus.INFO	, "Opening browser "+bType);
		if(bType.equals("Mozilla")){
			System.setProperty("webdriver.firefox.marionette", FBconstatants.FIREFOX_DRIVER_EXE);
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			test.log(LogStatus.INFO	, bType+" browser successfully ");	
	}
			else if (bType.equals("Chrome")){ 
				System.setProperty("webdriver.chrome.driver",FBconstatants.CHROME_DRIVER_EXE);
				driver=new ChromeDriver();	
				
			
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO	, bType+" browser successfully ");
			
		}
	
}

	public void reportFailure(String failureMessage) throws Exception {
		
		test.log(LogStatus.FAIL, "Fail the Test");
		takeScreenshot();
		Assert.fail(failureMessage);
	}
}

