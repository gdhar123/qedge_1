package Pack1;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testgmail 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		//Get the input from keyboard
		Scanner s=new Scanner(System.in);
		String u,uc;
		String p=null,pc=null;
		System.out.println("Enter user id");
		u=s.nextLine();
		System.out.println("userid criteria");
		uc=s.nextLine();
		if(uc.equals("valid"))
		{
			System.out.println("Etner password");
			p=s.nextLine();
			System.out.println("Password criteria");
			pc=s.nextLine();
		}
		//Launch browser and application
		driver=new FirefoxDriver();
		driver.get("http://www.gmail.com");
		String t=driver.getTitle();
		System.out.println(t);
		driver.findElement(By.name("Email")).sendKeys(u);
		driver.findElement(By.name("signIn")).click();
		Thread.sleep(5000);
		String r=driver.getTitle();
		System.out.println(r);
		if(uc.equals("valid") && driver.findElement(By.name("Passwd")).isDisplayed())
		{
			System.out.println("Ok you can go for password Testing");
			//Password Testing
			driver.findElement(By.name("Passwd")).sendKeys(p);
			driver.findElement(By.id("signIn")).click();
			Thread.sleep(5000);
			String x=driver.getTitle();
			System.out.println(x);
			if(pc.equals("valid") && x.contains(x))
			{
				System.out.println("Test case passed");
			}
			else if(pc.equals("invalid") && x.contains("Gmail"))
			{
				System.out.println("Test case passed");
			}
			else
			{
				System.out.println("Test case failed");
			}
		}
			else if(uc.equals("invalid") && r.contains("Gmail"))
			{
				System.out.println("Test case passed");
			}
			else
			{
				System.out.println("Test case failed");
			}
		Thread.sleep(7000);
			driver.close();
					
		
		
		}
}


