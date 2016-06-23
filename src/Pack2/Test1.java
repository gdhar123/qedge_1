package Pack2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test1
{
	public WebDriver driver;
	@Test
	public void launch() throws InterruptedException
	{
		driver=new FirefoxDriver();
		driver.get("http:www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String str = driver.getCurrentUrl();
		System.out.println(str);
		
	}

}
