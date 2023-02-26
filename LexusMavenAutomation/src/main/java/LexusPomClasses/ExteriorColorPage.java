package LexusPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExteriorColorPage {
	
	
	Actions act; 
	
	@FindBy(xpath = "//a/img[@data-code = '02ZG']")
	private WebElement extColor;
	
	@FindBy(xpath = "//div[@id = 'CoreConfiguratorRegion']//span")
	private WebElement verifyExtC; 
	
	@FindBy(xpath = "//a[contains(text(),'Next: Interior')]")
	private WebElement nextInt;

	// Constructor - Public - WebElement Initialization
	public ExteriorColorPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);		
			act = new Actions(driver);
		}
	//Methods - Public - Web Elements action 
	public String verifyExtColor()
	{
		String actualtext = verifyExtC.getText(); 
		return actualtext;
	}
	
	public void selectExtColor()
	{
		act.moveToElement(extColor).click().build().perform();
	}
	
	public boolean testNextButton()
	{
		boolean ExtNext = nextInt.isEnabled(); 
		return ExtNext; 
	}
	public void clickNext()
	{
		nextInt.click();
	}
}
