package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailToFriendPage extends PageBase {

	public EmailToFriendPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(id = "FriendEmail")
WebElement friendEmailTxt;

@FindBy(id = "PersonalMessage")
WebElement messageTxt;

@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button")
WebElement sendMessageBtn;

	public void emailToFriend(String friendEmail, String messageToEmail) 
	{
		setTextElementText(friendEmailTxt, friendEmail);
		setTextElementText(messageTxt, messageToEmail);
		clickButton(sendMessageBtn);
	}
}
