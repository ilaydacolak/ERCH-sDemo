package com.erc.http;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;;
public class HttpRequestHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpRequestHandler handler = new HttpRequestHandler();
		try {
			handler.post("https://avicennakimo.erc-grup.com.tr:2022/get-short-url");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void post(String uri) throws Exception {
		
		URL url = new URL (uri);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		String jsonInputString ="{ \"token\": \"eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjI1MzQyODQ4MDAsImFwcElkIjoiYXZpY2VubmFraW1vZXJjIiwiY2xhaW1lcnMiOnsic2Vzc2lvbklkIjoiMSIsInJvb21OYW1lIjoiU2F6YWtBaWxlc2kiLCJhdHRlbmRlclR5cGUiOiJ0ZXN0dHQiLCJtb2RlcmF0b3JObyI6IjEiLCJtb2RlcmF0b3JOYW1lIjoiRW1pbiBTYXphayIsImF0dGVuZGVyTm8iOiIyIiwiYXR0ZW5kZXJOYW1lIjoiQWlsZSJ9fQ.CH3tsGhKeBdh_DITi2cjbOhbIkiXe3zO5sMZ3mcth3g\" " + 
				"}";
		
		byte[] postData       = jsonInputString.getBytes( StandardCharsets.UTF_8 );
		int    postDataLength = postData.length;
		con.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
		System.out.println(Integer.toString( postDataLength )); 
		System.out.println(jsonInputString);
		
		try(OutputStream os = con.getOutputStream()) {
		    byte[] input = jsonInputString.getBytes("utf-8");
		    os.write(input, 0, input.length);           
		}
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
		}
		con.getResponseCode();
		con.disconnect();
		
	}
 
}
