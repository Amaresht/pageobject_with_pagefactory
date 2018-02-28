package com.facebook.pages.session;

import org.openqa.selenium.WebDriver;

import com.facebook.basepage.Basepag;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class profilepage extends Basepag{
	ExtentTest test;
	public profilepage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	public void verifyProfle(){
		
		test.log(LogStatus.INFO, "Verifying profile");
	}
	
	
	

}
