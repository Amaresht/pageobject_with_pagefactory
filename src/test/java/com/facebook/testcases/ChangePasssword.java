package com.facebook.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.constants.FBconstatants;
import com.facebook.pages.Launchingpage;
import com.facebook.pages.Loginpage;
import com.facebook.pages.session.Landingpage;
import com.facebook.testcases.BaaseTest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class ChangePasssword extends BaseTest{
	String testName="ChangePasssword";
	@Test
	public void ChangePasswordTest(Hashtable<String, String> data) throws Exception{
		test=ext.startTest(testName);
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
	    test.log(LogStatus.INFO, "Loging in");
	    
	
		Object page = loginpage.doLogin(data.get("Username"), data.get("Password"));
		
		
		   if(page instanceof Loginpage)
			   reportFailure("could not login");
		   Landingpage landingPage=(Landingpage)page;
		   landingPage.getMenu();
		   }	
@AfterTest
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
