package Pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Testflipkart 
{
	public static WebDriver driver;
	public static String s;
	public static void main(String[] args) throws InterruptedException 
	{
		driver=new FirefoxDriver();
		driver.get("http://www.flipkart.com/");
		driver.manage().window().maximize();
		s=driver.getTitle();
		System.out.println(s);
		int x=driver.findElement(By.xpath("//*[@id='container']/div/div/header/div[1]/div/ul/li[2]/a")).getLocation().getX();
		System.out.println(x);
		int y=driver.findElement(By.xpath("//*[@id='container']/div/div/header/div[1]/div/ul/li[2]/a")).getLocation().getY();
		System.out.println(y);
		Actions a=new Actions(driver);
		a.moveByOffset(x, y).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='container']/div/div/header/div[1]/div/ul/li[2]/ul/li[2]/ul/li[2]/ul/li[4]/a/span")).click();
		Thread.sleep(5000);
		driver.close();
	}
}
