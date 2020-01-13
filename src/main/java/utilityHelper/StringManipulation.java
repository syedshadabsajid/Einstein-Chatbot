package utilityHelper;

public class StringManipulation {
	
	public static String removeSpecialChar(String norStr) {
		norStr = norStr.replaceAll("[^a-zA-Z0-9_-]", "");
		return norStr.replace("-", "");
	}
	
	public static int toInt(String value) {
		Integer number = Integer.parseInt(value);
		return number;
	}
	
}
