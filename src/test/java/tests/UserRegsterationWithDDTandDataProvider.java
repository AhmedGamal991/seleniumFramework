package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegiserionPage;

public class UserRegsterationWithDDTandDataProvider extends TestBase {
	HomePage homeObject;
	UserRegiserionPage regsterationObject;
	LoginPage loginObject;

	@DataProvider(name = "userData")
	public static Object[][] userData() {
		return new Object[][] { 
				{ "Ahmed", "Gamal", "test12@test.com", "123456789" },

				{ "Ahmed", "El-Masri", "test21@test.com", "123456789" }
	};
	}

	@Test(priority = 1, dataProvider = "userData")
	public void userCanRegisterationSuccssefullay(String fName, String lName, String email, String passwor) {
		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		regsterationObject = new UserRegiserionPage(driver);
		regsterationObject.userRegistertion(fName, lName, email, passwor);
		Assert.assertTrue(regsterationObject.sucssefulmessage.getText().contains("Your reg"));
		regsterationObject.userLogout();
		homeObject.openloginpage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email,passwor);
		Assert.assertTrue(regsterationObject.logoutLink.isDisplayed());
		regsterationObject.userLogout();
	}

}
