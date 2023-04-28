package com.AppiumFrameworkDesign;

import java.util.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.AppiumFrameworkDesign.BaseTestUtils.BaseTest;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Ppu_tc_endtoend extends BaseTest {

	@Test(dataProvider="getdata", groups = {"smoke"})
	public void CheckouttoHybrid(HashMap<String, String> input) throws Exception
	{
		
		loginpage.taponLoginbtn();
//		loginpage.Enteremailid(input.get("emailid"));
//		loginpage.Enterpassword(input.get("password"));
//		loginpage.ClickonLoginbtn();
//		loginpage.logoutfromapp();
//		String msg = loginpage.validationmsgemail();
//		Assert.assertEquals(msg, "Please enter your email address");
//		String msg1 = loginpage.validationmsgpass();
//		Assert.assertEquals(msg1, "Password is required");
		
		//loginpage.setNameField(input.get("name"));
		//loginpage.setGender(input.get("gender"));
		//loginpage.setcontryselection(input.get("country"));
		//ProductCatalogue productcatalogue = loginpage.submitForm();
		
	}
		@DataProvider
		public Object[][] getdata() throws IOException
		{
			List<HashMap<String, String>> data = getJSONData(System.getProperty("user.dir")+"\\src\\test\\java\\com\\AppiumFrameworkDesign\\testdata\\ppulogin.json");
			//return new Object [] [] {{"Bhargav Shah", "female", "Argentina" }, {"Stuti Shah", "male", "India" }};
			return new Object [] [] {{ data.get(0)}, {data.get(1) }};
		}
		
		//@BeforeMethod(alwaysRun=true)
		public void preSetup()
		{
			loginpage.setActivity();
			
		}
	}