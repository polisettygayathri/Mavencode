package Maven.Selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class GetHSSFSheet {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(".\\TestData\\Register.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println("No of Rows are: " + rowCount);
		System.out.println("No of Columns are: " + columnCount);
		for (int i = 1; i <= rowCount; i++) {
			String fName = sheet.getRow(i).getCell(0).toString();
			String address = sheet.getRow(i).getCell(3).toString();
			System.out.println("FirstName: " + fName);
			System.out.println("address: " + address);
			System.out.println("===============" + i + "======================");
		}

	}
}
