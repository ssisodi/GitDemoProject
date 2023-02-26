package testNgPack;
//Main TestNG Class 
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import LexusPomClasses.AccessoriesPage;
	import LexusPomClasses.ExteriorColorPage;
	import LexusPomClasses.InteriorColorPage;
	import LexusPomClasses.LexusHomePage;
	import LexusPomClasses.PincodePage;
	import LexusPomClasses.SummaryPage;
import browser.Browser;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestNgClass1 extends Browser{
	WebDriver driver;

	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before Suite");
	}
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName)
	{
	
		if(browserName.equals("Chrome"))
		{
		 driver = openChromeBrowser(); 
		}
		if(browserName.equals("Firefox"))
		{
			driver = openFireFoxBrowser(); 
		}
		if(browserName.equals("Opera"))
		{
			driver = openOperaBrowser(); 
		}
		if(browserName.equals("MicrosoftE"))
		{
			driver = openMicrosoftEBrowser(); 
		}
		
		System.out.println("Before test");
	}

	
	@BeforeClass
	public void defaultDriver() {
	driver.get("https://www.lexus.com/");
	driver.manage().window().maximize();	
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{	
		Thread.sleep(3000); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("*************************************");
		System.out.println("Before Method ran before each test");
	}
	
@Test 
public void Test1() throws InterruptedException {
	
	  try {
		  System.out.println("-------------------------------------------------");
	  System.out.println("Test case 1 - Homepage");
	  LexusHomePage homepage = new LexusHomePage(driver); 
	  String expresult = "VEHICLES"; 
	  String result = homepage.testVehicletab();//actual
	  System.out.println(result);
	  //Hard assert(with 2 arguments) 
	  //  Assert.assertEquals(result, expresult);
	  
	  //Hard assert(with 3 arguments)
	 Assert.assertEquals(result, expresult,"Vehicles dropdown menu unsuccessful "); 
	 System.out.println("Vehicles dropdown menu successfull");
	 homepage.cursorOnVehicleTab();
	 
	 /* Hard assertion is replaced for 'if-else statement' 
	  if(result.equals(expresult))
	  {
		  System.out.println("Vehicles dropdown menu successful");
		  homepage.cursorOnVehicleTab();
	  }
	  else 
	  {
		  System.out.println("Vehicles dropdown menu unsuccessful");
	  }
	 */
	  Thread.sleep(2000);
	//-------------------------------------------------------
	  String exptext1 = "SEDAN123"; 
	  String exptext2 = "HYBRID & ELECTRIC"; 
	  String exptext3 = "PERFORMANCE123"; 
	  String exptext4 = "FUTURE"; 
	  String result1 = homepage.testSedanTab(); 
	  String result2 = homepage.testHybridTab(); 
	  String result3 = homepage.testPerformanceTab(); 
	  String result4 = homepage.futureTab(); 
	  // Hard assertion is replaced for 'if-else statement'
	  Assert.assertNotEquals(result1, exptext1, "The text is same so it failed");
	  Assert.assertEquals(result2,exptext2, "Hybrid & Electric is not clicked and it failed");
	  Assert.assertNotEquals(result3, exptext3, "Performance is not clicked and it failed");
	  Assert.assertEquals(result4, exptext4, "Future text is not same so it failed ");
	  System.out.println("Tabs validation successfull");
	  homepage.moveOverAllTabs(); // Once all conditions are true, the move Over all tabs functions will execute
	  
	  /*
	  if(result1.equals(exptext1) && result2.equals(exptext2) && result3.equals(exptext3) && result4.equals(exptext4)) 
	  {
		  System.out.println("Tabs validation successful");
		  homepage.moveOverAllTabs();
	  }
	  else
	  {
		  System.out.println("Tabs validation unsuccessful");
	  }*/
	  Thread.sleep(2000); 
	//-----------------------------------------------------------		
	 /* String exptext5 = "UX HYBRID";
	  System.out.println("exptext5"+exptext5);
	  String result5 = homepage.testFirstBlock();
	  System.out.println(result5);
	  if(result5.equals(exptext5))
	  {
		  System.out.println("First block Selected");
		  homepage.moveOverFirstBlock();
		 
	  }
	  else
	  {
		  System.out.println("First block not selected");
	  }*/
	  homepage.moveOverFirstBlock();
	//-----------------------------------------------------------	
	  Thread.sleep(2000);
	  homepage.clickonBuild();  	  
	  String actualURL = driver.getCurrentUrl(); 
	  String expectedURL = "https://www.lexus.com/build-your-lexus/#!/series/UXh/";
	  
	  boolean buildUrlResult = actualURL.equals(expectedURL); 
	  /*Hard assert with only 1 argument that checks True or false 
	   * without any message for failed condition
	   * uncomment the link below to use this*/
	  // Assert.assertTrue(buildUrlResult);
	  
	//Hard assert with 2 arguments that checks True or false with a message for failed condition
	  Assert.assertTrue(buildUrlResult, "Link validation: Build URL is incorrect");
	  System.out.println("Link validation: Build URL is correct");
	  
	  /*
	  if(actualURL.equals(expectedURL))
	  {
		  System.out.println("Link validation: Build URL is correct");
	  }
	  else 
	  {
		  System.out.println("Link validation: Build URL is incorrect");
	  }*/
	  
	  }
	  catch(NoSuchElementException e)
	  {
		  LexusHomePage homepage = new LexusHomePage(driver);
		  homepage.cursorOnVehicleTab();
		  homepage.moveOverAllTabs();  
	  }
	  catch(Exception f)
	  {
		  System.out.println("Dropped to the last exception catch block");
	  }
}

@Test 
public void Test2() throws InterruptedException
{
	  try {
	  System.out.println("-------------------------------------------------");
	  System.out.println("Test case 2 - Pincode & Car selection page");
	  PincodePage pincode = new PincodePage(driver);
	  SoftAssert soft = new SoftAssert();
	  
	  boolean actresult = pincode.testPinInput();
	  soft.assertTrue(actresult, "Pincode input is disabled");
	  soft.assertAll();
	  
	  System.out.println("Pincode input is enabled");
	  
	  /*
	  if(actresult == true)
	  {
		  System.out.println("Pincode input is enabled");
	  }
	  else if(actresult == false)
	  {
		  System.out.println("Pincode input is disabled");
	  }*/
	  Thread.sleep(2000);
	  pincode.addPinCode(); // PinCode Entered after testing
	//-----------------------------------------------------------		  
	  Thread.sleep(2000);
	  boolean searchtab = pincode.testSearchPin();
	  soft.assertTrue(searchtab, "Search button is disabled");
	  soft.assertAll();
	  System.out.println("Search button is enabled");
	  
	  /*  Soft assert is used to replace 'if-else comparison'
	  if(searchtab == true)
	  {
		  System.out.println("Search button is enabled");
	  }
	  else if(searchtab == false)
	  {
		  System.out.println("Search button is disabled");
	  }*/
	  Thread.sleep(2000);
	  pincode.clickSearchPin();// PinCode searched after testing 
	//-----------------------------------------------------------
	  Thread.sleep(2000);
	  String acttext = pincode.verifyCarTitle(); 
	  System.out.println("Actual car title: " + acttext);
	  String exptext = "2023 UX 250h F SPORT DESIGN";
	  soft.assertEquals(acttext, exptext, "Car title not matched");
	  soft.assertAll();
	  
	//  soft.assertEquals(actresult, exptext, "Car title not matched");
	  System.out.println("Car did matched for assert Equals");
	  
	  /* Soft assert is used to replace 'if-else comparison'
	  if(acttext.equals(exptext))
	  {
		  System.out.println("Car title matched");
	  }
	  else
	  {
		  System.out.println("Car title not matched");
	  }
	  */
	  Thread.sleep(2000);
	  pincode.scrollToMyCar();// Car title searched by scrolling down 
	  Thread.sleep(3000);
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
		  System.out.println("-------------------------------------------------");  
		System.out.println("Test case 3 - Exterior color page");
		ExteriorColorPage exteriorcolor = new ExteriorColorPage(driver); 
		exteriorcolor.selectExtColor();// Clicking the Exterior color before testing
		String actcolor = exteriorcolor.verifyExtColor(); 
		System.out.println(actcolor);
		String expcolor = "Cloudburst Gray* with Obsidian roof";
		
		Assert.assertEquals(actcolor, expcolor,"Cloudburst Gray* with Obsidian roof color not selected");
		System.out.println("Cloudburst Gray* with Obsidian roof color selected");
		/*
		if(actcolor.equals(expcolor))
		{
			System.out.println("Exterior color type is matched");
		}
		else 
		{
			System.out.println("Exterior color type is not matched");
		}
		*/
		//-----------------------------------------------------------
		Thread.sleep(2000);
		boolean nexttab = exteriorcolor.testNextButton(); 
		Assert.assertTrue(nexttab, "Next:Interior button is disabled");
		System.out.println("Next:Interior button is enabled");
		/*
		if(nexttab == true)
		{
			System.out.println("Next:Interior button is enabled");
		}
		else 
		{
			System.out.println("Next:Interior button is disabled");
		}
		*/
		exteriorcolor.clickNext(); // Clicking the Next:Interior tab after testing
	 }
	  catch(Exception e)
	  	{
		  System.out.println(e);
	  	}
}

	@Test
	public void Test4() throws InterruptedException
	{
		try {
		System.out.println("-------------------------------------------------");	
		System.out.println("Test case 4 - Interior color page");
		InteriorColorPage interiorcolor = new InteriorColorPage(driver);
		interiorcolor.selectIntColor(); // Interior color selected before testing 
		String actIntcolor = interiorcolor.verifyIntColor(); 
	//	System.out.println(actIntcolor);
		String expIntcolor = "Black NuLuxe® and Black washi dash trim"; 
		
		Assert.assertEquals(actIntcolor, expIntcolor, "Interior color is not matched");
		System.out.println("Interior color is matched");
		/*
		if(actIntcolor.equals(expIntcolor))
		{
			System.out.println("Interior color is matched");
		}
		else 
		{
			System.out.println("Interior color is not matched");
		}
		*/
		//-----------------------------------------------------------
		Thread.sleep(2000);
		
		boolean nextpac = interiorcolor.testnextPackage(); 
		Assert.assertTrue(nextpac, "Next:Package button is disabled");
		System.out.println("Next:Package button is enabled");
		/*
		if(nextpac == true)
		{
			System.out.println("Next:Package button is enabled");
		}
		else 
		{
			System.out.println("Next:Package button is disabled");
		}
		*/
		interiorcolor.clickNext();// Next package button clicked after testing
		
		System.out.println("-------------------------------------------------");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Test
	public void Test5()
	{
		try {
			System.out.println("-------------------------------------------------");	
			System.out.println("Test case 5 - Accessories page");
			AccessoriesPage accessories = new AccessoriesPage(driver); 
			//AUTO-DIMMING REARVIEW MIRROR
			String actmatch1 = accessories.verifyAutoDim(); 
			String expmatch1 = "AUTO-DIMMING REARVIEW MIRROR";
			Assert.assertEquals(actmatch1, expmatch1, "Cannot add this Item 1");
			accessories.add1stItem();
			System.out.println("Item 1 got added");
			/*
			if(actmatch1.equals(expmatch1))
			{
				accessories.add1stItem(); // AUTO-DIMMING REARVIEW MIRROR item is added
				System.out.println("Item 1 got added");
			}
			else 
			{
				System.out.println("Cannot add this Item 1");
			}
			*/
			
			//COLOR HEAD-UP DISPLAY
			String actmatch2 = accessories.verifyHeadUp(); 
			String expmatch2 = "COLOR HEAD-UP DISPLAY";
			Assert.assertEquals(actmatch2, expmatch2, "Cannot add this Item 2");
			accessories.add2ndItem();
			System.out.println("Item 2 got added");
			/*			
			if(actmatch2.equals(expmatch2))
			{
				accessories.add2ndItem();// COLOR HEAD-UP DISPLAY item is added
				System.out.println("Item 2 got added");
			}else 
			{
				System.out.println("Cannot add this Item 2");
			}
			*/
			
			//WIRELESS CHARGER
			String actmatch3 = accessories.verifyWirelessC(); 
			String expmatch3 = "WIRELESS CHARGER*";
			Assert.assertEquals(actmatch3, expmatch3, "Cannot add this Item 3");
			accessories.add3rdItem();//WIRELESS CHARGER item is added
			System.out.println("Item 3 got added");
			/*
			if(actmatch3.equals(expmatch3))
			{
				accessories.add3rdItem();//WIRELESS CHARGER item is added
				System.out.println("Item 3 got added");
			}
			else 
			{
				System.out.println("Cannot add this Item 3");
			}
			*/
			
			//INTUITIVE PARKING ASSIST
			String actmatch4 = accessories.verifyIntuitPark(); 
			String expmatch4 = "INTUITIVE PARKING ASSIST*";
			Assert.assertEquals(actmatch4, expmatch4, "Cannot add this Item 4");
			accessories.add4thItem();
			System.out.println("Item 4 got added");
			/*
			if(actmatch4.equals(expmatch4))
			{
				accessories.add4thItem();
				System.out.println("Item 4 got added");
			}
			else 
			{
				System.out.println("Cannot add this Item 4");
			}*/
			
			
			//POWER REAR DOOR WITH KICK SENSOR	
			String actmatch5 = accessories.verifyPowerSensor(); 
			String expmatch5 = "POWER REAR DOOR WITH KICK SENSOR"; 
			Assert.assertEquals(actmatch5, expmatch5, "Cannot add this Item 5");
			accessories.add5thItem();
			System.out.println("Item 5 got added");
			/*			
			if(actmatch5.equals(expmatch5))
			{
				accessories.add5thItem();
				System.out.println("Item 5 got added");
			}
			else 
			{
				System.out.println("Cannot add this Item 5");
			}
			*/
			
			//HEATED STEERING WHEEL
			String actmatch6 = accessories.verifyHeaterWheel(); 
			String expmatch6 = "HEATED STEERING WHEEL"; 
			Assert.assertEquals(actmatch6, expmatch6, "Cannot add this Item 6 & 7");
			accessories.add6thItem();
			System.out.println("Item 6 & 7 got added");
			/*
			if(actmatch6.equals(expmatch6))
			{
				accessories.add6thItem();
				System.out.println("Item 6 & 7 got added");
			}
			else {
				System.out.println("Cannot add this Item 6 & 7");
			}
			*/
			Thread.sleep(3000);
			//WINDSHIELD WIPER DE-ICER
			String actmatch7 = accessories.verifyDeIcer(); 
			String expmatch7 = "WINDSHIELD WIPER DE-ICER";
			Assert.assertEquals(actmatch7, expmatch7, "Cannot add this Item 8");
			accessories.add8Item();
			System.out.println("Item 8 got added");
			/*
			if(actmatch7.equals(expmatch7))
			{
				accessories.add8Item();
				System.out.println("Item 8 got added");
			}
			else 
			{
				System.out.println("Cannot add this Item 8");
			}
			*/
			// Next: Accessories
			boolean actmatch8 = accessories.verifyNextAcc(); 
			Assert.assertTrue(actmatch8, "Next: Accessories is disabled");
			System.out.println("Next: Accessories is enabled");
			accessories.clickNextAcc();
			/*
			if(actmatch8 == true)
			{
				System.out.println("Next: Accessories is enabled");
				accessories.clickNextAcc();
			}
			else
			{
				System.out.println("Next: Accessories is disabled");
			}		
			*/	
		}
		catch(Exception e)
		{
			
		}
	}

	@Test
	public void Test6() throws InterruptedException
	{
		try {
		System.out.println("-------------------------------------------------");	
		System.out.println("Test case 6 - Summary page");
		
		SummaryPage summarypage = new SummaryPage(driver); 
		boolean sumpage = summarypage.verifyNextSum();
		Assert.assertTrue(sumpage, "Next: Summary tab is disabled");
		System.out.println("Next: Summary tab is enabled");
		Thread.sleep(3000);
		summarypage.nextSum();
		/*
		if(sumpage == true)
		{
			System.out.println("Next: Summary tab is enabled");
			Thread.sleep(3000);
			summarypage.nextSum();
		}
		else 
		{
			System.out.println("Next: Summary tab is disabled");
		}*/
		}
		catch(NoSuchElementException e)
		{
			SummaryPage summarypage = new SummaryPage(driver);
			summarypage.nextSum();			
		}
		catch(Exception f)
		{
			System.out.println("Reached the last catch block for summary page with this exception" + f);
		}
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterclass()
	{
		System.out.println("After Class");
	}

	@AfterTest
	public void afterTest()
	{
	//	driver.quit();
		System.out.println("After test");
	}

	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After suite for TestNg Class 1 ");
	}

}

/*
For TestNg paste this in Test suite for multiple browsers

<class name="TestNg.TestNgClass2"/>



<test name="FireFoxBrowserTest">
<parameter name="browser" value="Firefox"></parameter>
<classes>
<class name="TestNg.TestNgClass1"/>
<class name="TestNg.TestNgClass2"/>
</classes>
</test><!-- FireFox Driver Test -->

<test name="OperaBrowserTest">
<parameter name="browser" value="Opera"></parameter>
<classes>
<class name="TestNg.TestNgClass1"/>
<class name="TestNg.TestNgClass2"/>
</classes>
</test><!-- Opera Driver Test -->

<test name="Microsoft Edge Test">
<parameter name="browser" value="MicrosoftE"></parameter>
<classes>
<class name="TestNg.TestNgClass1"/>
<class name="TestNg.TestNgClass2"/>
</classes>
</test><!-- Microsoft Edge 

*/

