package practice.data_provider;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataSequence {
	
	@Test (dataProvider="dp")
	public void firstTest(String id, String account) {
		System.out.println("Test #1 with data: "+id+". "+account);
		assertTrue(true);
	}
	
	@Test (dataProvider="dp")
	public void secondTest(String id, String account) {
		System.out.println("Test #2 with data: "+id+". "+account);
		assertTrue(true);
	}
	
	@DataProvider(name="dp")
	public static Object[][] dataProvider() {
		Object[][] dataArray = {
				{"1", "user1"},
				{"2", "user2"}
		};
		return dataArray;
	}
}
