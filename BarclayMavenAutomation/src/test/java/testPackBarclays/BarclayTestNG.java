package testPackBarclays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import barclayPomClasses.Homepage;

public class BarclayTestNG {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver","G:\\My Drive\\HP Pavillion Backup\\Documents\\Notes-VCT\\chromedriver_win32_110\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://home.barclays/");
		driver.manage().window().maximize(); 
		System.out.println("Before class");	
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
		
	}	
	
  @Test 
  public void Test1() throws InterruptedException{
	  
	  Homepage homepage = new Homepage(driver);
	  String expectedtext = "Other Barclays sites"; 
	  String actualres = homepage.verifytextOtherSites();
	  boolean resultothers = homepage.checkOtherSites();
	  Assert.assertEquals(actualres, expectedtext, "Other Barclays sites tab text is not verified");
	  System.out.println("Other Barclays sites tab text is verified");
	  Assert.assertTrue(resultothers, "Other Barclays sites is disabled");
	  System.out.println("Other Barclays sites tab is functioning correctly");
	  homepage.otherSites();
	 
	  /*
	  if(actualres.equals(expectedtext) && resultothers == true)
		{
			System.out.println("Other Barclays sites tab is verified and functioning correctly");
			homepage.otherSites();
		}
		else 
		{
			System.out.println("Other Barclays sites tab is not verified and functioning correctly");
		}
	  	*/
  }
  
  @Test 
  public void Test2() throws InterruptedException
  {
	  try {
		  
	  Homepage homepage = new Homepage(driver);
	  /*
	  SoftAssert soft = new SoftAssert(); 
	  String acttext = homepage.verifyPersonalBankingTab();
	  String exptext = "Personal Banking  "; 
	  soft.assertEquals(acttext, exptext, "Personal banking text is not matched");
	  System.out.println("Personal banking text is matched");
	  soft.assertAll();
	  */
	  boolean verifybutton = homepage.checkPersonalBankingTab(); 
	  Assert.assertTrue(verifybutton, "Personal banking tab is disabled");
	  System.out.println("Personal banking tab is enabled");  
	  Thread.sleep(3000);
	  homepage.clickOnPersonalBanking(driver);
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
  } 
  
  @Test 
  public void Test3() throws InterruptedException 
  {
	  try {
	  Homepage homepage = new Homepage(driver);
	  boolean result  = homepage.checkBusinessBankingTab();
	  Assert.assertTrue(result, "Business banking tab is disabled");
	  System.out.println("Business banking tab is enabled");
	  Thread.sleep(3000);
	  homepage.clickBusinessBanking(driver);  
	  }
	  catch (Exception e)
	  {
		  System.out.println(e);
	  }
  }
  
  @Test 
  public void Test4() throws InterruptedException
  {
	  try {
	  Homepage homepage = new Homepage(driver);
	  boolean result = homepage.checkCorporateBankingTab(); 
	  Assert.assertTrue(result, "Corporate banking tab is disabled");
	  System.out.println("Corporate banking tab is enabled");
	  Thread.sleep(3000);
	  homepage.clickCorporateBanking(driver);
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
  }
  
  @Test 
  public void Test5() throws InterruptedException
  {
	  try {
	  Homepage homepage = new Homepage(driver);
	  boolean result = homepage.checkInvestmentTab(); 
	  Assert.assertTrue(result, "Investment banking tab is disabled");
	  System.out.println("Investment banking is enabled");
	  Thread.sleep(3000);
	  homepage.clickInvestmentBanking(driver);
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
  }
  
  
  @AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
	}

  
  
}
