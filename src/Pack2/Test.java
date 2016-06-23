package Pack2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test 
{
	public static void main(String args[]) throws InterruptedException{
		WebDriver driver;
		driver=new FirefoxDriver();
		driver.get("https:\\www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String str = driver.getCurrentUrl();
		System.out.println(str);
	}
}
