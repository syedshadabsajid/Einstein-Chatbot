package dataProvider;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ReadDataFromApi {
	private static Header oauthHeader;
	private static String accessToken = "";
	private static String instanceUrl = "";

	public static String[][] getDataFromSales() throws ParseException, IOException {

		System.out.println("----------getting a token---------");

		HttpClient httpclient = new HttpClient();
		httpclient.getParams().setParameter(HttpClientParams.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);
		PostMethod post = new PostMethod("https://test.salesforce.com/services/oauth2/token");

		post.addParameter("username", "mukul.p@spinsci.com.dev");
		post.addParameter("password", "welcome12#FpKsLiyZBXz7s9osChBLGy7Q");
		post.addParameter("grant_type", "password");
		post.addParameter("client_id",
				"3MVG9WtWSKUDG.x5pCimilQ3fIs_RVsgS_G_UWe7Ljrcbm2i17kDWX489vDhCisEW6AXkstEmeJeFdVxh4JD_");
		post.addParameter("client_secret", "0364879C56004D027878977E0301A8975C056DB5DEE7A935F36C919E09BB205A");

		try {
			httpclient.executeMethod(post);
			JSONObject authResponse = new JSONObject(
					new JSONTokener(new InputStreamReader(post.getResponseBodyAsStream())));
			System.out.println("Auth Response :-" + authResponse.toString(2));

			accessToken = authResponse.getString("access_token");
			instanceUrl = authResponse.getString("instance_url");
			
			System.out.println("Got Access Token " + accessToken);
			System.out.println("Got Instance Url " + instanceUrl);
		}
		catch (Exception e) {
			System.out.println("Exception during Connect" + e);
		}
		String[][] data = readDataFromAPI(accessToken);
		return data;
	}

	public static String[][] readDataFromAPI(String token) throws ParseException, IOException {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		String uri = "https://nahr--fullglccb.cs25.my.salesforce.com/services/data/v48.0/query/?q=Select+id%2CName__c%2CIntent__r.Intent_Unique_Key__c+from+Utterance__c+where+Automation_Required__c%3Dtrue";
		
		HttpGet httpGet = new HttpGet(uri);
		oauthHeader = new BasicHeader("Authorization", "Bearer " + token);
		httpGet.addHeader(oauthHeader);

		HttpResponse response = null;

		// Make the request.
		try {
			response = httpClient.execute(httpGet);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Process the result
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("response-->> " + statusCode);
		

		List<List<String>> data = new ArrayList<List<String>>();
		
		String json_string = EntityUtils.toString(response.getEntity());
		JSONObject temp1 = new JSONObject(json_string);

		// Getting JSON Array node
		JSONArray contacts = temp1.getJSONArray("records");

		// looping through All Contacts
		for (int i = 0; i < contacts.length(); i++) {
			JSONObject c = contacts.getJSONObject(i);
			String chat = c.getString("Name__c");
			JSONObject objRes = c.getJSONObject("Intent__r");
			String res = objRes.getString("Intent_Unique_Key__c");
			List<String> rowData = new ArrayList<String>();
			rowData.add(chat);
			rowData.add(res);
			data.add(rowData);
			System.out.println(chat + "-" + res);
		}
		 String[][] dataArray = new String[data.size()][2];
         int rowIndex = 0;
         for (List<String> row : data) {
             int colIndex = 0;
             for (String rowData : row) {
                 dataArray[rowIndex][colIndex++] = rowData;
             }
             rowIndex++;
         }
         return dataArray;
		
	}
}
