package Pack1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Testgoogle 
{

	public static WebDriver driver;
	public static String s;
	public static void main(String[] args) throws InterruptedException 
	{
		driver=new FirefoxDriver();
		driver.get("http:www.google.co.in");
		Actions a=new Actions(driver);
		for(int i=1;i<=8;i++)
		{
			a.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(3000);
			
		}
		a.sendKeys("mindq").build().perform();
		for(int j=1;j<=5;j++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(3000); 
		}
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		driver.close();

	}

}
