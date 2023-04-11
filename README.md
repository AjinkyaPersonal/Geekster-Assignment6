# Geekster-Assignment6
This is a README file that provides instructions on how to fetch jokes from a Jokes API in a Spring Boot project using Java.
Follow the steps below to get started.

## Step 1 :  Choose a Jokes API
There are several Jokes APIs available on the internet.
You can choose any Jokes API that provides joke data in a format that suits your needs. 
The one I have used is "JokeAPI" (https://api.chucknorris.io/jokes/random) .
Visit the API documentation to understand how to interact with the API and retrieve joke data.

## Step 2: Set Up Your Spring Boot Project
Create a new Spring Boot project in your preferred IDE (Integrated Development Environment) or 
by using the Spring Initializer (https://start.spring.io/). 
Make sure you have Java JDK (Java Development Kit) installed on your system.

## Step 3: 
Depending on the API you choose, 
you may need to add dependencies to your Spring Boot project to make HTTP requests and parse JSON data.
Popular libraries for these tasks are "Spring Web" for making HTTP requests and Spring Boot DevTools for providing fast application restarts, LiveReload, and configurations 
for enhanced development experience .You can add these libraries to your project by including them as 
dependencies in your Maven file.<br>

For Maven, add the following dependencies in your pom.xml file:

* Json dependency
```xml - json dependency
<dependency>
	<groupId>org.json</groupId>
	<artifactId>json</artifactId>
  <version>20160810</version>
</dependency>
```

* spring boot dev tools
```xml - spring boot dev tools dependency
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
	<scope>runtime</scope>
	<optional>true</optional>
 </dependency>
```

* spring web dependency 
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
```

## Step 4: Write Java Code
In your Spring Boot project, write code to fetch jokes from the Jokes API.
Here's an example of how you can fetch jokes from the "JokeAPI" using Spring Boot:

```Java
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
```

**Note: ** The above code assumes that the Jokes API returns a JSON object with a "joke" field that contains the joke data. 
You may need to modify the code to match the structure of the JSON response from your chosen API.

## Step 5: Run Your Spring Boot Application
Compile and run your Spring Boot application to fetch jokes from the Jokes API. 
You should see the joke data printed to the console

