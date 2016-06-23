package Pack1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testway2sms 
{
	public static String s;
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://site21.way2sms.com/content/index.html");
		driver.manage().window().maximize();
		 s=driver.getTitle();
		 System.out.println(s);
		driver.findElement(By.name("username")).sendKeys("9491751955");
		driver.findElement(By.name("password")).sendKeys("raja");
		driver.findElement(By.id("loginBTN")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div[3]/div/input[3]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[2]/div/form/div[2]/div[1]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[7]/div[1]/ul/li[2]/a")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("frame");
		driver.findElement(By.name("mobile")).sendKeys("8985358749");
		driver.findElement(By.name("message")).sendKeys("Hi How Are You And Good Night");
		driver.findElement(By.name("Send")).click();
		Thread.sleep(3000);
		ArrayList a=new ArrayList(driver.getWindowHandles());
		driver.switchTo().window((String)a.get(1));
		driver.close();
		Thread.sleep(1000);
		driver.switchTo().window((String)a.get(2));
		driver.close();
		Thread.sleep(1000);
		driver.switchTo().window((String)a.get(0));
		driver.close();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		String x=driver.findElement(By.xpath("html/body/form/div[3]/div/p/span")).getText();
		System.out.println(x);
		driver.findElement(By.xpath("html/body/div[5]/div/ul/li[7]/i")).click();
		Thread.sleep(3000);
		driver.quit();
	
		
	}

}
