package practice.data_provider;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SomeTest {
	
	private String id = "";
	private String account = "";
	
	public SomeTest(String[] tabArray) {
		this.id = (String) tabArray[0];
		this.account = (String) tabArray[1];
	}
	
	@BeforeTest
	public void setup() {
		System.out.println("befor test ");
	}
	
	@BeforeMethod
	public void setupm() {
		System.out.println("befor method ");
	}
	
	@Test
	public void firstTest() {
		System.out.println("Test #1 with data: "+id+". "+account);
		assertTrue(true);
	}
	
	@Test
	public void secondTest() {
		System.out.println("Test #2 with data: "+id+". "+account);
		assertTrue(true);
	}
	
	@Test
	public void thirdTest() {
		System.out.println("Test #3 with data: "+id+". "+account);
		assertTrue(true);
	}

}