package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.SwagLabsInventoryPage;
import pom.SwagLabsLoginPage;

	public class SwagLabsInventoryTest {
		
		
		WebDriver driver;
		
		@BeforeMethod()
		
		public void openInventorypage() throws InterruptedException {
			
			driver = Browser.openBrowser("chrome");
			SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
			swagLabsLoginPage.enterUsername("standard_user");
		    swagLabsLoginPage.enterPassword("secret_sauce");
			swagLabsLoginPage.clickOnLogin();
		    Thread.sleep(1000);
		}
		
		
		@Test
		public void addToCart() {
			
			SwagLabsInventoryPage SwagLabsInventoryPage = new SwagLabsInventoryPage(driver);
			SwagLabsInventoryPage.clickOnAddToCart();
			String actualItems = SwagLabsInventoryPage.countItem();
			String expectedItem = "6";
			Assert.assertEquals(actualItems, expectedItem);
			
		}
		
		
		
		
		
		
	
	}
