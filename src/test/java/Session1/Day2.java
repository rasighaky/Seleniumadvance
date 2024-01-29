package Session1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Day2 {
	public static void main(String[] args) throws IOException {
	
		//Step 1: open the document in java readable format
		FileInputStream filei=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step 2:create object for properties from java.util
		Properties prope=new Properties();
		
		//step 3:load filei to the property class
		prope.load(filei);
		
		//step 4:provide the key and read the value
		String URL = prope.getProperty("username");
		System.out.println(URL);  
		
	}
}
