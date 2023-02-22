package barclayPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	private Actions act; 
	private String mainpage;
	
	//Variable - private Webelements 
	
	@FindBy(xpath = "//a[text() ='Other Barclays sites']")
	private WebElement OtherSites; 
	
	@FindBy(xpath = "//a[contains(text(),'Personal Banking')]")
	private WebElement PersonalBanking; 
	
	@FindBy(xpath = "//a[contains(text(),'Business Banking')]")
	private WebElement BusinessBanking; 
	
	@FindBy(xpath = "//a[contains(text(),'Corporate Banking')])[1]")
	private WebElement CorporateBanking; 
	
	@FindBy(xpath = "//a[contains(text(),'Investment Bank')])[1]")
	private WebElement InvestW; 
	
	@FindBy(xpath ="//a[text() = 'Investors']")
	private WebElement TabInvest; 
	
	@FindBy(xpath = "//a[contains(text(),'Share price ')]")
	private WebElement SharePrice; 
	
	@FindBy(xpath = "//button[contains(text(),'More Stories')]")
	private WebElement MoreStories; 

	//Constructor for WebElement Initialization (public) 
	public Homepage (WebDriver driver)
	{
		PageFactory.initElements(driver,this); 
		act = new Actions(driver);
		mainpage = driver.getWindowHandle();
	}
	
	//Methods for WebElement actions
//----------------------------------------------------------------------------------------------	
	public String verifytextOtherSites()
	{	
		String actualtext = OtherSites.getText(); 
		return actualtext;
	}
	
	public boolean checkOtherSites()
	{
		boolean result = OtherSites.isEnabled();
		return result ;
	}	
	
	public void otherSites()
	{
		act.moveToElement(OtherSites).perform();
	}
//--------------------------------Personal banking tab ---------------------------------	
	public boolean checkPersonalBankingTab()
	{
		boolean result = PersonalBanking.isEnabled();
		return result;
	}
	
	public void clickOnPersonalBanking(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		act.moveToElement(PersonalBanking).perform(); 
		Thread.sleep(1000);
		act.click().perform();	// Personal banking webpage is clicked
		Thread.sleep(1000);
		driver.switchTo().window(mainpage); // Switch back to Homepage
		Thread.sleep(1000);
		act.moveToElement(OtherSites).perform();
	}
//-----------------------------Business banking tab--------------------------------------
	public boolean checkBusinessBankingTab()
	{
		boolean result = BusinessBanking.isEnabled(); 
		return result; 
	}
	
	public void clickBusinessBanking(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		act.moveToElement(BusinessBanking).perform();
		Thread.sleep(1000);
		act.click().perform();
		Thread.sleep(1000);
		driver.switchTo().window(mainpage);
		Thread.sleep(1000); 
		act.moveToElement(OtherSites).perform();
	}
//-------------------------------Corporate Banking tab------------------------------
	public boolean checkCorporateBankingTab()
	{
		boolean result = CorporateBanking.isEnabled(); 
		return result; 
	}
	
	public void clickCorporateBanking(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		act.moveToElement(CorporateBanking).perform();
		Thread.sleep(1000);
		act.click().perform();
		Thread.sleep(1000);
		driver.switchTo().window(mainpage);
		Thread.sleep(1000); 
		act.moveToElement(OtherSites).perform();
	}
//-------------------------------Investment Banking tab------------------------------
	public boolean checkInvestmentTab()
	{
		boolean result = InvestW.isEnabled(); 
		return result; 
	}
	
	public void clickInvestmentBanking(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		act.moveToElement(InvestW).perform();
		Thread.sleep(1000);
		act.click().perform();
		Thread.sleep(1000);
		driver.switchTo().window(mainpage);
		Thread.sleep(1000); 
		act.moveToElement(OtherSites).perform();
	}	
	
}

