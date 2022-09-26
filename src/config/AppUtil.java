package config;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
	public static WebDriver con;
	public static Properties p;
	@BeforeTest
	public static void setup() throws Throwable{
		p= new Properties();
		p.load(new FileInputStream("F:\\secondclass\\DDT_Framework\\PropertyFile\\Envirnoment.properties"));
		if (p.getProperty("Browser").equalsIgnoreCase("chrome")) {
			con=new ChromeDriver();
			con.manage().window().maximize();
			con.manage().deleteAllCookies();
			
		}
		else if (p.getProperty("Browser").equalsIgnoreCase("firefox")) {
			con= new FirefoxDriver();
			
		}
		else {
			System.out.println("Browser is not matching");
		}
		
		
		
	}
	@AfterTest
	public static void teardown() throws Throwable{
		
		con.close();
	}

}
