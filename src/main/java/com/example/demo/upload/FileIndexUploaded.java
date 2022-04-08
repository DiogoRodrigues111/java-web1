package com.example.demo.upload;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	 * Universal iterator
	 */
	private File[] UniversalFile;
	
	/**
	 * @return the universalFile
	 */
	public File[] getUniversalFile() {
		return UniversalFile;
	}

	/**
	 * @param universalFile the universalFile to set
	 */
	public void setUniversalFile(File[] universalFile) {
		UniversalFile = universalFile;
	}

	/**
	 * Function for shake in html.
	 * 
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
	@RequestMapping(path = "/indexpage", method = RequestMethod.POST)
	public void UploadedValid(String pathValid, Model model) {

		File file = new File(pathValid);
		File[] files = file.listFiles();
		
		// check all files for iterator found all.
		setFiles( files );

		// select images DIV.
		for (File it : getFiles()) {
			
			boolean terminateWithImage = (  it.getName().endsWith(".jpg") 
										 || it.getName().endsWith(".png") 
										 || it.getName().endsWith(".jpeg") 
										 || it.getName().endsWith(".webp")
										) == true;
			
			boolean terminateWithVideo = (  it.getName().endsWith(".mp4") 
											||  it.getName().endsWith(".webm") 
										) == true;
					
			if ( terminateWithImage ) {
				// images attr.
				model.addAttribute("filesItImages", getFiles());
			}
			
			if ( terminateWithVideo ) {
				// videos attr.
				model.addAttribute("filesItVideos", getFiles());
			}
		}
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
