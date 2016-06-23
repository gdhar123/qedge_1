package Pack1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class GmailUsingRobot 
{
	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		//Launch Gmail app
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		String s=driver.getTitle();
		System.out.println(s);
		//Do login
		driver.findElement(By.name("Email")).sendKeys("satishkorni");
		driver.findElement(By.name("signIn")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("Passwd")).sendKeys("shivakorni");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(10000);
		//Go to compose mail
		driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/div/div")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("to")).sendKeys("shivakorni@outlook.com");
		driver.findElement(By.name("subjectbox")).sendKeys("Hi this is test mail");
		Thread.sleep(3000);
		WebElement w=driver.findElement(By.xpath("html/body/div[14]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[1]/div[2]/div[1]/div/table/tbody/tr/td[2]/div[2]/div"));
		Thread.sleep(5000);
		w.sendKeys(Keys.TAB);
		w.sendKeys("Hi");
		w.sendKeys(Keys.ENTER);
		w.sendKeys("Hello");
		w.sendKeys(Keys.ENTER);
		w.sendKeys("How are You");
		//Click Attachment link
		driver.findElement(By.xpath("html/body/div[14]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[4]/div/div[1]/div/div/div")).click();
		Thread.sleep(3000);
		//Window popup for uploading a file
		StringSelection ss=new StringSelection("D:\\Shiva\\SIVA SATISH PHOTO.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		//Do send the mail
		driver.findElement(By.xpath("html/body/div[14]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[1]/div/div[2]")).click();
		//Get output display
		String x=driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[1]/div[5]/div[1]/div[2]/div[3]/div/div/div[2]")).getText();
		System.out.println(x);
		Thread.sleep(3000);
		//Do logout
		driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(3000);
		driver.close();

	}

}
