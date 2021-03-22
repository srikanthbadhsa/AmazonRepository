package amazonbookorder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import amazonbookorder.common.Constants;

public class SignInPage {
	
	WebDriver driver;
	public SignInPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By emailIdLocator=By.xpath("//input[@id='ap_email']");
	By continueButtonLocator=By.xpath("//input[@id='continue']");
	By enterPasswordLocator=By.xpath("//input[@id='ap_password']");
	By signInButtonLocator=By.xpath("//input[@id='signInSubmit']");
	
	public void enterEmailId(String email) {
		WebElement emailIdElement=driver.findElement(emailIdLocator);
		emailIdElement.sendKeys(email);
	}
	
	public void clickOnContinueButton()
	{
		WebElement continueButton=driver.findElement(continueButtonLocator);
		continueButton.click();
	}
	
	public void enterPassword(String passwordValue)
	{
		driver.findElement(enterPasswordLocator).sendKeys(passwordValue);;
	}

	public void clickOnSignButton()
	{
		WebElement signInButton=driver.findElement(signInButtonLocator);
		signInButton.click();
	}
}
