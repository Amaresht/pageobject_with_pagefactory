package com.facebook.constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.facebook.pages.Launchingpage;
import com.facebook.pages.Loginpage;
import com.facebook.testcases.BaaseTest.BaseTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class scrnshttest extends BaseTest{
	

	@Test

public void test() throws Exception{
	test=ext.startTest("LoginTest");
	init("Mozilla");
	Launchingpage launchpage=new Launchingpage(driver,test);
	PageFactory.initElements(driver, launchpage);
    Loginpage loginpage=launchpage.gotoLoginpage();
		String title=driver.getTitle();
		Assert.assertEquals(title, title);
		test.log(LogStatus.PASS, "Test passed");
		//loginpage.doLogin("amaresh.tester@gmai.com", "Amresh@2016");
		takeScreenshot();
}
	
	
	@AfterTest
	public void quit(){
		if(ext!=null){
				ext.endTest(test);
			    ext.flush();
			    
			}
}
	
}
