package com.geekster.fetch_Data_Using_Java;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class FetchDataUsingJavaApplication {

	public static void main(String[] args) throws Exception {
		URL getUrl = new URL("https://api.chucknorris.io/jokes/random");
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();

		if(responseCode==200){
			BufferedReader in = new BufferedReader(new InputStreamReader((connection.getInputStream())));
			StringBuffer jsonResponseData = new StringBuffer();
			String readLine = null;

			while((readLine = in.readLine())!=null){
				jsonResponseData.append(readLine);
			}
			in.close();

			JSONObject obj = new JSONObject(jsonResponseData.toString());
//			System.out.println("Output -");
			System.out.println(obj);
//			To make json beautify and readable
//			System.out.println("\n Beautified JSON  -");
//			System.out.println(obj.toString(3));

		}else{
			System.out.println("Error - " + responseCode);
		}
	}

}
