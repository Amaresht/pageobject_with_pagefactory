 package com.facebook.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.facebook.basepage.Basepag;
import com.facebook.pages.Launchingpage;
import com.facebook.pages.Loginpage;
import com.facebook.pages.session.Landingpage;
import com.facebook.pages.session.profilepage;
import com.facebook.testcases.BaaseTest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProfileTest extends BaseTest {
	@Test
	public void testprofile() throws Exception{
		test=ext.startTest("Profile Test");
		test.log(LogStatus.INFO, "Start Profile Test");
	
		init("Mozilla");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Launchingpage lanchpage=new Launchingpage(driver, test);
		PageFactory.initElements(driver, lanchpage);
	     Loginpage loginpage=lanchpage.gotoLoginpage();
	     //loginpage.verifyTile("Facebook Login");
	     Object page=loginpage.doLogin("amaresh.tester@gmail.com", "amresh@2016");
	     if (page instanceof Loginpage) {
	    	 Assert.fail("login is failed");
			
		}else if(page instanceof Landingpage ){
			Landingpage landingpage=(Landingpage)page;
		
	     profilepage profilepage=landingpage.gotoprofile();
	     profilepage.verifyProfle();
	     test.log(LogStatus.PASS, "Test is Passed");
	     profilepage.takeScreenshot();
	     
		}
	     
	}
	@AfterMethod
	public void quit(){
if(ext!=null){
		ext.endTest(test);
	     ext.flush();
	}
	}

}
