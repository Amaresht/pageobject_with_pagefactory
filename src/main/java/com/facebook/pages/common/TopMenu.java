package com.facebook.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.facebook.constants.FBconstatants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TopMenu {
	@FindBy(xpath=FBconstatants.NAVIGATION_LABEL)
	public WebElement navigatinlable;
	@FindBy(xpath=FBconstatants.SETTINGS_LINK)
	public WebElement settings;
	ExtentTest test;
	WebDriver driver;
	public TopMenu(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	public void Logout(){
			
	}
	public void gotoSettings(){
		test.log(LogStatus.INFO, "Clicking on Settings");
		navigatinlable.click();
		settings.click();
		test.log(LogStatus.INFO, "Going to Settingpage");
	}
	

}
