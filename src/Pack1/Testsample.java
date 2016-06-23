package Pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testsample {

	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://site23.way2sms.com/content/index.html");
		String s=driver.getTitle();
		System.out.println(s);
		driver.close();
	}

}
