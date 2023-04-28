package com.AppiumFrameworkDesign.BaseTestUtils;
	
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.AppiumFrameworkDesign.PageObjects.Android.LoginPage;
import com.AppiumFrameworkDesign.Utils.AppiumUtils;
import java.util.Properties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
public class BaseTest extends AppiumUtils {
	

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public LoginPage loginpage;
	
	@BeforeClass
	public void ConfigureAppium() throws Exception {
		
		service = new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")).withAppiumJS(new File("C:\\Users\\bhargavs\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
				
			service.start();
			
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\AppiumFrameworkDesign\\resources\\data.properties");
			prop.load(fis);
			//String ipAddress = System.getProperty("ipAddress")!= null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
			//String ipAddress = prop.getProperty("ipAddress");
			//String port = prop.getProperty("port");
			//service = startAppiumServer(ipAddress, Integer.parseInt(port));
			
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName(prop.getProperty("AndroidDeviceName"));
			//options.setDeviceName("Android Device");
			//options.setChromedriverExecutable("C:\\Users\\bhargavs\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
			//options.setApp("C:\\Users\\bhargavs\\eclipse-workspace\\apium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
			options.setApp("C:\\Users\\bhargavs\\Downloads\\ppu-release-v33.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("–session-override",true);
			
			//driver = new AndroidDriver(service.getUrl(), options);
			driver = new AndroidDriver(new URL ("http://127.0.0.1:4723"), options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			loginpage = new LoginPage(driver);
	}
	
	@AfterClass
	public void teardown() throws Exception {
		
		Thread.sleep(3000);
		driver.quit();
		service.stop();
	}
}
