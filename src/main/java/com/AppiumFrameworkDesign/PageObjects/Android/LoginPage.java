package com.AppiumFrameworkDesign.PageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.Activity;
import com.AppiumFrameworkDesign.Utils.AndroidGestureActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends AndroidGestureActions {
	
	AndroidDriver driver;
	
	public 	LoginPage (AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement locationselector;
	

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Log In']")
	private WebElement LoginBtn; 
	
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Email address']")
	private WebElement emailaddrestextfield;
	

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Password']")
	private WebElement passwordtextfield;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Login']")
	private WebElement Loginbtns;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[0]")
	private WebElement hamburgermenu;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Logout']")
	private WebElement Logoutbtn;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='YES, LOGOUT']")
	private WebElement YesLogoutbtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Please enter your email address']")
	private WebElement emailmsg;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Password is required']")
	private WebElement passwordmsg;
	

	public void taponLoginbtn() {
		System.out.println("hello");
		locationselector.click();
		LoginBtn.click();
	}
	public void Enteremailid (String emailid)
	{
		emailaddrestextfield.sendKeys(emailid);;		
	}
	public void Enterpassword (String password)
	{
		passwordtextfield.sendKeys(password);;		
	}
	
	public void ClickonLoginbtn() {
		
		Loginbtns.click();
		//return new ProductCatalogue(driver);
}
	public void logoutfromapp() {
		
	hamburgermenu.click();
	Logoutbtn.click();
	YesLogoutbtn.click();
	LoginBtn.click();
	}
	
	public String validationmsgemail() {
		String msg = emailmsg.getAttribute("text");
		return msg;
	}
	
	public String validationmsgpass() {
		String msg = passwordmsg.getAttribute("text");
		return msg;
	}
	
	public void setActivity() {
		//Screen to homepage
		Activity activity = new Activity ("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);

}}
