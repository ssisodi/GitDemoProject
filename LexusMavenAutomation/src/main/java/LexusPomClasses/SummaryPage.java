
package LexusPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {
	
	Actions act;
	
	//'Next: Summary'
		@FindBy(xpath = "//a[contains(text(),'Next: Summary')]")
		private WebElement nextSum; 
		
		// Constructor - Public - WebElement Initialization
		public SummaryPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);		
				act = new Actions(driver);
			}	
//**********************************************************
		public boolean verifyNextSum() 
		{
			boolean NextSum = nextSum.isEnabled(); 
			return NextSum; 
		}
		public void nextSum()
		{
			nextSum.click();
		}

}
