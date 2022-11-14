package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailToFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegiserionPage;

public class EmailToFriendTest extends TestBase {

	HomePage homeObject;
	UserRegiserionPage regsterationObject;
	LoginPage loginObject;
	EmailToFriendPage emailObject;
	ProductDetailsPage prodcutDetailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	String firstLaterOfProdcut = "mac";

	@Test(priority = 1)
	public void userCanRegisterationSuccssefullay() {
		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
		regsterationObject = new UserRegiserionPage(driver);
		regsterationObject.userRegistertion("Ahmed", "Gamal", "ah.g1121114@gmail.com", "123456789");
		Assert.assertTrue(regsterationObject.sucssefulmessage.getText().contains("Your reg"));
	}

	@Test(priority = 2)
	public void userCanSearchWithAutoSuggesetion() throws InterruptedException {
		searchObject = new SearchPage(driver);
		searchObject.searchWithAutoSuggesetion(firstLaterOfProdcut);
		Assert.assertTrue(searchObject.prodcutDetailsBreadCrumb.getText().contains(productName));
	}

	@Test(priority = 3)
	public void registeredUserCanSendEmailToFriend() {
		prodcutDetailsObject = new ProductDetailsPage(driver);
		prodcutDetailsObject.openSendEmail();
		emailObject = new EmailToFriendPage(driver);
		emailObject.emailToFriend("aaabbb@test.com", "Hello My Friend - Check Your inbox");

	}

	@Test(priority = 4)
	public void userCanLogout() {
		regsterationObject.userLogout();
	}
}
