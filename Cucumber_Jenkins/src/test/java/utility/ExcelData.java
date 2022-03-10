package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	public Object[] getExcelData(String path) throws IOException {
		Object[] data = new Object[1];
		FileInputStream fileStream = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
		int count = workbook.getSheetIndex("search data");
		XSSFSheet sheet = workbook.getSheetAt(count);
		Iterator<Row> rows = sheet.rowIterator();
		Row firstRow = rows.next();
		int i = 0;
		Iterator<Cell> cells = firstRow.cellIterator();
		while(cells.hasNext()) {
			data[i] = cells.next().getStringCellValue();
			i++;
		}
		workbook.close();
		return data;
	}
}
