package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.annotation.DontUse;
import com.example.demo.download.FileDownloader;
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
	
	/*
	@RequestMapping("/indexpage")
	public String doMakeFileIt() {
		
		loaded = new FileLoaded();
		
		listFiles = new ListFiles(
				listFiles.makeFile(),
				doingMultipart(loaded.getFileUploaded(), _LOCATION_FILE_FOR_UPLOAD));
		
		return "indexpage";
	} */
	
	@RequestMapping(path = "/indexpage", method = RequestMethod.POST)
	public String fileDownload(@RequestParam("getfile") String http) {
		Random randomNameFile = new Random();
		FileDownloader downloader = new FileDownloader();
		
		try {
			downloader.checkURL(new URL(http), new File(_LOCATION_FILE_FOR_UPLOAD + randomNameFile.nextInt() + ".jpg"));
		} catch (IOException io) {
			io.printStackTrace();
		}
		
		return "indexpage";
	}
	
	@RequestMapping("/indexpage")
	public String indexPage() {
		return "indexpage";
	}
}
