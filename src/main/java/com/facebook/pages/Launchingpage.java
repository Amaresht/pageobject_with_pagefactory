package com.facebook.pages;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.facebook.basepage.Basepag;
import com.facebook.constants.FBconstatants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Launchingpage extends Basepag {
	ExtentTest test;
	public Launchingpage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		System.out.println("website started");
		//driver.get("http://www.google.com");
		this.driver=driver;
		this.test=test;
	}
	public Loginpage gotoLoginpage(){
		test.log(LogStatus.INFO, "Opening the URL " +FBconstatants.URL);
		driver.get(FBconstatants.URL);
		test.log(LogStatus.PASS, "URL is opend "+FBconstatants.URL);
		Loginpage loginpage=new Loginpage(driver,test);
		PageFactory.initElements(driver, loginpage);
		return loginpage;
	}

}
