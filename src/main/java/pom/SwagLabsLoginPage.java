package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsLoginPage {
	
	@FindBy (xpath = "//input[@id='user-name']") private WebElement username;
    @FindBy (xpath = "//input[@id='password']") private WebElement password;
    @FindBy (xpath = "//input[@type='submit']") private WebElement login;
    
    
    public SwagLabsLoginPage (WebDriver driver) {
    	
    	PageFactory.initElements(driver, this);
    	
    }
    
    public void enterUsername(String USERNAME) {
    	username.sendKeys(USERNAME);
    }
    
    public void enterPassword(String PASSWORD) {
    	password.sendKeys(PASSWORD);
    }
    
    public void clickOnLogin() {
    	login.click();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
