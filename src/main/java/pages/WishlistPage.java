package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase
{
	public WishlistPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "td.product")
    public WebElement productCell;
    
    @FindBy(css = "h1")
    public WebElement wishlistHeader;
   
    @FindBy(name = "updatecart")
    private WebElement updateWishlistBtn;
    
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[8]/button")
    private WebElement removefromCartCheck;
   
    @FindBy(css = "div.no-data")
    public WebElement EmptyCartLbl;
   
    public void removeProductFromWishlist() {
        clickButton(removefromCartCheck);
        //clickButton(updateWishlistBtn);
    }
}
