package Pack1;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Exceldatadriven 
{
	public static void main(String[] args) throws BiffException, IOException, InterruptedException, WriteException 
	{
		File f=new File("D:\\Shiva\\Shiva\\Exceltables\\sample.xls");
		//Read data from excel file
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh=wb.getSheet(0);
		int nor=sh.getRows();
		System.out.println(nor);
		//Write data in to excel file
		WritableWorkbook wwb=Workbook.createWorkbook(f,wb);
		WritableSheet wsh=wwb.getSheet(0);
		//Datadriven testing starts
		for(int i=1;i<nor;i++)
		{
			String u=sh.getCell(0,i).getContents();
			String p=sh.getCell(1,i).getContents();
			String c=sh.getCell(2,i).getContents();
			//Launch Browser with Webdriver
			WebDriver driver=new FirefoxDriver();
			driver.get("http://site21.way2sms.com/content/index.html");
			driver.manage().window().maximize();
			Thread.sleep(5000);
			//Do login
			driver.findElement(By.name("username")).sendKeys(u);
			driver.findElement(By.name("password")).sendKeys(p);
			driver.findElement(By.id("loginBTN")).click();
			Thread.sleep(5000);
			try{
				if(c.equals("valid") && driver.findElement(By.linkText("Logout")).isDisplayed())
				{
					Label l=new Label(3,i,"Test Passed");
					wsh.addCell(l);
				}
				else if(c.equals("invalid") && u.length()<10 && ExpectedConditions.alertIsPresent()!=null)
				{
					Label l=new Label(3,i,"Test Passed");
					wsh.addCell(l);
							
				}
				else if(c.equals("invalid") && driver.findElement(By.xpath("html/body/div[4]/div/div[1]/form/div/h2")).isDisplayed())
				{
					Label l=new Label(3,i,"Test Passed");
					wsh.addCell(l);
					
				}
				else
				{
					Label l=new Label(3,i,"Test Failed");
					wsh.addCell(l);
				}
			}catch(NoSuchElementException e1)
				{
					try{
							if(driver.findElement(By.xpath("html/body/div[3]/div/h3/span")).isDisplayed())
							{
								Label l=new Label(3,i,"Test Passed");
								wsh.addCell(l);
							}
					}catch(NoSuchElementException e2)
					{
						Label l=new Label(3,i,"Test Failed");
						wsh.addCell(l);
						
					}
				}
			driver.quit();
		}
		//Save file
		wwb.write();
		wwb.close();
		wb.close();
			
		}
}
