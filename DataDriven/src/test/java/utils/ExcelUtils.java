package utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    private final Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);
    XSSFSheet sheet;

    public void readExcelSheet(String filePath, String fileName, String sheetName){

        try (FileInputStream fis = new FileInputStream(filePath + fileName)) {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            LOGGER.error("Excel file not found in the provided path : {}",fileName, e);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getCellValue(int row, int col){
        String cellValue = null;
        XSSFCell cell = sheet.getRow(row).getCell(col);
        CellType cellType = cell.getCellType();
        switch (cellType) {
            case _NONE:
            case BLANK:
                cellValue = "";
                break;
            case NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case STRING:
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case ERROR:
                break;
            default:
                throw new IllegalStateException("Unexpected CellType: " + cellType);
        }
        return cellValue;
    }
}
