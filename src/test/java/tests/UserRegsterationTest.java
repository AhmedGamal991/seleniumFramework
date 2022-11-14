package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegiserionPage;

public class UserRegsterationTest extends TestBase {
	HomePage homeObject;
	UserRegiserionPage regsterationObject;
	LoginPage loginObject;

	@Test(priority = 1)
	public void userCanRegisterationSuccssefullay() {
		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		regsterationObject = new UserRegiserionPage(driver);
		regsterationObject.userRegistertion("Ahmed", "Gamal", "ah.g112114@gmail.com", "123456789");
		Assert.assertTrue(regsterationObject.sucssefulmessage.getText().contains("Your reg"));
	}

	@Test(dependsOnMethods = "userCanRegisterationSuccssefullay")
	public void userCanLogout() {
		regsterationObject.userLogout();
	}

	@Test(dependsOnMethods = "userCanLogout")
	public void registeredCanLogin() {
		homeObject.openloginpage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin("ah.g112114@gmail.com", "123456789");
		Assert.assertTrue(regsterationObject.logoutLink.isDisplayed());
	}

}
