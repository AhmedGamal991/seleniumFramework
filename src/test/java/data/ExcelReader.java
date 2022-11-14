package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static FileInputStream fis = null;

	public FileInputStream getFileInputStream() {
		String filepath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\userdata.xlsx";
		File srcFile = new File(filepath);
		try {
			fis = new FileInputStream(srcFile);

		} catch (FileNotFoundException e) {
			System.out.println(" File Doesn`t Exist !! Check file path");
		}
		return fis;
	}

	public Object[][] getExelDate() throws IOException {
		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int totleNumOfRows = (sheet.getLastRowNum() + 1);
		int totleNumOfCols = 4;
		String[][] arrayExcelData = new String[totleNumOfRows][totleNumOfCols];
		for (int i = 0; i < totleNumOfRows; i++) {
			for (int j = 0; j < totleNumOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).getStringCellValue();
			}
		}
		wb.close();
		return arrayExcelData;

	}
}
