package com.example.demo.upload;

import java.io.File;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class FileIndexUploaded {
	
	public static final String _ORIGINAL_LOCATION
		= "src/main/resources/static/uploaded/";
	
	/**
	 * Getter and Setters Files 
	 * 
	 * @see {@link FileIndexUploaded}
	 */
	public File[] Files;

	public File[] getFiles() {
		return Files;
	}

	public void setFiles(File[] files) {
		Files = files;
	}

	/**
	 * Getter and Setters Files 
	 * 
	 * @see {@link FileIndexUploaded}
	 */
	public File PathFileVar;

	public File getPathFileVar() {
		return PathFileVar;
	}

	public void setPathFileVar(File pathFileVar) {
		PathFileVar = pathFileVar;
	}

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
	@RequestMapping(path = "/indexpage", method = RequestMethod.POST)
	public File[] UploadedValid(String pathValid, Model model) {
		File file = new File(pathValid);
		File[] files = file.listFiles();
		
		setFiles( files );
		setPathFileVar( file );
		
		for (File it : getFiles()) {
			// replace originals values for new values.
			//String rplPath = pathValid.replace(_ORIGINAL_LOCATION, "uploaded/" + getCbFile().getName());
			
			// make it in html page.
			model.addAttribute("filesIt", getFiles());
			
			// only check it for me.
			System.out.println("Checking file is valid: " + it);
		}

		return files;
	}
}
