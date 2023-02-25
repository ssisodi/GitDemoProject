package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	
	@BeforeClass
	public void setup() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8081/opencart/upload/index.php");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
	
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
	}
	
	public String randomNumeric()
	{
		String generatedString = RandomStringUtils.randomNumeric(10);
		return(generatedString);
	}
	
	
	public String randomAlphaNumeric()
	{
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3); 
		
		return(st+"@" +num);
	}
	
	
	
}
