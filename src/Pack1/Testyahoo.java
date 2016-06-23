package Pack1;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Testyahoo 
{
	public static WebDriver driver;
	public static String x;
	public static void main(String[] args) throws InterruptedException 
	{
		//Take input from keyboard
		Scanner s=new Scanner(System.in);
		System.out.println("Enter user id");
		String u=s.nextLine();
		System.out.println("Enter password");
		String p=s.nextLine();
		System.out.println("Enter criteria");
		String c=s.nextLine();
		//Launch Browser and application
 		driver=new FirefoxDriver();
 		driver.get("http://www.yahoomail.com");
 		//driver.manage().window().maximize();
 		//Do login
 		driver.findElement(By.name("username")).sendKeys(u);
 		driver.findElement(By.name("passwd")).sendKeys(p);
 		driver.findElement(By.name("signin")).click();
 		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
 		Thread.sleep(7000);
 		//Automation Testing Starts
 		x=driver.getTitle();
 		System.out.println(x);
 		
 		if(c.equals("valid") && x.contains(u))
		{
			System.out.println("Test Case Passed");
			int y=driver.findElement(By.xpath("html/body/div[5]/div[3]/table/tbody/tr/td[3]/ul/li[2]/a/i/img")).getLocation().getX();
	 		int z=driver.findElement(By.xpath("html/body/div[5]/div[3]/table/tbody/tr/td[3]/ul/li[2]/a/i/img")).getLocation().getY();
	 		Actions a=new Actions(driver);
	 		a.moveByOffset(y,z).build().perform();
	 		Thread.sleep(5000);
	 		driver.findElement(By.xpath("html/body/div[5]/div[3]/table/tbody/tr/td[3]/ul/li[2]/div/div/div/ul[2]/li/a")).click();
	 		Thread.sleep(3000);
		}
		else if(c.equals("invalid") && x.contains("Yahoo"))
		{
			System.out.println("Test Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed");
		}
 		
 		driver.close();
 	}
}
