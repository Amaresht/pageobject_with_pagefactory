package com.facebook.basepage;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.facebook.constants.FBconstatants;
import com.facebook.pages.common.TopMenu;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Basepag {
	public WebDriver driver;
	public TopMenu menu;
	public ExtentTest test;
	Date d=new Date();
	public String ScreenshotFile=d.toString().replace(":", "_").replace(" ","_")+".png";
	public String Filepath=FBconstatants.REPORTPATH+"\\ScreenShots\\"+ScreenshotFile;
	public Basepag(){
		
	}
	public Basepag(WebDriver driver,ExtentTest test){
		
		this.driver =driver;
		this.test=test;
		menu=new TopMenu(driver, test);
		PageFactory.initElements(driver, menu );
		
	}
	
	public String verifyTile(String expTitle){
		test.log(LogStatus.INFO, "Verifying the Title "+expTitle);
		return "";
		
		
	}
	public String verifyText(String locator,String expText){
		return "";
		
		
	}
	/*public boolean isElementpresent(String locator){
		test.log(LogStatus.INFO, "Trying to find element-> "+locator);
		int s=driver.findElements(By.xpath(locator)).size();
		if(s==0){
			test.log(LogStatus.INFO, "Element not found ");
		return false;
		}
		else{
			test.log(LogStatus.INFO, "Element found");
			return true;
		}
		
	}*/
	public boolean isElementpresent(String locator){
		test.log(LogStatus.INFO, "Trying to find element-> "+locator);
		WebElement XpthLocator=driver.findElement(By.xpath(locator));
		if(XpthLocator.isDisplayed()){
			test.log(LogStatus.INFO, "Element found");
			return true;
		
		}else{
				test.log(LogStatus.INFO, "Element not found ");
				return false;
			}
		
	}
	public TopMenu getMenu()
	{
		return menu;
	}
	public void takeScreenshot() throws Exception{
		
		Date d=new Date();
		String ScreenshotFile=d.toString().replace(":", "_").replace(" ","_")+".png";
		String Filepath=FBconstatants.REPORTPATH+"ScreenShots\\"+ScreenshotFile;
	TakesScreenshot srcFile=(TakesScreenshot)driver;
	File ts=srcFile.getScreenshotAs(OutputType.FILE);
		
		try {
		     FileUtils.copyFile(ts, new File(Filepath));
		     //test.log(LogStatus.INFO,  test.addScreenCapture(Filepath));
				
		     
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
