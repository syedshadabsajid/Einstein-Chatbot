package dataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;
 
public class CsvReader {
	static String path;
	public CsvReader(String getPath) {
		path = getPath;
	}
	
	@SuppressWarnings("resource")
	public static String getCellValue(int i, int j) throws IOException {
		Reader reader = new FileReader(path);
		CSVReader csvreader = new CSVReader(reader);
		List<String[]> data = csvreader.readAll();
		reader.close();
		return data.get(i)[j];
		
	}
	
	public static String[][] readDataCsv(int startRow, int endRow, int columnCount) {
        
        try {
        		System.out.println("Enter");
                int rowCount = endRow ;
              
                List<List<String>> data = new ArrayList<List<String>>();
                for (int i = 1 + startRow; i < rowCount + 1 + startRow; i++) {
                    List<String> rowData = new ArrayList<String>();
                    for (int j = 0; j < columnCount; j++) {
                        String var_name = getCellValue(i, j);
                        if (var_name != null && ! var_name.trim().isEmpty()) {
                            rowData.add(var_name);
                        }
                        else {
                        	rowData.add("Empty data");
                        }
                    }
                    if (! rowData.isEmpty()) {
                        data.add(rowData);
                    }
                }
                String[][] dataArray = new String[rowCount][columnCount];
                int rowIndex = 0;
                for (List<String> row : data) {
                    int colIndex = 0;
                    for (String rowData : row) {
                        dataArray[rowIndex][colIndex++] = rowData;
                    }
                    rowIndex++;
                }
                return dataArray;
        
        } catch (Exception e) {
            e.printStackTrace();
            return new String[][] {{}};
        }
    }
	
	public static String[][] readDataCsv(int startRow, int endRow) {
        // String filePath = path;
        try {
        		System.out.println("Enter");
                int rowCount = endRow ;
                int columnCount = 35;
                List<List<String>> data = new ArrayList<List<String>>();
                for (int i = 1 + startRow; i < rowCount + 1 + startRow; i++) {
                    List<String> rowData = new ArrayList<String>();
                    for (int j = 0; j < columnCount; j++) {
                        String var_name = getCellValue(i, j);
                        if (var_name != null && ! var_name.trim().isEmpty()) {
                            rowData.add(var_name);
                        }
                        else {
                        	rowData.add("Empty data");
                        }
                    }
                    if (! rowData.isEmpty()) {
                        data.add(rowData);
                    }
                }
                String[][] dataArray = new String[rowCount][columnCount];
                int rowIndex = 0;
                for (List<String> row : data) {
                    int colIndex = 0;
                    for (String rowData : row) {
                        dataArray[rowIndex][colIndex++] = rowData;
                    }
                    rowIndex++;
                }
                return dataArray;
        
        } catch (Exception e) {
            e.printStackTrace();
            return new String[][] {{}};
        }
    }
}
