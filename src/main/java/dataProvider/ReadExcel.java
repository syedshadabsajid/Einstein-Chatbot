package dataProvider;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    public static String[][] readDataExcel(String path, int startRow, int endRow) {
        String filePath = path;
        try {
            Workbook workbook = new XSSFWorkbook(filePath);
            XSSFSheet sheet = (XSSFSheet) workbook.getSheet("Sheet1");
                int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
                rowCount = endRow ;
                int columnCount = 24;
                List<List<String>> data = new ArrayList<List<String>>();
                for (int i = 1 + startRow; i < rowCount + 1 + startRow; i++) {
                    Row row = sheet.getRow(i);
                    List<String> rowData = new ArrayList<String>();
                    for (int j = 0; j < columnCount; j++) {
                        Cell cell = row.getCell(j);
                        DataFormatter formatter = new DataFormatter();
                        String var_name = formatter.formatCellValue(cell);
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
                // workbook.close();
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
