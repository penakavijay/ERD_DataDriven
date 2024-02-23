package commonFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Reporter;

import config.AppUtil;

public class FunctionLibrary extends AppUtil {
public static boolean adminlogin(String username , String password) throws Throwable {
	
	driver.get(p.getProperty("url"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath(p.getProperty("objresetbutton"))).click();
	driver.findElement(By.xpath(p.getProperty("objuser"))).sendKeys(username);
	driver.findElement(By.xpath(p.getProperty("objpass"))).sendKeys(password);
	driver.findElement(By.xpath(p.getProperty("objlogin"))).click();
	Thread.sleep(4000);
	String expected="dashboard";
	String actual=driver.getCurrentUrl();
	if (actual.contains(expected)) {
		Reporter.log("valid username and password"+expected+actual,true);
		Thread.sleep(2000);		driver.findElement(By.xpath(p.getProperty("objlogout"))).click();
		return true;
	} else {
String error=driver.findElement(By.xpath(p.getProperty("objmessage"))).getText();
Thread.sleep(3000);
driver.findElement(By.xpath(p.getProperty("objokbutton"))).click();
Reporter.log(error+expected+actual);
	}
	return false;
	
}
	
	
	
	
	
	
	
}
