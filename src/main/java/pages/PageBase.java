package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected static WebDriver driver;
	public JavascriptExecutor js ;
	public Select select ; 
	public Actions action ; 
	public Alert alert;
	


	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	protected static void clickButton(WebElement button) {
		button.click();
	}

	protected static void setTextElementText(WebElement textElement, String value) {
		textElement.sendKeys(value);
	}
	public void scrollTo() {
		js.executeScript("scrollBy(0,3000)");
	}
	public void clearText(WebElement element) 
	{
		element.clear();
	}
	public void alertAcept() {
		alert = driver.switchTo().alert();
	}
	

}
