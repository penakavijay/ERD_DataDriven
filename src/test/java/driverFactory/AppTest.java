package driverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.FunctionLibrary;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil {
	String input = ".//FileInput/LoginData.xlsx";
	String output = "./FileOutput/DataDrivenResults.xlsx";
	ExtentReports reports;
	ExtentTest logger;

	@Test
	public void starttest() throws Throwable {
		reports = new ExtentReports("./target/Reports/LoginReports.html");

//create object for Excelfileutil
		ExcelFileUtil xl = new ExcelFileUtil(input);
		int rc = xl.rowcount("Login");
//Reporter.log(rc,true);
		for (int i = 1; i <= rc; i++) {
			logger = reports.startTest("validate Login");
			logger.assignAuthor("ponjay");
			String username = xl.getcelldata("Login", i, 0);
			String password = xl.getcelldata("Login", i, 1);
			logger.log(LogStatus.INFO, username + password);
//call login method from function library class

			boolean res = FunctionLibrary.adminlogin(username, password);
			if (res) {
				xl.setcelldata("Login", i, 2, "login success", output);
				xl.setcelldata("Login", i, 3, "pass", output);
				logger.log(LogStatus.PASS, "username and password is valid");
			} else {
				File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File("./screenshot/iteration/" + i + "loginpage.png"));

//if res is false write as login fail into result cell
				xl.setcelldata("Login", i, 2, "Login fail", output);
				xl.setcelldata("Login", i, 3, "fail", output);
				logger.log(LogStatus.FAIL, "username and password are invalid");

			}
			reports.endTest(logger);
			reports.flush();

		}

	}

}
