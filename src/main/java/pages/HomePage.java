package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {
	 

	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		action = new Actions(driver); 
	}

	@FindBy(linkText = "Register")
	WebElement registertionPage;

	@FindBy(linkText = "Log in")
	WebElement loginPage;

	@FindBy(linkText = "My account")
	WebElement myAccountLink;

	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(id="customerCurrency")
	WebElement currencydrl; 
	
	@FindBy(linkText="Computers")
	WebElement ComputerMenu; 
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement NotbooksMenu; 

	public void openRegistertionPage() {
		clickButton(registertionPage);
	}

	public void openloginpage() {
		clickButton(loginPage);
	}

	public void openMyAccountPage() {
		clickButton(myAccountLink);
	}

	public void openContactUsPage() {
		scrollTo();
		clickButton(contactUsLink);

	}
	public void changeCurrency() 
	{
		select = new Select(currencydrl); 
		select.selectByVisibleText("Euro");
	}
	
	public void selectNotebooksMenu() 
	{
		action
		.moveToElement(ComputerMenu)
		.moveToElement(NotbooksMenu)
		.click()
		.build()
		.perform();
	}
	
	
}
