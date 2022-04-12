package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.annotation.DontUse;
import com.example.demo.controller.UploadController.UploadNonController;
import com.example.demo.html.list.FileLoaded;
import com.example.demo.html.list.ListFiles;
import com.example.demo.upload.FileIndexUploaded;

@Controller
public class IndexPageController {

	ListFiles listFiles;
	FileLoaded loaded;
	FileIndexUploaded uploadList;
	UploadController.UploadNonController nonController;
	
	/** Location WWW path. */
	public static final String _LOCATION_FILE_FOR_UPLOAD
		= "src/main/resources/static/uploaded/";
	
	/**
	 * ****** Dont's use this *******
	 * 
	 * @param fi
	 * 	Files iterator.
	 * 
	 * @param dir
	 * 	Directory returns.
	 * 
	 * @return
	 * 	List file of the iterator.
	 */
	@DontUse
	public MultipartFile doingMultipart(@RequestParam("video_found") MultipartFile fi, String dir) {
		listFiles = new ListFiles(dir, fi);
		listFiles.setFileUploaded(fi);
		return listFiles.getFileUploaded();
	}
	
	public String _T(String obj) { return obj; }
	
	/**
	 * Pushing to HTML page.
	 */
	public String fileUploadedList( String channel, Model html ) {
		
		if (nonController.getChannelFriends() == null)
			System.out.println("WARNING: nonController.getChannelFriends is null");
		
		uploadList = new FileIndexUploaded();
		uploadList.UploadedValid(_LOCATION_FILE_FOR_UPLOAD, nonController.getChannelFriends(), html);
		
		return _T("indexpage");
	}
	
	/**
	 * Index HTML page.
	 * 
	 * @return
	 * 	Self page.
	 */
	@RequestMapping("/indexpage")
	public String indexPage() {
		return "indexpage";
	}
}
