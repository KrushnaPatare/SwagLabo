package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterization {

	public static String getExelData(String sheetname, int rowNum, int cellNum) throws EncryptedDocumentException, IOException   {
		
	FileInputStream file = new FileInputStream("F:\\WorkSpace\\SwagLabs\\src\\test\\resources\\TestData.xlsx");
	
	String value = WorkbookFactory.create(file).getSheet(sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
	
	return value;
}
}