package Pack1;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class GmailDatadrivenExcel {

	public static void main(String[] args) throws BiffException, IOException, RowsExceededException, WriteException, InterruptedException 
	{
		File f=new File("D:\\Shiva\\Shiva\\Exceltables\\sample.xls");
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh=wb.getSheet(0);
		int nor=sh.getRows();
		System.out.println(nor);
		WritableWorkbook wwb=Workbook.createWorkbook(f,wb);
		WritableSheet wsh=wwb.getSheet(0);
		Label l;
		for(int i=1;i<nor;i++)
		{
			WebDriver driver=new FirefoxDriver();
			driver.get("https://accounts.google.com");
		
			String u=sh.getCell(0,i).getContents();
			String p=sh.getCell(1,i).getContents();
			String uc=sh.getCell(2, i).getContents();
			String pc=sh.getCell(3, i).getContents();
			driver.findElement(By.name("Email")).sendKeys(u);
			driver.findElement(By.id("next")).click();
			Thread.sleep(5000);
			
			if(uc.equals("valid") && driver.findElement(By.name("Passwd")).isDisplayed())
			{
				driver.findElement(By.name("Passwd")).sendKeys(p);
				driver.findElement(By.id("signIn")).click();
				Thread.sleep(60000);
				if(pc.equals("valid") && driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/div/div")).isDisplayed())
				{
					l = new Label(4,i,"Test passed");
					wsh.addCell(l);
				}
				else if(pc.equals("invalid") && driver.findElement(By.id("errormsg_0_Passwd")).isDisplayed())
				{
					l = new Label(4,i,"Invalid Password test passed");
					wsh.addCell(l);			
				}
				else
				{
					l = new Label(4,i,"Invalid Password Test Failed");
					wsh.addCell(l);			
				}		
			}
			else if(uc.equals("invalid") && driver.findElement(By.id("errormsg_0_Email")).isDisplayed())
			{
				l = new Label(4,i,"Invalid Userid test passed");
				wsh.addCell(l);			
			}
			else
			{
				l = new Label(4,i,"Invalid User Test Failed");
				wsh.addCell(l);			
			}	
			driver.close();
		}
		
		wwb.write();
		wwb.close();
		wb.close();
	}

}
