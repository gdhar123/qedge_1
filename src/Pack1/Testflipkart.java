package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Testflipkart 
{
	public static void main(String[] args) throws InterruptedException 
	{
	

		WebDriver obj=new FirefoxDriver();
		obj.get("http://www.flipkart.com");
		//obj.manage().window().maximize();
		Thread.sleep(5000);
		int x=obj.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/ul/li[1]/a/span")).getLocation().getX();
		int y=obj.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/ul/li[1]/a/span")).getLocation().getY();
		Actions a=new Actions(obj);
		a.moveByOffset(x,y).build().perform();
		Thread.sleep(5000);
		obj.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/ul/li[1]/div/div[2]/div[1]/ul[1]/li[1]/a")).click();
		Thread.sleep(4000);
		obj.close();
	}

}
