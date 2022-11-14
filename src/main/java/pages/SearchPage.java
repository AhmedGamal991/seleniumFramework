package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "small-searchterms")
	WebElement searchTxtBox;
	
	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement prodcutDetailes;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> listOfSuggisetion;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/ul/li[4]/strong")
	public WebElement prodcutDetailsBreadCrumb;
	
	public void searchForProdcuts(String productName)
	{
		setTextElementText(searchTxtBox, productName);
		clickButton(searchBtn);
	}
	
	public void clickOnProdcutDetails() {
		clickButton(prodcutDetailes);
	}
	public void searchWithAutoSuggesetion(String firstLaterOfProdcut) throws InterruptedException {
		setTextElementText(searchTxtBox, firstLaterOfProdcut);
		Thread.sleep(2000);
		listOfSuggisetion.get(0).click();
	}
}
