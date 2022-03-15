package com.example.demo.upload;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * File HTML IndexPage
 * 
 * Occur where file is uploaded, for the /indexpage HTML page.
 */
@Data
@Slf4j
@Service
@Getter
@Builder
public class FileIndexUploaded {
	
	// Original location Server file path.
	public static final String _ORIGINAL_LOCATION
		= "src/main/resources/static/uploaded/";

	/**
	 * This do an Iterator of the files on web path root.
	 * 
	 * Lists files on Server Folder.
	 * 
	 * @param pathValid
	 * 	web path root.
	 * 
	 * @param model
	 * 	@see 	{@link Model}
	 * 	for add attribute (String, Object)
	 * 
	 * @return
	 * 	IndexPage of the HTML.
	 */
	public String UploadedValid(String pathValid, Model model) {

		File file = new File(pathValid);
		File[] files = file.listFiles();

		for (File it : files) {

			boolean boolImg = (it.getPath().endsWith(".jpg") || it.getPath().endsWith(".png") || 
				it.getPath().endsWith(".webp") || it.getPath().endsWith(".jpeg"));

			if (boolImg) {
				
				// get all images, but not only last.
				String _img = pathValid.replace(_ORIGINAL_LOCATION, "uploaded/" + it.getName());

				// add attribute for HTML page.
				model.addAttribute("images", _img);
			}

			boolean boolVid = (it.getPath().endsWith(".mp4") || it.getPath().endsWith(".webm"));

			if (boolVid) {

				// add attribute for HTML page.
				model.addAttribute("videos",  pathValid.replace(_ORIGINAL_LOCATION, "uploaded/" + it.getName()));
			}

			// only check it for me.
			System.out.println("Checking file is valid: " + it);
		}
		
		return "indexpage";
	}
}
