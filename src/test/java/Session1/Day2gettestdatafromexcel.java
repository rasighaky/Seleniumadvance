package Session1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Day2gettestdatafromexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		//Step 1: open the document in java readable format
		FileInputStream filei=new FileInputStream(".\\src\\test\\resources\\contacttestdata.xlsx");
		
		//step2:create a workbook
		Workbook workb=WorkbookFactory.create(filei); //ss.model
		
		//step3:Navigate to sheet
		Sheet sh = workb.getSheet("Sheet1");
		
		//step 4:navigate to row
		Row ro = sh.getRow(1);
		
		//step 5:navigate to cell
		Cell ce = ro.getCell(1);
		
		//step 6:capture the data
		String value = ce.getStringCellValue();
		System.out.println(value);
		
		//step 7:close the workbook
		workb.close();
		
		
	}

}
