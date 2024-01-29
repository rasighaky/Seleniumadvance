package Session1;

import org.testng.annotations.Test;

public class Day19ReadDataFromCmdLine {

	
	@Test
	public void Read()
	{
		String UN=System.getProperty("username");
		System.out.println(UN);
		
		String PW=System.getProperty("password");
		System.out.println(PW);
	}
}
