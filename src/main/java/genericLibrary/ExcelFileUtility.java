package genericLibrary;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	public String readDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELFILEPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sn = wb.getSheet(sheetName);
		Row rn = sn.getRow(rowNum);
		Cell cn = rn.getCell(cellNum);
		String value = cn.getStringCellValue();
		return value;
		
	}
}
