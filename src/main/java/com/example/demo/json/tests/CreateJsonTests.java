package com.example.demo.json.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

/**
 * Create JSON.
 * @author Diogo R. Roessler (c) 2022
 * License MIT (c)
 */
public class CreateJsonTests {
	
	/**
	 * Insert values to json.
	 * @return
	 * 	obj Json.
	 */
	public JSONObject createJson() {
		/* Write on JSON file. */
		JSONObject obj = new JSONObject();
		obj.put("Diogo Roessler JSON new Create", 1);
		
		System.out.println(obj.toString(0));

		return obj;
	}
	
	/**
	 * Save of the json file.
	 */
	public String saveJsonCreated() {
		try {
			/* Create JSON file. */
			FileWriter fw = new FileWriter(new File("C:\\Web\\java\\java-web1\\src\\main\\resources\\static\\json\\testx.json"), true);
			fw.write(createJson().toString());
			fw.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
		// Returns JSON complete.
		return createJson().toString();
	}	
}
