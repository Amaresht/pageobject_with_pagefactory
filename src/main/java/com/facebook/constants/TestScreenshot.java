package com.facebook.constants;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.facebook.testcases.BaaseTest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestScreenshot extends BaseTest{
	@Test
	public void testscn() throws Exception{
		test=ext.startTest("LoginTest");
		init("Mozilla");
		driver.get("https://www.facebook.com/");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("D:\\Selenium\\ExtentReports\\ScreenShots\\a.png"));
		test.log(LogStatus.INFO, test.addScreenCapture("D:\\Selenium\\ExtentReports\\ScreenShots\\a.png"));
	ext.endTest(test);
	ext.flush();
	}

}
