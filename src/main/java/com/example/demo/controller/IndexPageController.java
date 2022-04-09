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
	
	/**
	 * Pushing to HTML page.
	 */
	@RequestMapping(path = "/indexpage", method = RequestMethod.POST)
	public String fileUploadedList( Model html ) {
		UploadController friends = new UploadController();	// bad indeed!!!!
		
		uploadList = new FileIndexUploaded();
		uploadList.UploadedValid(_LOCATION_FILE_FOR_UPLOAD + friends.getChannelFriends(), html);
		
		if (friends.getChannelFriends() == null)
			System.out.println("ERR: Failed friends is null.");
		
		return "indexpage";
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
