package com.example.demo.upload;

import java.io.File;

import org.springframework.ui.Model;

public class FileIndexUploaded {
	
	public static final String _ORIGINAL_LOCATION
		= "src/main/resources/static/uploaded/";
	
	/**
	 * Function for shake in html.
	 * 
	 * This do an Iterator of the files on web path root.
	 * 
	 * @param pathValid
	 * 	web path root.
	 * 
	 * @param model
	 * 	@see 	{@link Model}
	 * 	for add attribute (String, Object)
	 * 
	 * @return
	 * 	IndexPage of the html.
	 */
	public String UploadedValid(String pathValid, Model model) {
		File file = new File(pathValid);
		File files[] = file.listFiles();
		
		for (File it : files) {
			
			// replace originals values for new values.
			String replaceIt = pathValid.replace(_ORIGINAL_LOCATION, "uploaded/" + it.getName());
			
			// make it in html page.
			model.addAttribute("filesIt", replaceIt);
			
			// only check it for me.
			System.out.println("Checking file is valid: " + it);
		}
		
		return "indexpage";
	}
}
