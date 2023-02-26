package LexusPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LexusHomePage {
	Actions act; 
	
	@FindBy(xpath = "//button[contains(text(),'VEHICLES')]")
	private WebElement vehicles; 
	
	@FindBy(xpath = "//div[@data-slideindex = '0']/span")
	private WebElement suvtab; 
	
	@FindBy(xpath = "//div[@data-slideindex = '1']/span")
	private WebElement sedantab; 
	
	@FindBy(xpath = "//div[@data-slideindex = '2']/span")
	private WebElement hybridtab;
	
	@FindBy(xpath = "//div[@data-slideindex = '3']/span")
	private WebElement performancetab;
	
	@FindBy(xpath = "//div[@data-slideindex = '4']/span")
	private WebElement futuretab;
	
	@FindBy(xpath = "//ul[@data-testid = 'VehicleTiles']")
	private WebElement uxHybrid;

	@FindBy(xpath = "(//a[@aria-label = 'UX HYBRID'])[1]")
	private WebElement main; 	
	
	@FindBy(xpath = "(//a[contains(text(),'BUILD')])[1]")
	private WebElement uxHybridshop;
	
// Constructor - Public - WebElement Initialization
		public LexusHomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);		
			 act = new Actions(driver); 
		}
		
	//Methods - Public - Web Elements action 
//-----------------------------------------------------------------------------------
	public String testVehicletab()
	{
		String actualtext; 
		actualtext = vehicles.getText();
		return actualtext;
	}
	public void cursorOnVehicleTab()
	{
		act.moveToElement(vehicles).perform();
	}
//-----------------------------------------------------------------------------------	
	public String testSedanTab(){
		String actualtext1 = sedantab.getText(); 
		return actualtext1;
	} 
	public String testHybridTab() {
		String actualtext2 = hybridtab.getText();
		return actualtext2; 
	}
	public String testPerformanceTab()
	{
		String actualtext3 = performancetab.getText(); 
		return actualtext3; 
	}
	public String futureTab()
	{
		String actualtext4 = futuretab.getText(); 
		return actualtext4; 
	}
	
	public void moveOverAllTabs() throws InterruptedException
	{
		Thread.sleep(1000);
		act.moveToElement(sedantab).click().build().perform();
		Thread.sleep(1000);
		act.moveToElement(hybridtab).click().build().perform();
		Thread.sleep(1000);
		act.moveToElement(performancetab).click().build().perform();
		Thread.sleep(1000);
		act.moveToElement(futuretab).click().build().perform();
		Thread.sleep(1000);
		act.moveToElement(suvtab).click().build().perform();
	}
//-----------------------------------------------------------------------------------	
	/*public String testFirstBlock()
	{
		String actualtext5 = uxHybrid.getText(); 
		return actualtext5; 	
	}*/
	
	public void moveOverFirstBlock() throws InterruptedException
	{
		Thread.sleep(1000);
		act.moveToElement(main).perform(); 
	}
//-----------------------------------------------------------------------------------
	public void clickonBuild() throws InterruptedException 
	{
		Thread.sleep(1000);
		act.moveToElement(uxHybridshop).click().build().perform();
	}	
}
