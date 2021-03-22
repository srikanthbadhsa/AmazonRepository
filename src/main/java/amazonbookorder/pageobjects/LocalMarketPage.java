package amazonbookorder.pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalMarketPage {

	WebDriver driver;
	public LocalMarketPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By deleteLocator=By.xpath("//input[@value='Delete']");
	By cardUpdateMessgeBox = By.cssSelector("#cart-update-message-box");
	
	public void deleteAllItems()
	{
		
		List<WebElement> deleteLinks=driver.findElements(deleteLocator);
		for(int i=0; i<deleteLinks.size(); i++)
		{
			WebElement delete = driver.findElement(deleteLocator);
			delete.click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cardUpdateMessgeBox));
		}
	}
}
