package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.annotation.DontUse;
import com.example.demo.html.list.FileLoaded;
import com.example.demo.html.list.ListFiles;
import com.example.demo.upload.FileIndexUploaded;

@Controller
public class IndexPageController {

	ListFiles listFiles;
	FileLoaded loaded;
	FileIndexUploaded uploadList;
	
	public static final String _LOCATION_FILE_FOR_UPLOAD
		= "src/main/resources/static/uploaded/";
	
	@DontUse
	public MultipartFile doingMultipart(@RequestParam("video_found") MultipartFile fi, String dir) {
		listFiles = new ListFiles(dir, fi);
		listFiles.setFileUploaded(fi);
		return listFiles.getFileUploaded();
	}
	
	@RequestMapping(path = "/indexpage", method = RequestMethod.GET)
	public String fileUploadedList(Model model) {
		
		uploadList = new FileIndexUploaded();
		uploadList.UploadedValid(_LOCATION_FILE_FOR_UPLOAD, model);
		
		return "indexpage";
	}
	
	@RequestMapping("/indexpage")
	public String indexPage() {
		return "indexpage";
	}
}
