package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import utlitis.Helper;

public class TestBase extends AbstractTestNGCucumberTests{
	public static WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;


	@BeforeSuite
	@Parameters({ "browser" })
	public void startWebBrowser(@Optional("chrome") String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	@AfterSuite
	public void stopBrowser() {
		driver.quit();
	}
	@AfterMethod
	public void screenShotWhenTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("The Test Is Failed! "+" Taking Screenshot..");
			Helper.captureScreenShot(driver, result.getName());
		}
	}
}
