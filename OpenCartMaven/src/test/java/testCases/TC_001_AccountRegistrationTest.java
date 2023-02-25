package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends BaseClass {

	
	@Test
	public void test_account_Registration() throws InterruptedException 
	{
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage repage = new AccountRegistrationPage(driver);
		repage.setFirstName(randomString().toUpperCase());
		Thread.sleep(1000);
		repage.setLastName(randomString().toUpperCase());
		Thread.sleep(1000);
		repage.setEmail(randomString()+"@gmail.com");// Randomly generated email
		Thread.sleep(1000);
		repage.setTelephone(randomNumeric());// Randomly generated number
		Thread.sleep(1000);
		String password = randomAlphaNumeric();
		repage.setPassword(password);
		repage.setConfirmPassword(password);
		
		repage.setPrivacyPolicy();
		repage.clickContinue();	
		Thread.sleep(5000);
		String cnfmsg = repage.getConfirmationMsg();
		Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");
	
	}
}
