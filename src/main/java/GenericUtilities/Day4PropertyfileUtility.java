package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * 
 * This class consists of generic methods related to property file
 * @author Rasigha K Y
 */
public class Day4PropertyfileUtility {
	
    /**
     * This method will read data from property file and return the value to caller
     * @param key
     * @return
     * @throws IOException
     */
	public String readDataFromUtilityFile(String key) throws IOException
	{
		FileInputStream filei=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
	    p.load(filei);
	    String value = p.getProperty(key);
		return value;
	    
	}
}
