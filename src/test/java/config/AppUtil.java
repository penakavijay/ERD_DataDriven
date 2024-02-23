package config;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil {
public static Properties p;
public static WebDriver  driver;
@BeforeTest
public static void setup() throws Throwable, Throwable {
	p=new  Properties();
	p.load(new FileInputStream("./PropertyFile/Login.properties"));
	if (p.getProperty("Browser").equalsIgnoreCase("chrome")) {
		driver=new  ChromeDriver();
		driver.manage().window().maximize();
		
	}else if (p.getProperty("Browser").equalsIgnoreCase("Firefox")) {
		driver=new  FirefoxDriver();
	} else  {
	Reporter.log("Browser is not matching",true)	;
	}
	
}
	
@AfterTest
public static void teardown() {
	
	driver.quit();
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}