package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "FullName")
	WebElement fullNameTxtBos;

	@FindBy(id = "Email")
	WebElement emailTxtBos;

	@FindBy(id = "Enquiry")
	WebElement messageTxtBos;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button")
	WebElement submitBtn;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]")
	public WebElement succssefulMessage;
	
	public void contactUs(String fullName, String email, String message) 
	{
		setTextElementText(fullNameTxtBos, fullName);
		setTextElementText(emailTxtBos, email);
		setTextElementText(messageTxtBos, message);
		clickButton(submitBtn);
	}
}
