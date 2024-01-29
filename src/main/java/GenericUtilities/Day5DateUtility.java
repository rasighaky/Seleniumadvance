package GenericUtilities;

import java.util.Date;

/**
 * THis class contains o generic method related to java
 * @author kymon
 *
 */

//Day5javautility
public class Day5DateUtility {
/*
 * This method will contains system date in required format
 */
	public String getSystemDate()
{
		Date d =new Date();
		// return d.toString();
		String[] darr = d.toString().split(" ");
		String date = darr[2]+"-"+darr[1]+"-"+darr[5]+"_"+darr[3].replace(":","-");
		return date;
		
		}

}
