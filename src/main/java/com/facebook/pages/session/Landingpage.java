package com.facebook.pages.session;

import org.apache.regexp.recompile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.basepage.Basepag;
import com.facebook.constants.FBconstatants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Landingpage extends Basepag {
	ExtentTest test;
	@FindBy(xpath=FBconstatants.PROFILRPATH)
	public WebElement profilelink;
	
	public Landingpage(WebDriver driver,ExtentTest test){
		
		this.driver=driver;
		this.test=test;
		
	}
	public profilepage gotoprofile(){
		test.log(LogStatus.INFO, "Going to profile page");
		profilelink.click();
		profilepage profilepage=new profilepage(driver,test);
		PageFactory.initElements(driver, profilepage);
		return profilepage;
		//return PageFactory.initElements(driver, profilepage.class);
	}
	
	

}
