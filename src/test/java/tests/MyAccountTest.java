package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegiserionPage;

public class MyAccountTest extends TestBase {
	HomePage homeObject;
	MyAccountPage myAccountObject;
	UserRegiserionPage regsterationObject;
	LoginPage loginObject;
	String firstName = "Ahmed";
	String lastName = "Gamal";
	String email = "ah.721121@gmail.com";
	String oldPassword = "123456789";
	String newPassword = "123456";

	@Test(priority = 1)
	public void userCanRegisterationSuccssefullay() {
		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		regsterationObject = new UserRegiserionPage(driver);
		regsterationObject.userRegistertion(firstName, lastName, email, oldPassword);
		Assert.assertTrue(regsterationObject.sucssefulmessage.getText().contains("Your reg"));
	}

	@Test(priority = 2)
	public void registeredUserAllwoChangePassword() throws InterruptedException {
		homeObject = new HomePage(driver);
		homeObject.openMyAccountPage();
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.registeredUserCanChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.succssefulChangePasswordMessage.getText().contains("Password was changed"));
	}

	@Test(priority = 3)
	public void userCanLogout() {

		regsterationObject.userLogout();

	}

	@Test(priority = 4)
	public void registeredCanLogin() {
		homeObject.openloginpage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, newPassword);
		Assert.assertTrue(regsterationObject.logoutLink.isDisplayed());
	}

}
