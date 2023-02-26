
package LexusPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccessoriesPage {
	Actions act;
	
	//AUTO-DIMMING REARVIEW MIRROR
	@FindBy(xpath = "(//ul[@id = 'individualSelectionView']/li//h3)[1]")
	private WebElement autoDim;
	
	@FindBy(xpath = "(//a[text() = 'Add'])[1]")
	private WebElement addItem1; 
	//COLOR HEAD-UP DISPLAY
	@FindBy(xpath = "(//ul[@id = 'individualSelectionView']/li//h3)[2]")
	private WebElement headup;
	
	@FindBy(xpath = "//a[@aria-label='Add COLOR HEAD-UP DISPLAY']")
	private WebElement addItem2; 
	
	//WIRELESS CHARGER
	@FindBy(xpath = "(//ul[@id = 'individualSelectionView']/li//h3)[3]")
	private WebElement wirelessC;
	
	@FindBy(xpath = "//a[@aria-label='Add WIRELESS CHARGER']")
	private WebElement addItem3; 
	
	//INTUITIVE PARKING ASSIST
	@FindBy(xpath = "(//ul[@id = 'individualSelectionView']/li//h3)[4]")
	private WebElement intuitPark;
	
	@FindBy(xpath = "//a[@aria-label='Add INTUITIVE PARKING ASSIST']")
	private WebElement addItem4; 
	
	//POWER REAR DOOR WITH KICK SENSOR	
	@FindBy(xpath = "(//ul[@id = 'individualSelectionView']/li//h3)[5]")
	private WebElement powerSensor; 
	
	@FindBy(xpath = "//a[@aria-label='Add POWER REAR DOOR WITH KICK SENSOR']")
	private WebElement addItem5;
	
	//HEATED STEERING WHEEL
	@FindBy(xpath = "(//ul[@id = 'individualSelectionView']/li//h3)[6]")
	private WebElement heaterWheel;
	
	@FindBy(xpath = "//a[@aria-label='Add HEATED STEERING WHEEL']")
	private WebElement addItem6; 
	
	@FindBy(xpath = "(//footer[@class = 'conflict-foot'])[1]")
	private WebElement footerDriver;
	
	@FindBy(xpath = "//a[contains(text(),'Confirm')]")
	private WebElement addItem7; 
	
	//WINDSHIELD WIPER DE-ICER
	@FindBy(xpath = "(//ul[@id = 'individualSelectionView']/li//h3)[7]")
	private WebElement deicer; 
	
	@FindBy(xpath = "//a[@aria-label='Add WINDSHIELD WIPER DE-ICER']")
	private WebElement addItem8;
	//'Next: Accessories'
	@FindBy(xpath = "//a[contains(text(),'Next: Accessories')]")
	private WebElement nextAcc;
	
	
	// Constructor - Public - WebElement Initialization
	public AccessoriesPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);		
				act = new Actions(driver);
			}
	//Methods - Public - Web Elements action
	public String verifyAutoDim()
	{
		String AutoDimText = autoDim.getText(); 
		return AutoDimText; 
	}		
	public void add1stItem()
	{
		addItem1.click();
	}
//**********************************************************
	public String verifyHeadUp()
	{
		String HeadUpText = headup.getText(); 
		return HeadUpText; 
	}
	public void add2ndItem()
	{
		addItem2.click();
	}
//**********************************************************	
	public String verifyWirelessC()
	{
		String WirelessC = wirelessC.getText();
		return WirelessC; 
	}
	public void add3rdItem()
	{
		addItem3.click();
	}
//**********************************************************
	public String verifyIntuitPark()
	{
		String IntuitPark = intuitPark.getText(); 
		return IntuitPark;
	}
	public void add4thItem()
	{
		addItem4.click();
	}
//**********************************************************
	public String verifyPowerSensor()
	{
		String PowerSensor = powerSensor.getText(); 
		return PowerSensor;
	}
	public void add5thItem() 
	{
		addItem5.click();
	}
//**********************************************************
	public String verifyHeaterWheel()
	{
		String HeaterWheel = heaterWheel.getText();
		return HeaterWheel; 
	}
	public void add6thItem()
	{
		addItem6.click();
		act.moveToElement(footerDriver).moveToElement(addItem7).click().build().perform();
	}
	
	
//**********************************************************
	public String verifyDeIcer()
	{
		String DeIcer = deicer.getText(); 
		return DeIcer; 
	}
	public void add8Item()
	{
		addItem8.click();
	}
//**********************************************************
	public boolean verifyNextAcc()
	{
		boolean NextAcc = nextAcc.isEnabled(); 
		return NextAcc; 
	}
	public void clickNextAcc()
	{
		nextAcc.click();
	}
}
