package amazonbookorder.testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amazonbookorder.common.Driver;
import amazonbookorder.pageobjects.CartPage;
import amazonbookorder.pageobjects.HomePage;
import amazonbookorder.pageobjects.LocalMarketPage;
import amazonbookorder.pageobjects.SignInPage;
import amazonbookorder.TestData;
import amazonbookorder.common.Constants;
import amazonbookorder.common.Configurations; 
public class LaunchBrowserTest {

	WebDriver driver;
	
	@Test
	public void launch()
	{
		Driver demo=new Driver();
		driver=demo.setup(Configurations.browserName);
	}
	
	@Test
	public void verifyIfBrowserIsOpened() throws InterruptedException 
	{
		driver.get(Constants.url);
		HomePage home=new HomePage(driver);
		home.hoverOnSignText();
		home.clickOnSignInButton();
		
		SignInPage sign=new SignInPage(driver);
		sign.enterEmailId(Constants.emailId);
		sign.clickOnContinueButton();
		sign.enterPassword(Constants.password);
		sign.clickOnSignButton();
	
		String actualWelcomeText=home.getWelComeText();
		Assert.assertEquals(actualWelcomeText, TestData.expectedWelcomeText);
		
		home.clickOnCartIcon();
		
		CartPage cp=new CartPage(driver);
		LocalMarketPage lmp=new LocalMarketPage(driver);
		cp.deleteAllItems();
		int totalLinks = cp.ifEditAllItemLinkIsViewable();
		if(totalLinks > 0) {
			cp.clickOnEditAllItems();
			lmp.deleteAllItems();
		}
		else 
		{
			System.out.println("Cart is empty");
		}
	}
	
	
}
