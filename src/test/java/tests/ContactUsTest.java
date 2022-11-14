package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	ContactUsPage contactUsObject;
	HomePage homeObject;
	String fullName = "Ahmed Gamal";
	String email = "ah.ga@test.com";
	String message = "Hello admin - this is test message";
	
	@Test
	public void userCanContactWithUS() 
	{
		homeObject = new HomePage(driver);
		contactUsObject = new ContactUsPage(driver);
		homeObject.openContactUsPage();
		contactUsObject.contactUs(fullName, email, message);
		Assert.assertTrue(contactUsObject.succssefulMessage.getText().contains("Your enquiry has been successfully"));
	}

}
