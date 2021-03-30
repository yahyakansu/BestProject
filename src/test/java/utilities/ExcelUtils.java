package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtils {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFCell cell;
    private static String excelPath;

    /***
     * excel file open
     * @param path
     * @param sheetName
     */
    public static void openExcelFile(String path,String sheetName){
        excelPath=path;
        try {
            FileInputStream inputStream = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * read cell value
     * @param rowNum
     * @param cellNum
     * @return
     */
    public static String getCellData(int rowNum,int cellNum){
        try{
            String cellValue = sheet.getRow(rowNum).getCell(cellNum).toString();
            return cellValue;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    /***
     * write to excel
     * @param rowNum
     * @param cellNum
     * @param value
     */
    public static void setCellValue(int rowNum,int cellNum,String value){
        try {
            if (sheet.getRow(rowNum)==null){
                sheet.createRow(rowNum);
            }
            sheet.getRow(rowNum).createCell(cellNum);
            cell = sheet.getRow(rowNum).getCell(cellNum);
            cell.setCellValue(value);

            FileOutputStream outputStream = new FileOutputStream(excelPath);
            workbook.write(outputStream);
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int getRowsNum(){
        try {
            return sheet.getPhysicalNumberOfRows();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
