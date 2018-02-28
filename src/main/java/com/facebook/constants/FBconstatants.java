package com.facebook.constants;

import org.openqa.selenium.WebElement;

public class FBconstatants {
	//Drivers
	public static final String CHROME_DRIVER_EXE="D:\\Selenium\\chromedriver.exe";
	public static final String FIREFOX_DRIVER_EXE = "E:\\Selenium\\geckodriver.exe";
	
	//URLs
	public static final String URL = "https://www.facebook.com/";

	//Paths
	public static final String HOMEPAGEVERIFY=".//*[@id='js_d']/div/div/div[1]/div[1]/h1/a/span";
	public static final String PROFILRPATH = ".//*[@id='u_0_5']/div[1]/div[1]/div/a";
	public static final String USERNAMEPATH = ".//*[@id='email']";
	public static final String PASSWORDPATH = ".//*[@id='pass']";
	public static final String REPORTPATH = "D:\\Selenium\\ExtentReports\\";
	public static final String HOMEPAGE_URL = null;
	public static final String DATA_XLS_PATH = "C:\\Selenium\\pageobject_with_pagefactory\\Xls\\Data.xlsx";
	public static final String TESTDATA_SHEET="TestData";
	public static final Object RUNMODE_COL = "Runmode";
	public static final String PROFILEPAGE_LINK = null;
	public static final String NAVIGATION_LABEL = ".//*[@id='userNavigationLabel']";
	public static final String SETTINGS_LINK = "//span[contains(text(),'Settings')]";

}
