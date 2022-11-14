package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegiserionPage;

public class UserRegsterationWithDDExcle extends TestBase {
	HomePage homeObject;
	UserRegiserionPage regsterationObject;
	LoginPage loginObject;

	@DataProvider(name = "ExcleData")
	public static Object[][] userDataFromExcel() throws IOException 
	{
		ExcelReader er = new ExcelReader();
		return er.getExelDate();
	}

	@Test(priority = 1, dataProvider = "ExcleData")
	public void userCanRegisterationSuccssefullay(String firstname , String lastname , String email , String password) {
		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		regsterationObject = new UserRegiserionPage(driver);
		regsterationObject.userRegistertion(firstname, lastname, email, password);
		Assert.assertTrue(regsterationObject.sucssefulmessage.getText().contains("Your reg"));
		regsterationObject.userLogout();
		homeObject.openloginpage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email,password);
		Assert.assertTrue(regsterationObject.logoutLink.isDisplayed());
		regsterationObject.userLogout();
	}

}
