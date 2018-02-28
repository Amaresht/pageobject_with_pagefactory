package com.facebook.pages;

import org.apache.regexp.recompile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.basepage.Basepag;
import com.facebook.constants.FBconstatants;
import com.facebook.pages.session.Landingpage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Loginpage extends Basepag {
	ExtentTest test;
	@FindBy(xpath=FBconstatants.USERNAMEPATH)
	public WebElement email;
	@FindBy(xpath=FBconstatants.PASSWORDPATH)
	public WebElement password;
		public Loginpage(WebDriver driver,ExtentTest test) {
			this.driver=driver;
			this.test=test;
			// TODO Auto-generated constructor stub
			
		}
		public Object doLogin(String usname,String passwd) throws Exception{
			test.log(LogStatus.INFO, "Logging in "+usname+"--"+passwd);
			email.sendKeys(usname);
			password.sendKeys(passwd);
			password.sendKeys(Keys.ENTER);
			takeScreenshot();
			isElementpresent(FBconstatants.HOMEPAGEVERIFY);
			boolean loginSucsess=true;
			if (loginSucsess) {
				test.log(LogStatus.INFO, "Logging is success");
				Landingpage landingpage=new Landingpage(driver, test);
				PageFactory.initElements(driver, landingpage);
				return landingpage;
			}else{
				test.log(LogStatus.INFO, "Logging not success");
				Loginpage loginpage=new Loginpage(driver, test);
				PageFactory.initElements(driver, loginpage);
			return loginpage;
			}
		}
		

}
