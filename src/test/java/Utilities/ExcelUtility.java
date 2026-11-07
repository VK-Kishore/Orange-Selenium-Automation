package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.InputStream;

public class ExcelUtility {

    public static Object[][] getLoginData() {

        try (
                InputStream input =
                        ExcelUtility.class.getClassLoader()
                                .getResourceAsStream("testdata.xlsx");///Read the Excel file

                XSSFWorkbook workbook = new XSSFWorkbook(input)  /////Open workbook
        ) {

            Sheet sheet = workbook.getSheet("LoginData");///Select worksheet

            int rows = sheet.getPhysicalNumberOfRows();////Gets number of populated rows

            Object[][] data = new Object[rows - 1][3];

            DataFormatter formatter = new DataFormatter();///Reads cell values as strings

            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);
                data[i - 1][0] =
                        formatter.formatCellValue(row.getCell(0));///Read values
                data[i - 1][1] =
                        formatter.formatCellValue(row.getCell(1));///Read values
                data[i - 1][2] =
                        Boolean.parseBoolean(
                                formatter.formatCellValue(row.getCell(2))////Convert TRUE/FALSE
                        );
            }

            return data;

        } catch (Exception e) {
            throw new RuntimeException("Excel reading failed", e);
        }
    }
}
