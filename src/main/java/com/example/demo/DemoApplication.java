package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.example.demo.json.tests.CreateJsonTests;
import com.example.demo.mongodb.ClientConnect;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		/* Connection main */
		ClientConnect mongoClient = new ClientConnect();
		mongoClient.connect();
	}
}
