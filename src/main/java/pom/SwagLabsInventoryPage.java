package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsInventoryPage {
	
		@FindBy (xpath = "//button[text()='Open Menu']") private WebElement openMenuButton;
		@FindBy (xpath = "//a[@class='shopping_cart_link']") private WebElement cartLink;
		@FindBy (xpath = "//select[@class='product_sort_container']") private WebElement sortDropdown;
		@FindBy (xpath = "(//button[text()='Add to cart'])") private List<WebElement> totalAddToCartButton;
		@FindBy (xpath = "(//button[text()='Remove'])[1]") private WebElement removeButton;
		@FindBy (xpath = "//a[text()='Twitter']") private WebElement twitterButton;
		@FindBy (xpath = "//a[text()='Facebook']") private WebElement facebookButton;
		@FindBy (xpath = "//a[text()='LinkedIn']") private WebElement linkedinButton;
		@FindBy (xpath = "//span[@class='shopping_cart_badge']") private WebElement cartItemCounter;
		
	
		
		public SwagLabsInventoryPage (WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		
		
		public void clickOnOpenMenuButton() {
			
			openMenuButton.click();
		}
		
		public void clickOnSortDropdown() {
				
			sortDropdown.click();
			}
		
		public void clickOncartLink() {
			
			sortDropdown.click();
			}
		
		public String countItem() {
			
			String Items = cartItemCounter.getText();
			return Items;
		}
		
		public void clickOnAddToCart() {
			
			for(int i=5;i>=0;i--)
			{
				WebElement addToCart = totalAddToCartButton.get(i);
				addToCart.click();
			}
			
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
