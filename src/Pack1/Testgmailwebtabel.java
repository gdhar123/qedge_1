package Pack1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testgmailwebtabel 
{
	public static WebDriver driver;
	public static String s;
	public static void main(String[] args) throws InterruptedException 
	{
		driver=new FirefoxDriver();
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		s=driver.getTitle();
		System.out.println(s);
		driver.findElement(By.name("Email")).sendKeys("satishkorni");
		driver.findElement(By.name("signIn")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("Passwd")).sendKeys("shivakorni");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[1]/div/div/div[1]/span/a")).click();
		Thread.sleep(3000);
		WebElement mbox=driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div[7]/div/div[1]/div[2]/div/table/tbody/"));
		List<WebElement> rows=mbox.findElements(By.tagName("tr"));
		int nom=rows.size();
		System.out.println(nom);
		List<WebElement> cols=rows.get(0).findElements(By.tagName("td"));
		int noc=cols.size();
		System.out.println(noc);
		s=cols.get(3).getText();
		System.out.println(s);
		
	}

}
