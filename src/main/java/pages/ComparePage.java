package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase
{

	public ComparePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Clear list')]")
    private WebElement clearListLink;
	
	@FindBy(linkText = "product comparison")
	WebElement comparePage;
	
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div")
    public WebElement noDataLbl;
    
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table")
    private WebElement compareTable;
    
    @FindBy(tagName = "tr")
    public List<WebElement> allRows;
    
    @FindBy(tagName = "td")
    public List<WebElement> allCol;
    
    @FindBy(linkText="Asus N551JK-XO076H Laptop")
    public WebElement firstProductName; 
    
    @FindBy(linkText="Apple MacBook Pro 13-inch")
    public WebElement secodProductName ; 
   
    public void clearCompareList() throws InterruptedException 
    {
    	clickButton(clearListLink);
    	Thread.sleep(2000);
    }
    
    public void CompareProducts() 
    {
    	
    	// Get all Rows
    	System.out.println(allRows.size());
    	// Get data from each Row 
    	for(WebElement row : allRows) 
    	{
    		System.out.println(row.getText() + "\t");
    		for(WebElement col : allCol) 
    		{
    			System.out.println(col.getText()+"\t");
    		}
    	}
    }
    
    public void openComparePage() {
		clickButton(comparePage);
	}
   
}
