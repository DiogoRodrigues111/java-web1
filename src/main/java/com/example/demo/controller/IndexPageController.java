package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.annotation.DontUse;
import com.example.demo.html.list.FileLoaded;
import com.example.demo.html.list.ListFiles;

@Controller
public class IndexPageController {

	ListFiles listFiles;
	FileLoaded loaded;
	
	public static final String _LOCATION_FILE_FOR_UPLOAD
		= "src/main/resources/static/uploaded/";
	
	@DontUse
	public MultipartFile doingMultipart(@RequestParam("video_found") MultipartFile fi, String dir) {
		listFiles = new ListFiles(dir, fi);
		listFiles.setFileUploaded(fi);
		return listFiles.getFileUploaded();
	}
	
	@RequestMapping("/indexpage")
	public String doMakeFileIt() {
		
		loaded = new FileLoaded();
		
		listFiles = new ListFiles(
				listFiles.makeFile(),
				doingMultipart(loaded.getFileUploaded(), _LOCATION_FILE_FOR_UPLOAD));
		
		return "indexpage";
	}
	
	@RequestMapping("/indexpage")
	public String indexPage() {
		return "indexpage";
	}
}
