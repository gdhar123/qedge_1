package Pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Testrightclick 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver obj=new FirefoxDriver();
		obj.get("http://www.seleniumhq.org/");
		Thread.sleep(5000);
		obj.findElement(By.partialLinkText("Download Selenium")).click();
		Thread.sleep(5000);
		Actions a=new Actions(obj);
		a.moveToElement(obj.findElement(By.partialLinkText("2.53.0"))).contextClick().build().perform();
		Thread.sleep(5000);
		a.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(5000);
		a.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(5000);
		a.sendKeys(Keys.ENTER).build().perform();
		
	

	}

}
