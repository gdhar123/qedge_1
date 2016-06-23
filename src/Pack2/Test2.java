package Pack2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test2 
{
	public static WebDriver driver;
	@Test(priority=0)
	public void launch()
	{
		driver=new FirefoxDriver();
		driver.get("http://www.gmail.com");
	}
	@Test(priority=1)
	public void close()
	{
		driver.manage().window().maximize();
		driver.close();
	}

}
