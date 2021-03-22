package amazonbookorder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By signMoveLocator=By.xpath("//a[@id='nav-link-accountList']");
	By signButtonLocator=By.xpath("(//span[@class='nav-action-inner'])[1]");
	By welcomeTextLocator=By.xpath("//h2[@class='a-spacing-none truncate-1line']");
	By cartIconLocator=By.xpath("//a[@id='nav-cart']");
	
	public void hoverOnSignText()
	{
		WebElement hoverSign=driver.findElement(signMoveLocator);
		Actions signInText=new Actions(driver);
		signInText.moveToElement(hoverSign).perform();
	}
	
	
	public void clickOnSignInButton()
	{
		driver.findElement(signButtonLocator).click();
	}
	
	public String getWelComeText() {
		WebElement  welcomeTextElement=driver.findElement(welcomeTextLocator);
		String welcomeText=welcomeTextElement.getText();
		return welcomeText;
	}
	
	public void clickOnCartIcon()
	{
		driver.findElement(cartIconLocator).click();
	}
	
	
	
	
	
}
