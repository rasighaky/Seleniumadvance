package Session1;

import java.io.IOException;

import GenericUtilities.Day4ExcelfileUtility;
import GenericUtilities.Day4PropertyfileUtility;
import GenericUtilities.Day5DateUtility;

public class Day4genericmethod {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//read data from propertyfile
      Day4PropertyfileUtility pr=new Day4PropertyfileUtility();
      String val = pr.readDataFromUtilityFile("url");
      System.out.println(val);
		
		//read data from excelfile
		Day4ExcelfileUtility ex=new Day4ExcelfileUtility();
		String val1 = ex.readDataFromExcel(4, 3);
		System.out.println(val1);
		
		//java utility
		Day5DateUtility ja=new Day5DateUtility();
		System.out.println(ja.getSystemDate());
	}

}
