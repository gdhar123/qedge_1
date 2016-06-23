 package Pack1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testinfy 
{
	public static WebDriver driver;
	public static String s;
	public static void main(String[] args) throws InterruptedException 
	{
		driver=new FirefoxDriver();
		driver.get("http://www.infosys.com/careers/");
		driver.manage().window().maximize();
		s=driver.getTitle();
		System.out.println(s);
		driver.findElement(By.xpath("html/body/form/div[8]/div/div/ul/li[3]/a/span")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("html/body/form/div[8]/div[2]/div[2]/div/div/div[4]/div[1]/div/article/div[1]/div/div/div/p[4]/a[1]")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		ArrayList a=new ArrayList(driver.getWindowHandles());
		driver.switchTo().window((String)a.get(1));
		s=driver.getTitle();
		System.out.println(s);
		s=driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table/tbody/tr[1]/td")).getText();
		System.out.println(s);
		driver.findElement(By.name("sap-alias")).sendKeys("Narayanamurthy");
		//driver.findElement(By.name("sap-password")).sendKeys("Infosys founder");
		driver.findElement(By.id("sap-accessibility-img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td/table/tbody/tr[11]/td[2]/a/span")).click();
		s=driver.switchTo().alert().getText();
		System.out.println(s);
		driver.switchTo().alert().accept();
		driver.switchTo().window((String)a.get(1));
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window((String)a.get(0));
		Thread.sleep(3000);
		driver.close();
		

	}

}
