package genericLibrary;

	import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
	import java.util.Properties;

	import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class FileLib {
		public  String getDataFromProperty(String propPath,String key) throws IOException {
			FileInputStream f=new FileInputStream(propPath);
			Properties p=new Properties();
			p.load(f);
			return p.getProperty(key);
		}
		public  String getDataFromExcelSheet(String excelPath,String sheetName,int rowNo,int cellNo) throws Exception {
			FileInputStream fis=new FileInputStream(excelPath);
			Workbook book=WorkbookFactory.create(fis);
			Sheet sheet=book.getSheet(sheetName);
			return sheet.getRow(rowNo).getCell(cellNo).toString();

	}

		public void toWriteDataIntoExcelSheet(String excelPath,String sheetName,int rowNo,int cellNo,String value) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream(excelPath);
			Workbook book=WorkbookFactory.create(fis);
			Sheet sheet=book.getSheet(sheetName);
			Row row = sheet.createRow(rowNo);
			row.createCell(cellNo).setCellValue(value);
			
			FileOutputStream fos=new FileOutputStream(excelPath);
			book.write(fos);
	
		}
	}


