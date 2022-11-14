package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegiserionPage extends PageBase {

	public UserRegiserionPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "gender-male")
	WebElement radioBtn;

	@FindBy(id = "FirstName")
	WebElement fnTxtBox;

	@FindBy(id = "LastName")
	WebElement lnTxtBox;

	@FindBy(id = "Email")
	WebElement emailTxtBox;

	@FindBy(id = "Password")
	WebElement passwordTxtBox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox;

	@FindBy(id = "register-button")
	WebElement rigeisterBtn;

	@FindBy(css = "div.result")
	public WebElement sucssefulmessage;

	@FindBy(linkText = "Log out")
	public WebElement logoutLink;

	public void userRegistertion(String firstName, String lastName, String email, String password) {
		clickButton(radioBtn);
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		clickButton(rigeisterBtn);
	}

	public void userLogout() {
		clickButton(logoutLink);
	}

}
