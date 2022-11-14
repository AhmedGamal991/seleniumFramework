package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegiserionPage;
import tests.TestBase;

public class UserRegistration extends TestBase {
	HomePage homeObject;
	UserRegiserionPage regsterationObject;
	LoginPage loginObject;

	@Given("the user in home page")
	public void the_user_in_home_page() {
		homeObject = new HomePage(driver);
		homeObject.openRegistertionPage();
	}

	@When("he click on register link")
	public void he_click_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*
	 * * @When("he entered the correct data") public void
	 * he_entered_the_correct_data() { regsterationObject = new
	 * UserRegiserionPage(driver); regsterationObject.userRegistertion("Ahmed",
	 * "Gamal", "ah.g8532114@gmail.com", "123456789"); }
	 */

	@When("he entered {string},{string},{string},{string}")
	public void he_entered(String firstname, String lastname, String email, String password)
	{
		regsterationObject = new UserRegiserionPage(driver);
		regsterationObject.userRegistertion(firstname, lastname, email, password);
	}

	@Then("the registration page displayed successfuly")
	public void the_registration_page_displayed_successfuly() {
		regsterationObject.userLogout();
	}

}
