package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class Emppage {
	WebDriver driver;
	//constructor to override webdriver methods
	public Emppage(WebDriver driver) {
		this.driver=driver;
	}
	//define repository
	@FindBy(xpath="//b[normalize-space()='PIM']")
	WebElement pim;
	@FindBy(xpath="//input[@name='btnAdd']")
	WebElement add;
	@FindBy(xpath="//input[@name='firstName']")
	WebElement fname;
	@FindBy(xpath="//input[@name='middleName']")
	WebElement mname;
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lname;
	@FindBy(xpath="//input[@name='employeeId']")
	WebElement beforeeid;
	@FindBy(xpath="//input[@value='Save']")
	WebElement save;
	@FindBy(xpath="//input[@id='personal_txtEmployeeId']")
	WebElement aftereid;
	
	
	public boolean VerifyAddEmp(String fname,String mname, String lname)throws Throwable {
		Actions ac= new Actions(driver);
		ac.moveToElement(this.pim).click().perform();
		ac.moveToElement(this.add).click().perform();
		this.fname.sendKeys(fname);
		this.mname.sendKeys(mname);
		this.lname.sendKeys(lname);
		String expectedeid=this.beforeeid.getAttribute("value");
		ac.moveToElement(this.save).click().perform();
		String actualeid=this.aftereid.getAttribute("value");
		if (expectedeid.equals(actualeid)) {
			Reporter.log("eid is matching login success"+expectedeid+"  "+actualeid,true);
			return true;
			
		}
		else {
			Reporter.log("eid not matching login fail"+expectedeid+"  "+actualeid,true);
			return false;
		}
		
		
		
	}
	
	
	
	

}
