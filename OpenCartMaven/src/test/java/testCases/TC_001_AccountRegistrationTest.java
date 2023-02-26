package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends BaseClass {

	
	@Test
	public void test_account_Registration() throws InterruptedException 
	{
		
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account link");
		
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		AccountRegistrationPage repage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer data");
		
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
		logger.info("Clicked on continue");
		
		Thread.sleep(5000);
		String cnfmsg = repage.getConfirmationMsg();
		
		logger.info("Validating expected message");
		
		Assert.assertEquals(cnfmsg, "Your Account Has Been Created!","Test failed");
	}
		catch(Exception e)
		{
			System.out.println(e);
			logger.error("test failed");
			Assert.fail();
		}
		
}
}