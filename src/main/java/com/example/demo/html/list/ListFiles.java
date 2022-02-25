package com.example.demo.html.list;

import java.io.File;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

public class ListFiles extends FileLoaded {

	public static final String _LOCATION_FILE_FOR_UPLOAD
		= "src/main/resources/static/uploaded/";
	
	public ListFiles(String dir, MultipartFile file) {
		setFileDirectoryPath(dir);
		setFileUploaded(file);
	}
	
	@RequestMapping(path = "/indexpage", method = RequestMethod.POST)
	public String makeFile() {
		
		File file = new File(_LOCATION_FILE_FOR_UPLOAD);
		File listFiles[] = file.listFiles();
		
		for (File it : listFiles) {
			setFileReceive(it);
			
			System.out.printf("The files selected to Iterator is: %s \n", getFileReceive());
		}
		
		return "indexpage";
	}
}