package com.example.demo.upload;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.controller.UploadController;

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

	FilesUpload uploadFS;
	
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
	@RequestMapping(path = "/indexpage", method = RequestMethod.POST)
	public File[] UploadedValid(Model html) {
		
		uploadFS = new FilesUpload();
		uploadFS.setPathDirectory(_ORIGINAL_LOCATION);
		
		File file = new File(uploadFS.getPathDirectory());
		File[] files = file.listFiles();

		setFiles( files );

		for (File it : getFiles()) {
			
			html.addAttribute("videos", it);
			
			// check its for me.
			System.out.println("TAG: Info - " + it);
		}
		
		return files;
	}
	
	/**
	 * Create Directory on File System.
	 * 
	 * @param nameDir
	 * 	Name of the channel.
	 */
	public void createDirectoryIfNotExist(String nameDir) {
		File dir = new File(_ORIGINAL_LOCATION + nameDir);
		boolean create = dir.mkdirs();
		if ( create ) return /* SUCCESS */;
	}
}
