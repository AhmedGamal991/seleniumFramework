package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SearchPage;

public class SearchForProdcutsTest extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	
	
	@Test
	public void userCanSearchForProdcuts()
	{
		searchObject = new SearchPage(driver);
		searchObject.searchForProdcuts(productName);
		searchObject.clickOnProdcutDetails();
		Assert.assertTrue(searchObject.prodcutDetailsBreadCrumb.getText().contains(productName));
	}
}
