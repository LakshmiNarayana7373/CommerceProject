package coomerce.dataprovider;

import org.testng.annotations.DataProvider;

import commerce.utility.NewExcelLibrary;

public class DataProviders {
	
	NewExcelLibrary obj = new NewExcelLibrary();

	//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

		@DataProvider(name = "credentials")
		public Object[][] getCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("LoginTest1");
			// Total Columns
			int column = obj.getColumnCount("LoginTest1");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("LoginTest1", j, i + 2);
				}
			}
			return data;
		}
		@DataProvider(name = "Credentials Registeration")
		public Object[][] getRegister() {
			// Totals rows count
			int rows = obj.getRowCount("Registeration");
			// Total Columns
			int column = obj.getColumnCount("Registeration");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Registeration", j, i + 2);
				}
			}
			return data;
		}

}
