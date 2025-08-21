package Selenium_TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class Lab14_excel {

    public static Object[][] getSheetData(String filePath, String sheetName) {
        Object[][] data = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook wb = WorkbookFactory.create(fis)) {

            Sheet sheet = wb.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rows - 1][cols];

            for (int i = 1; i < rows; i++) { // Skip header row
                Row row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);

                    if (cell == null) {
                        data[i - 1][j] = "";
                    } else {
                        switch (cell.getCellType()) {
                            case STRING:
                                data[i - 1][j] = cell.getStringCellValue();
                                break;

                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    data[i - 1][j] = cell.getDateCellValue().toString();
                                } else {
                                    // ✅ Convert numeric to long → String (avoid scientific notation)
                                    data[i - 1][j] = String.valueOf((long) cell.getNumericCellValue());
                                }
                                break;

                            case BOOLEAN:
                                data[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
                                break;

                            default:
                                data[i - 1][j] = "";
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
