package amazonbookorder.pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazonbookorder.common.Driver;
import jdk.internal.net.http.common.MinimalFuture.ExceptionalSupplier;
public class CartPage {
	
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By cartEmptyMessageLocator=By.xpath("//h1[@class='a-spacing-mini a-spacing-top-base']");
	By editAllItemsLocator=By.xpath("//a[@id='rcx-alm-ctnow-full-cart-link']/span");
	By deleteLocator=By.cssSelector(".sc-action-delete .a-color-link");
	By deleteMessage=By.cssSelector(".sc-list-item-removed-msg");
	
	
	
	WebElement editAllItems;
	
	public void deleteAllItems() throws InterruptedException
	{
		
		List<WebElement> listOfDeleteButtons=driver.findElements(deleteLocator);
		listOfDeleteButtons.get(0).click();
		
			for(int i=1;i<listOfDeleteButtons.size();i++)
			{
			int counter=0;
			while(counter==0) {
			try {
			List<WebElement> updatedDeleteList=driver.findElements(deleteLocator);
			WebElement delete = updatedDeleteList.get(1);
			delete.click();
			counter++;
			}
			catch(StaleElementReferenceException se) {
				
			}
			}
			
		}
		
		
	}
	
	public int ifEditAllItemLinkIsViewable()
	{
		return driver.findElements(editAllItemsLocator).size();
	}
	public void clickOnEditAllItems()
	{
		driver.findElement(editAllItemsLocator).click();
	}
	
	
}
