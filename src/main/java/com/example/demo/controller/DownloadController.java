package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.download.FileDownloader;

@Controller
public class DownloadController {
	
	public static final String _LOCATION_FILE_FOR_UPLOAD
		= "src/main/resources/static/uploaded/";
	
	/**
	 * Download file with extensions.
	 * 
	 * With Apache.Common.io
	 * 
	 * @param http
	 * 	URL for download.
	 * @return
	 * 	Self page html.
	 */
	@RequestMapping(path = "/download", method = RequestMethod.POST)
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
	
	@RequestMapping("/download")
	public String download() {
		return "download";
	}
}
