package dataProvider;
import java.io.IOException;

import org.testng.annotations.DataProvider;
	 
	public class ScedularDataProvider 
	{
		static int count = 0;
		static String[] nextLine;
		
				
		@DataProvider(name = "VWVehicle")
	    public static Object[][] dataProviderMethod() throws IOException 
	    {
//	    	String[][] returnObject = new String[2][3];
//	    	System.out.print(CsvReader.getCellValue(1, 12));
//	    	returnObject[0][1] = CsvReader.getCellValue(1, 2);
//	    	returnObject[0][2] = CsvReader.getCellValue(1, 12);
//	    	returnObject[0][3] = CsvReader.getCellValue(1, 13);
//	    	returnObject[1][1] = CsvReader.getCellValue(2, 2);
//	    	returnObject[1][2] = CsvReader.getCellValue(2, 12);
//	    	returnObject[1][3] = CsvReader.getCellValue(2, 13);
//	    	
//	    	return returnObject;
	    	
	    	
	    	return new Object[][] {
	    	      // new Object[] { CsvReader.getCellValue(1, 2), CsvReader.getCellValue(1, 12), CsvReader.getCellValue(1, 13) },
	    	      // new Object[] { CsvReader.getCellValue(2, 2), CsvReader.getCellValue(2, 12), CsvReader.getCellValue(2, 13) }
	    	      };
	    	

	    	
	}
	}
