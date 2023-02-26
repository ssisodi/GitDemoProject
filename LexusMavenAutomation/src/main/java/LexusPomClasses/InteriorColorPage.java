package LexusPomClasses;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class InteriorColorPage {
		
		Actions act;

		@FindBy(xpath = "//a/img[@data-code = 'VA20']")
		private WebElement BlackColor; 
		
		@FindBy(xpath = "//div[@id = 'tab-exterior']//span")
		private WebElement VerifyIntColor; 
		
		@FindBy(xpath = "//a[contains(text(),'Next: Packages')]")
		private WebElement NextPac; 
		
		// Constructor - Public - WebElement Initialization
			public InteriorColorPage(WebDriver driver)
				{
					PageFactory.initElements(driver, this);		
					act = new Actions(driver);
				}
		//Methods - Public - Web Elements action 
		public String verifyIntColor()
		{
			String Intcolor = VerifyIntColor.getText(); 
			return Intcolor; 
		}
		public void selectIntColor()
		{
			act.moveToElement(BlackColor).click().build().perform();
		}
		public boolean testnextPackage() 
		{
			boolean IntNext = NextPac.isEnabled(); 
			return IntNext; 
		}
		public void clickNext()
		{
			NextPac.click();
		}
}
