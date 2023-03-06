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

	public FileIndexUploaded() {}

	public FileIndexUploaded(File[] files) {

	}

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
	 * Function for shake in html.
	 * 
	 * This do an Iterator of the files on web path root.
	 * 
	 * Lists files on Server Folder.
	 * 
	 * *** REMOVED support to images. ***
	 * 
	 * @param pathValid
	 * 	web path root, not necessary put '/' slash.
	 * 
	 * @param model
	 * 	@see 	{@link Model}
	 * 	for add attribute (String, Object)
	 * 
	 * @return
	 * 	IndexPage of the HTML.
	 */
	public File[] UploadedValid(String pathValid, Model html) {
		
		File file = new File(pathValid);
		File[] files = file.listFiles();

		setFiles( files );

		html.addAttribute("videos".replace("[]", ""), getFiles());

		return files;
	}
	
	/**
	 * Create Directory on File System.
	 * 
	 * @param nameDir
	 * 	Name of the channel.
	 */
	public void createDirectoryIfNotExist() {
		File dir = new File( _ORIGINAL_LOCATION );
		boolean create = dir.mkdirs();
		if ( create ) return /* SUCCESS */;
	}
}
