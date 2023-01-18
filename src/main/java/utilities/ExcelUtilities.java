package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
	
	
	
	public static String[][] getExcelData(String worksheet) throws EncryptedDocumentException, IOException {
		
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\SalesforceData.xlsx");
		FileInputStream fis =new FileInputStream(f);
		Workbook workbook1 = WorkbookFactory.create(fis);
		Sheet loginSheet = workbook1.getSheet(worksheet);
		
		int totalRows = loginSheet.getLastRowNum();
		int totalcolumns = loginSheet.getRow(0).getLastCellNum();
		DataFormatter format = new DataFormatter();
		
		String testdata[][] = new String[totalRows][totalcolumns];
		
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalcolumns;j++) {
				testdata[i-1][j] = format.formatCellValue(loginSheet.getRow(i).getCell(j));
				System.out.println(testdata[i-1][j]);
			}
		}
		
		
		return testdata;
		
	}

}
