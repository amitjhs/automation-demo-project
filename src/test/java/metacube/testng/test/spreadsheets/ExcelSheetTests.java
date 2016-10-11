package metacube.testng.test.spreadsheets;
import java.io.IOException;

import metacube.testng.testconstants.TestConstants;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gdata.util.ServiceException;
import com.metacube.testng.FrameworkHelper.AppConstants;
import com.metacube.testng.FrameworkHelper.Excel;
import com.metacube.testng.FrameworkHelper.MAssert;
import com.metacube.testng.FrameworkHelper.Prop;

public class ExcelSheetTests {

	@BeforeMethod
	public void InitMethod() {
	}

	@Test
	public void ReadExcelCell() throws IOException, ServiceException {
		String cell = "";
		try {

			cell = Excel.ReadCell(TestConstants.ExcelFilePath + "exceldata.xls","first",1,1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MAssert.assertAreEqual( cell,"B2");
	}

	@Test
	public void ReadExcelSheet() throws IOException, ServiceException {

		String[][] sheet={};
		try {
			sheet = Excel.ReadExcelSheet(TestConstants.ExcelFilePath + "exceldata.xls","first");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int noOfRows = 2;
		int noOfcols = 3;
		for(int row = 0; row < noOfRows; row++)
		{
			for(int col = 0; col < noOfcols; col++)
			{
				System.out.println(sheet[row][col]);
			}
		}
		MAssert.assertAreEqual("B2","B2");
	}
	
	@AfterClass
	public void CloseClass() {

	}
}
