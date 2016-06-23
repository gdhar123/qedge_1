package Pack2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Testexcel 
{
	public static WebDriver driver;
	public static String s;
	public static String u;
	public static String p;
	public static String c;
	public int i;
	public static Workbook wb;
	public static Sheet sh;
	public static WritableWorkbook wwb;
	public static WritableSheet wsh;
	
	
	@BeforeClass
	public void openbrowser()
	{
		System.out.println("Logic for Open the Browser");
		
		//ArrayList<String> a=new ArrayList<String>(driver.getWindowHandles());
		//driver.switchTo().window((String)a.get(1));
		//driver.close();
	}
	@AfterClass
	public void closebrowser()
	{
		System.out.println("Logic for close the Browser");
		//driver.close();
	}
	@BeforeMethod()
	public void login() throws BiffException, IOException
	{
		System.out.println("Logic for Login the applicatio");
		
	}
	
	@AfterMethod()
	public void logout()
	{
		System.out.println("Logic for Logout the Application");
	}
	
	@Test()
	public void Testingprocess() throws RowsExceededException, WriteException, IOException, BiffException, InterruptedException
	{
		//Get the data from excel file
			File f=new File("D:\\Shiva\\Shiva\\Exceltables\\sample.xls");
			//Read Data from excel file
			Workbook wb=Workbook.getWorkbook(f);
			Sheet sh=wb.getSheet(0);
			int nor=sh.getRows();
			System.out.println(nor);
			//Write the data into excel file
			WritableWorkbook wwb=Workbook.createWorkbook(f,wb);
			WritableSheet wsh=wwb.getSheet(0);
			//Data driven testing starts
			for( i=1;i<nor;i++)
			{
				u=sh.getCell(0,i).getContents();
				p=sh.getCell(1,i).getContents();
				c=sh.getCell(2,i).getContents();
				
				driver=new FirefoxDriver();
				driver.get("http://site23.way2sms.com/content/index.html");
				driver.manage().window().maximize();
				//s=driver.getTitle();
				//System.out.println(s);		
				driver.findElement(By.name("username")).sendKeys(u);
				driver.findElement(By.name("password")).sendKeys(p);
				driver.findElement(By.id("loginBTN")).click();
				Thread.sleep(5000);
				
				try{
					if(c.equals("valid") && driver.findElement(By.linkText("Logout")).isDisplayed())
					{
						Label l=new Label(3,i,"TestcasePassed");
						wsh.addCell(l);
						System.out.println("Passed for valid userid and valid password");
					}
					else if(c.equals("invalid") && u.length()<10 && ExpectedConditions.alertIsPresent()!=null)
					{
						Label l=new Label(3,i,"TestcasePassed");
						wsh.addCell(l);
						System.out.println("Passed for invalid userid with length less than 10");
					}
					else if(c.equals("invalid") && driver.findElement(By.xpath("//*[@id='forgotPwdForm']/div/h2")).isDisplayed())
					{
						Label l=new Label(3,i,"TestcasePassed");
						wsh.addCell(l);
						System.out.println("Passed for valid userid and invalid password- suggest for forgot password");
					}
					
					else
					{
						Label l=new Label(3,i,"TestFailed");
						wsh.addCell(l);
						System.out.println("Test Failed... ");
					}
				}catch(Exception e){
					System.out.println("Entered into catch block for unregistered user");
					if(driver.findElement(By.xpath("html/body/div[3]/div/h3/span")).isDisplayed())
					{
						Label l=new Label(3,i,"TestcasePassed");
						wsh.addCell(l);
						System.out.println("Passed for Unregistered userid");
					}
					else
					{
						Label l=new Label(3,i,"TestFailed");
						wsh.addCell(l);
						System.out.println("Test Failed");
					}
				}
				driver.quit();

			}
			//save file 
			wwb.write();
			wwb.close();
			wb.close();
		}

}
