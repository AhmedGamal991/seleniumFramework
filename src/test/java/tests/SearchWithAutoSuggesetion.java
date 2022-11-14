package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SearchPage;

public class SearchWithAutoSuggesetion extends TestBase{
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	String firstLaterOfProdcut = "mac";
	
	@Test
	public void userCanSearchWithAutoSuggesetion() throws InterruptedException 
	{
		searchObject = new SearchPage(driver);
		searchObject.searchWithAutoSuggesetion(firstLaterOfProdcut);
		Assert.assertTrue(searchObject.prodcutDetailsBreadCrumb.getText().contains(productName));
	}
}
