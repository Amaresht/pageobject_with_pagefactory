package com.facebook.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.constants.Extentmanager;
import com.facebook.constants.FBconstatants;
import com.facebook.constants.Xls_Reader;
import com.facebook.pages.Launchingpage;
import com.facebook.pages.Loginpage;
import com.facebook.pages.session.Landingpage;
import com.facebook.testcases.BaaseTest.BaseTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class LoginTest extends BaseTest {
	static String testName="LoginTest";
	@Test(dataProvider="getdata")
	public void doLogin(Hashtable<String, String> data) throws Exception{
		test=ext.startTest("LoginTest");
		System.out.println(data.get("Runmode")+"--"+data.get("Browser")+"--"+data.get("Username")+"--"+data.get("Password")+"--"+data.get("ExpectedResult"));
		if(data.get(FBconstatants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as Runmode is N");
			throw new SkipException("Skipping the test as Runmode is N");
		}
		test.log(LogStatus.INFO, "Login Test is Start");
		test.log(LogStatus.INFO, "Open Browser");
		init(data.get("Browser"));
		Launchingpage launchpage=new Launchingpage(driver,test);
		PageFactory.initElements(driver, launchpage);
	    Loginpage loginpage=launchpage.gotoLoginpage();
	    loginpage.takeScreenshot();
	    Thread.sleep(3000);
	    test.log(LogStatus.INFO,  test.addScreenCapture(Filepath));
	    test.log(LogStatus.INFO, "Loging in");
	   Object page;
	try { 
		page = loginpage.doLogin(data.get("Username"), data.get("Password"));
		 
		String actualResult="";
		if(page!=null)
				{
		   if(page instanceof Landingpage)
			   actualResult="Success";
		   else
			   actualResult="Unsuccesssful";
		   
		   if(!actualResult.equals(data.get("ExpectedResult"))){
			   reportFailure("failureMessage");
		   }
		   test.log(LogStatus.PASS, "Login Test is Pass");
				}
		test.log(LogStatus.FAIL, "Page object is null");
		    
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	}
	@AfterMethod
	public void quit(){
if(ext!=null){
		ext.endTest(test);
	     ext.flush();
	}
	}
	@DataProvider
	
		public  Object[][] getdata(){
		 
			int testCasseStateIndex= 0;
			String SheetName=FBconstatants.TESTDATA_SHEET;
			for(int i=0;i<=xls.getRowCount(SheetName);i++ ){
				
				if (testName.equals(xls.getCellData(SheetName, 0, i))){
					testCasseStateIndex=i;
					break;
				}
			}
			System.out.println("Test Starts From - "+testCasseStateIndex);
			int colStartIndex=testCasseStateIndex+1;
			int col=0;
					while(!xls.getCellData(SheetName, col, colStartIndex).equals("")){
						col++;
					}
					System.out.println("Toatal cols are -"+col);
					System.out.println("Test Starts From - "+testCasseStateIndex);
					int dataStartIndex=testCasseStateIndex+2;
					int row=0;
							while(!xls.getCellData(SheetName, row, dataStartIndex).equals("")){
								row++;
							}
							System.out.println("Toatal rows are -"+row);
							Object[][]data=new Object[row][1];
							Hashtable<String, String> tabl=null;
					for(int i=dataStartIndex;i<(dataStartIndex+row);i++){
						tabl=new Hashtable<String, String>();
						for(int j=0;j<col;j++){
						tabl.put(xls.getCellData(SheetName, j, colStartIndex), xls.getCellData(SheetName, j, i));
							//System.out.print(xls.getCellData("Test Data", j, i)+"---");
						}
						//System.out.println();
						data[i-dataStartIndex][0]=tabl;
					}
					return data;
					
				}

	}


