package seleniumFrameworkPractice.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtility {
	XSSFWorkbook workbook;
	FileInputStream fis;

	public int getColumnNumber(String filename, String columnName) throws IOException {
		fis = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fis);
		XSSFSheet sheetObj = workbook.getSheetAt(0);
		Iterator<Row> rows = sheetObj.rowIterator();

		Iterator<Cell> cells = rows.next().cellIterator();
		int col_position = 0;
		while (cells.hasNext()) {
			if (cells.next().getStringCellValue().equalsIgnoreCase(columnName)) {
				break;
			}
			col_position++;
		}
		return col_position;
	}

	public int getRowNumber(String filename, String fruitName) throws IOException

	{
		fis = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fis);
		XSSFSheet sheetObj = workbook.getSheetAt(0);
		Iterator<Row> rows = sheetObj.rowIterator();
		int col_position=getColumnNumber(filename, "fruit_name");
		int row_position = 1;
		rows.next();
		while (rows.hasNext()) {
			
			if (rows.next().getCell(col_position).getStringCellValue()
					.equalsIgnoreCase(fruitName)) {
				
				break;
			}
			
			row_position++;
		
		}
		return row_position;

	}

	public void updateCell(String filename, int row, int col, String value) throws IOException {
		fis = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fis);
		XSSFSheet sheetObj = workbook.getSheetAt(0);
		sheetObj.getRow(row).getCell(col).setCellValue(value);

		FileOutputStream fos = new FileOutputStream(filename);
		workbook.write(fos);
		fos.close();
	}

}