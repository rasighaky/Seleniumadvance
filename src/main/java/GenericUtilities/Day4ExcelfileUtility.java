package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author kymon
 *
 */
public class Day4ExcelfileUtility {
	/**
	 * This method will read data from excel and return the value to caller
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
       public String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
       {
    	   FileInputStream filei=new FileInputStream(".\\src\\test\\resources\\contacttestdata.xlsx");
    	   Workbook wb=WorkbookFactory.create(filei);
    	   String value = wb.getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
    	   return value;
       }
}
