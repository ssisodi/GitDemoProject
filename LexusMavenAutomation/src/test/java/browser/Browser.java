package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser {

	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","G:\\My Drive\\HP Pavillion Backup\\Documents\\Notes-VCT\\chromedriver_win32_110\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver; 
	}
	
	public static WebDriver openFireFoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver","G:\\My Drive\\HP Pavillion Backup\\Documents\\Notes-VCT\\geckodriver-v0.32.1-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver openOperaBrowser()
	{
		System.setProperty("webdriver.opera.driver","G:\\My Drive\\HP Pavillion Backup\\Documents\\Notes-VCT\\operadriver_win32\\operadriver_win32\\operadriver.exe");
		WebDriver driver = new OperaDriver();
		return driver;
	}
	public static WebDriver openMicrosoftEBrowser()
	{
		System.setProperty("webdriver.edge.driver","G:\\My Drive\\HP Pavillion Backup\\Documents\\Notes-VCT\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}
}
