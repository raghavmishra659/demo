package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public String getDataFromExcel() throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("D:\\java e\\vtiger_crm\\src\\test\\resources\\Vtiger.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet("Raa1");

		String value = sh.getRow(1).getCell(0).getStringCellValue() + (int) (Math.random() * 9999);
		
		return value;
	}

}
