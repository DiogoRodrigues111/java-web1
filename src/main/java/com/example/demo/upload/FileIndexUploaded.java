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
	public File[] CheckFileIfVideos;
	

	public File[] getCheckFileIfVideos() {
		return CheckFileIfVideos;
	}

	public void setCheckFileIfVideos(File[] checkFileIfVideos) {
		CheckFileIfVideos = checkFileIfVideos;
	}

	public File[] CheckFIleIfImages;
	

	public File[] getCheckFIleIfImages() {
		return CheckFIleIfImages;
	}

	public void setCheckFIleIfImages(File[] checkFIleIfImages) {
		CheckFIleIfImages = checkFIleIfImages;
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
		
		// check all files for iterator found all.
		setCheckFIleIfImages( files );
		setCheckFileIfVideos( files );

		// select images div.
		for (File it : getCheckFIleIfImages()) {
			
			boolean terminateWithImage = (  it.getName().endsWith(".jpg") 
										 || it.getName().endsWith(".png") 
										 || it.getName().endsWith(".jpeg") 
										 || it.getName().endsWith(".webp")
									);
					
			if (!terminateWithImage) {
				// make it in html page.
				model.addAttribute("filesItImages", getCheckFIleIfImages());
			}
		}

		// select videos div.
		for (File it : getCheckFileIfVideos()) {

			boolean terminateWithVideo = (  it.getName().endsWith(".mp4") 
										||  it.getName().endsWith(".webm") 
											);
			
			if (!terminateWithVideo) {
				// make it in html page.
				model.addAttribute("filesItVideos", getCheckFileIfVideos());
			}								
		}

		return files;
	}
}
