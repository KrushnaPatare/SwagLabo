package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabsLoginPage;
import utility.BaseClass;
import utility.ExtentReport;
import utility.Parameterization;

@Listeners(utility.Listeners.class)
public class SwagLabsLoginTest extends BaseClass {
	
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReport() {
		reports = ExtentReport.createExtentReports();
		reports.setSystemInfo("Test Suite", "Regression Test");
		reports.setSystemInfo("Test Performed By", "Krushna Patare");
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String browser) {
		
		 driver = Browser.openBrowser(browser); 
	}
	
	@Test ()
	public void loginWithValidCredentials() throws InterruptedException, EncryptedDocumentException, IOException {
	
		test = reports.createTest("loginWithValidCredentials");
		
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		
		String user = Parameterization.getExelData("credentials",0,0);
		swagLabsLoginPage.enterUsername(user);
	   
	    String pass = Parameterization.getExelData("credentials",1,0);
	    swagLabsLoginPage.enterPassword(pass);
	  
		swagLabsLoginPage.clickOnLogin();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals( actualUrl, expectedUrl);
		
	
}

	@Test ()
	public void loginWithInvalidUsername() throws InterruptedException, EncryptedDocumentException, IOException {
	
		test = reports.createTest("loginWithInvalidUsername");
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
	
		swagLabsLoginPage.enterUsername("masterpiece");
	
	    swagLabsLoginPage.enterPassword("secret_sauce");
		
		swagLabsLoginPage.clickOnLogin();
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals( actualUrl, expectedUrl);
		
}
	
	
	@Test (dependsOnMethods= {"loginWithInvalidUsername"})
	public void loginWithInvalidPassword() throws InterruptedException, EncryptedDocumentException, IOException {
	
		test = reports.createTest("loginWithInvalidPassword");
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		Thread.sleep(2000);
		swagLabsLoginPage.enterUsername("standard_user");
	    Thread.sleep(2000);
	    swagLabsLoginPage.enterPassword("secret_sauc");
		Thread.sleep(2000);
		swagLabsLoginPage.clickOnLogin();
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals( actualUrl, expectedUrl);
		
}
	
	@AfterMethod
	public void publishResult (ITestResult result) {
		
		if(result.getStatus()==ITestResult.SUCCESS)
        {
        	test.log(Status.PASS,result.getName());
		}
        
		else if(result.getStatus()==ITestResult.FAILURE) 
		{
			test.log(Status.FAIL, result.getName());
		}
		
		else if(result.getStatus()==ITestResult.SKIP)
		
		{
			test.log(Status.SKIP, result.getName());
		}
		
		driver.close();
			
	}

	@AfterTest
	public void createReport() {
		
		reports.flush();
		
	}
	

	
}
