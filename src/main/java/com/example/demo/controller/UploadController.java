package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.upload.FilesUpload;
import com.example.demo.upload.UploadSequenceFiles;

@Controller
public class UploadController {

	UploadSequenceFiles uploadFiles;
	FilesUpload uploadFS;
	
	public static final String _LOCATION_FILE_FOR_UPLOAD
		= "src/main/resources/static/uploaded/";
	
	@RequestMapping(path = "/upload", method = RequestMethod.POST)
	public String uploadFile(
			@RequestParam("file") MultipartFile[] file) {
		
		uploadFS = new FilesUpload();
		uploadFS.setPathDirectory(_LOCATION_FILE_FOR_UPLOAD);
		
		for (MultipartFile fi : file) {
			uploadFiles = new UploadSequenceFiles(uploadFS.getPathDirectory(), fi);
			uploadFiles.createFileSystem(uploadFS.getPathDirectory(), fi.getOriginalFilename());
		}
		
		return "upload";
	}
	
	
	@RequestMapping("/upload")
	public String upload() {
		return "upload";
	}
}
