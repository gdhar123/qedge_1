package Pack2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testscreenshot 
{
	public static void main(String[] args) throws IOException 
	{
		//Launch site
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		String s=driver.getTitle();
		System.out.println(s);
		//Make Screen shot as webapp
		File f=((FirefoxDriver)driver).getScreenshotAs(OutputType.FILE);
		//Send buffer
		BufferedImage bi=ImageIO.read(f);
		//Take new png file
		File df=new File("D:\\Shiva\\facebook.png");
		//Save screenshot as new png file
		ImageIO.write(bi, "png", df);
		driver.close();
	}
}
