package amazonbookorder.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class Driver {
	
	WebDriver driver;

	@BeforeClass
	public WebDriver setup(String browser)
	{
		
		String currDir=System.getProperty("user.dir");
		
		if(browser.equals("edge")) 
		{
		System.setProperty("webdriver.edge.driver",currDir+"\\resources\\drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		}
		
		else if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",currDir+"\\resources\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",currDir+"\\resources\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Configurations.implicitWaitTime, TimeUnit.MILLISECONDS);
		return driver;
	}
}
