package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegiserionPage;

public class UserRegsterationWithDDTAndProprites extends TestBase {
	HomePage homeObject;
	UserRegiserionPage regsterationObject;
	LoginPage loginObject;
	String firstname = LoadProperties.userData.getProperty("firstname");
	String lastname = LoadProperties.userData.getProperty("lastname");
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");

	@Test(priority = 1)
	public void userCanRegisterationSuccssefullay() {
		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		regsterationObject = new UserRegiserionPage(driver);
		regsterationObject.userRegistertion(firstname,lastname,email,password);
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
		loginObject.userLogin(email, password);
		Assert.assertTrue(regsterationObject.logoutLink.isDisplayed());
	}

}
