package Pack1;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Calexcel 
{
	public static void main(String[] args) throws BiffException, IOException, RowsExceededException, WriteException 
	{
		File f=new File("D:\\Shiva\\Shiva\\Exceltables\\data.xls");
		//Reading data from excel sheet
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh=wb.getSheet(0);
		int nor=sh.getRows();
		//Write data in excel sheet
		WritableWorkbook wwb=Workbook.createWorkbook(f,wb);
		WritableSheet wsh=wwb.getSheet(0);
		//Data driven 
		for(int i=1;i<nor;i++)
		{
			String x=sh.getCell(0,i).getContents();
			int a=Integer.parseInt(x);
			String y=sh.getCell(1,i).getContents();
			int b=Integer.parseInt(y);
			int c=a+b;
			Number n=new Number(2,i,c);
			wsh.addCell(n);
		}
		//Save changes
		wwb.write();
		//Remove from ram
		wwb.close();
		wb.close();
	}

}
