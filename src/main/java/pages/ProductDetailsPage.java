package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase
{
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="strong.current-item")
	public WebElement productNamebreadCrumb; 

	@FindBy(css="input.button-2.email-a-friend-button")
	WebElement emailFriendBtn ; 

	@FindBy(css="span.price-value-4")
	public WebElement productPricelbl ;

	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishlistBtn ; 

	@FindBy(linkText="Add your review")
	WebElement addReviewLink; 

	@FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[9]/div[2]/button[1]")
	WebElement addToCompareBtn ; 
	
	@FindBy(id="add-to-cart-button-4")
	WebElement addToCartBtn ; 

	public void openSendEmail() 
	{
		clickButton(emailFriendBtn);
	}

	public void openAddReviewPage() 
	{
		clickButton(addReviewLink);
	}

	public void AddProductToWishlist() 
	{
		clickButton(addToWishlistBtn);
	}

	public void AddProductToCompare() 
	{
		clickButton(addToCompareBtn);
	}

	public void AddToCart() 
	{
		clickButton(addToCartBtn);
	}

}
