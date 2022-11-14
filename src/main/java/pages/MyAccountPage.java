package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;

	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxt;

	@FindBy(id = "NewPassword")
	WebElement newPasswordTxt;

	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmNewPasswordTxt;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button")
	WebElement changePasswordBtn;

	@FindBy(css = "p.content")
	public WebElement succssefulChangePasswordMessage;

	@FindBy(css = "span.close")
	public WebElement closeCofinrmtionMessage;
	
	@FindBy(xpath = "/html/body/div[6]/div[4]/div[1]/div[3]/ul/li[1]/a")
	public WebElement myAcouuntFoter;
	

	public void registeredUserCanChangePassword(String oldPassword, String newPassword) throws InterruptedException {
		clickButton(changePasswordLink);
		setTextElementText(oldPasswordTxt, oldPassword);
		setTextElementText(newPasswordTxt, newPassword);
		setTextElementText(confirmNewPasswordTxt, newPassword);
		clickButton(changePasswordBtn);
		clickButton(closeCofinrmtionMessage);
		Thread.sleep(2000);
	}

}
