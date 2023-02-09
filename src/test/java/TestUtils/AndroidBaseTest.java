package TestUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.Utils.AppiumUtils;

import org.pageObject.FormPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest extends AppiumUtils{

	public AndroidDriver driver;
	public FormPage formPage;
	
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws IOException,MalformedURLException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//example//resources//data.properties");
		
		prop.load(fis);
		String ipAddress =prop.getProperty("ipAddress");
		System.out.println(ipAddress);
		//String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
			

			
								
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName(prop.getProperty("AndroidDeviceName")); //emulator
			//options.setDeviceName("Android Device");// real device		
			
			options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\org\\example\\resources\\General-Store.apk");
			 driver = new AndroidDriver(new URL("http://"+ipAddress+":"+port), options);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			 formPage= new FormPage(driver);
	}
	
	


	
	@AfterClass(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
        
		}
	
}
