package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage {

@FindBy(xpath = "//*[@id=\"mi_a_customers\"]/a")
WebElement objcustomerlink;	
@FindBy(xpath = "//*[@id=\"ewContentColumn\"]/div[3]/div[1]/div[1]/div[1]/div/a")	
	WebElement objaddicon;
@FindBy(xpath = "//*[@id=\"x_Customer_Number\"]")
	WebElement  objcustomernum;
@FindBy(xpath = "//*[@id=\"x_Customer_Name\"]")	
	WebElement objcustomername;
@FindBy(xpath = "//*[@id=\"x_Address\"]")
	WebElement objaddress;
@FindBy(xpath = "//*[@id=\"x_City\"]")
	WebElement objcity;
@FindBy(xpath = "//*[@id=\"x_Country\"]")
WebElement objcountry;	
@FindBy(xpath = "//*[@id=\"x_Contact_Person\"]")
WebElement objcontactperson;	
@FindBy(xpath = "//*[@id=\"x_Phone_Number\"]")
WebElement objphnnum;
@FindBy(xpath = "//*[@id=\"x__Email\"]")
WebElement objmail;
@FindBy(xpath = "//*[@id=\"x_Mobile_Number\"]")
WebElement objmblnum;
@FindBy(xpath = "//*[@id=\"x_Notes\"]")
WebElement objnotes;
@FindBy(xpath = "//*[@id=\"btnAction\"]")
WebElement objaddbtn;
@FindBy(xpath = "/html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")
WebElement objcnfrmokbtn;
@FindBy(xpath = "/html/body/div[17]/div[2]/div/div[4]/div[2]/button")
WebElement objalertbtn;
@FindBy(xpath = "//*[@id=\"ewContentColumn\"]/div[2]/div[2]/div/button")
WebElement objsearchpanel;
@FindBy(xpath = "//*[@id=\"psearch\"]")
WebElement objsearchtextbox;
@FindBy(xpath = "//*[@id=\"btnsubmit\"]")
WebElement objsearchbtn;
@FindBy(xpath = "//Table[@class='table ewTable']")
WebElement  webtable;

public boolean add_customer(String customername, String Address, String city, String Country, String contactperson, String phonenum, 
		String email, String Mobilenumber,  String notes)throws Throwable {
	objcustomerlink.click();
	objaddicon.click();
	String exp_num=objcustomernum.getAttribute("value");
	objcustomername.sendKeys(customername);
	objaddress.sendKeys(Address);
	objcity.sendKeys(city);
	objcountry.sendKeys(Country);
	objcontactperson.sendKeys(contactperson);
	objphnnum.sendKeys(phonenum);
	objmail.sendKeys(email);
	objmblnum.sendKeys(Mobilenumber);
	objnotes.sendKeys(notes);
	objaddbtn.click();
	objcnfrmokbtn.click();
	Thread.sleep(3000);
	objalertbtn.click();
	if(!objsearchtextbox.isDisplayed())
		objsearchpanel.click();
		objsearchtextbox.clear();
		objsearchtextbox.sendKeys(exp_num);
		objsearchbtn.click();
		Thread.sleep(3000);
	String act_num=webtable.getText();
	Thread.sleep(3000);
	if (exp_num.equals(act_num)) {
		Reporter.log("customer number matching"+"   "+exp_num+"  "+act_num);
		return true;
	} else {
		Reporter.log("customer number not matching"+"   "+exp_num+"  "+act_num);
		return false;
	}
	
	
	
	
	
			
	
	
	
}





}
