
package LexusPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PincodePage {
	
	Actions act; 
	
	@FindBy(xpath = "//input[@name = 'zip']")
	private WebElement zip;
	
	@FindBy(xpath = "//button[contains(text(),'Enter')]")
	private WebElement searchZip; 
	
	@FindBy(xpath = "(//a[@tabindex = '0']/span)[11]")
	private WebElement mycar;
	
	@FindBy(xpath = "(//div[@class = 'grid-right'])[3]//h2")
	private WebElement mycartitle;
	
	// Constructor - Public - WebElement Initialization
	public PincodePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);		
			act = new Actions(driver);
		}
	//Methods - Public - Web Elements action 
	public boolean testPinInput()
	{
		boolean result1 = zip.isEnabled();
		return result1;
	}
	
	public void addPinCode()
	{
		act.moveToElement(zip).click().sendKeys("91801").build().perform(); 
	}
	
	public boolean testSearchPin()
	{
		boolean result2 = searchZip.isEnabled();
		return result2; 
	}
	
	public void clickSearchPin()
	{
		searchZip.click();
	}
	
	public String verifyCarTitle()
	{
		String result3 = mycartitle.getText(); 
		return result3; 
	}
	
	public void scrollToMyCar()
	{
		act.moveToElement(mycar).click().build().perform();
	}

}
