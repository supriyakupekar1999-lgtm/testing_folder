package helper;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utility_Files.ExtentManager_Utility;

import org.testng.annotations.BeforeMethod;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {
	public WebDriver wd;
	public Properties prop;
	public ExtentReports extent;
	public ExtentTest test;
	public static Logger Log=LogManager.getLogger(BaseTest.class);
	
	@BeforeSuite
	  public void setupReport() {
		extent = ExtentManager_Utility.createInstance();
	  }
	
  @BeforeMethod
  public void initialize_n_OpenBrowser(Method method) throws IOException{
	  test = extent.createTest(method.getName());
	  prop=new Properties();
	  FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	  prop.load(fis);
	  
	//simple webDriver setup
	  String browser=prop.getProperty("browser");
	  if(browser.equalsIgnoreCase("chrome")) {
		  wd=new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("firefox")) {
		  wd=new FirefoxDriver();
	  }
	  wd.manage().window().maximize();
	  wd.get(prop.getProperty("url"));
	  Log.info("Browser launched and navigated to URL");
  }
  
  

  @AfterMethod
  public void closeBrowser() {
	  wd.quit();
	  Log.info("Browser closed");
  }

  

  @AfterSuite
  public void flushReport() {
	  extent.flush();//this generate final HTML file
  }

}
