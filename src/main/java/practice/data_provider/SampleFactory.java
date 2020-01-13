package practice.data_provider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import dataProvider.CsvReader;

public class SampleFactory {
	CsvReader csvReader = new CsvReader("C:\\Users\\Anubha.Gupta\\eclipse-workspace\\xperigo\\resources\\vins.csv");
	
	@Factory(dataProvider="vin")
	public Object[] createInstances(String[] tabArray) {
		return new Object[] {new SomeTest(tabArray)};
	}
	
	@DataProvider(name="dp")
	public static Object[][] dataProvider() {
		Object[][] dataArray = {
				{"1", "user1"},
				{"2", "user2"}
		};
		return dataArray;
	}
	
	
	@DataProvider(name="vin")
	public Object[][] Authentication() throws InterruptedException, IOException {
		Object[][] testObjArray = CsvReader.readDataCsv(1, 2);
		System.out.println(testObjArray[0][0]);
		return (testObjArray);
	}

}