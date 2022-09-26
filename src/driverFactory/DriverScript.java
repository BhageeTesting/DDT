package driverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.FunctionLibrary;
import config.AppUtil;

public class DriverScript extends AppUtil {
	String inputpath="F:\\secondclass\\DDT_Framework\\TestInput\\Orange.xlsx";
	String outputpath="F:\\secondclass\\DDT_Framework\\TestOutput\\Dataresults.xlsx";
	@Test
	public void startTest() throws Throwable{
		utilities.ExcelFileUtil xl= new utilities.ExcelFileUtil(inputpath);
		//no of rows
		int rc=xl.getRow("login");
		//no of coloumns
		int cc=xl.getcoloumn("login");
		Reporter.log("no of rows: "+rc+"no of cells"+cc);
		
		//get all data
		for (int i = 1; i <=rc; i++) {
			String user=xl.getcelldata("login", i, 0);
			String pass=xl.getcelldata("login", i, 1);
			//call login method from function library class
			boolean res=FunctionLibrary.verifylogin(user, pass);
			if (res) {
				//if res is true write results and status cell
				xl.SetCellValue("login", i, 2, "Login pass", outputpath);
				xl.SetCellValue( "login", i, 3, "pass",outputpath);
				
			}
			else {
				File screen=((TakesScreenshot)con).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
				FileUtils.copyFile(screen, new File("./screenshot/iteration/"+i+"  "+"Orange.png"));
				xl.SetCellValue( "login", i, 2, "login fail",outputpath);
				xl.SetCellValue("login", i, 3, "fail",outputpath);
			}	
		}	
	}
}
