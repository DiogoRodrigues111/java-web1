package com.example.demo.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class ClientConnect {

	@SuppressWarnings("null")
	public void connect() {
		MongoClient client = null;
		
		try {
			client = new MongoClient("127.0.0.1", 27017);
			
			System.out.println("Connecting with MongoDB has successful.");
		} catch (MongoException mongo_ex) {
			mongo_ex.printStackTrace();
		}
		finally {
			if (client == null)
				client.close();
		}
	}
}
