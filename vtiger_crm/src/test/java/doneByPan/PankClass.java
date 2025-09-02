package doneByPan;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PankClass {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("D:\\java e\\vtiger_crm\\src\\test\\resources\\Vtiger.xlsx");
	
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Raa1");
		int  value = (int) sh.getRow(1).getCell(1).getNumericCellValue();
		System.out.println(value);

	}

}
