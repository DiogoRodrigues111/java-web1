package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.upload.FileIndexUploaded;
import com.example.demo.upload.FilesUpload;
import com.example.demo.upload.UploadSequenceFiles;

@Controller
public class UploadController {

	public class UploadNonController {
		
		public String ChannelFriends;
		
		/**
		 * @return the channelFriends
		 */
		public String getChannelFriends() {
			return ChannelFriends;
		}

		/**
		 * @param channelFriends the channelFriends to set
		 */
		public void setChannelFriends(String channelFriends) {
			ChannelFriends = channelFriends;
		}
		
		public UploadNonController(String channel) {
			setChannelFriends(channel);
		}
	}

	
	UploadSequenceFiles uploadFiles;
	FilesUpload uploadFS;
	FileIndexUploaded uploadList;
	UploadNonController nonController;
	
	/** Location WWW path. */
	public static final String _LOCATION_FILE_FOR_UPLOAD
		= "src/main/resources/static/uploaded/";

	/**
	 * Up file to server.
	 * 
	 * @param file
	 * 	MultipartFile how part of the HTML params.
	 * 
	 * @param nameFile
	 * 	Write name of the file.
	 * 
	 * @return
	 * 	Self page.
	 */
	@RequestMapping(path = "/upload", method = RequestMethod.POST)
	public String uploadFile(
			  @RequestParam("file") MultipartFile[] file
			, @RequestParam("nameText") String nameFile
			, @RequestParam("channel")  String channelName ) {
		
		uploadFS = new FilesUpload();
		uploadFS.setPathDirectory(_LOCATION_FILE_FOR_UPLOAD);
		
		FileIndexUploaded fs = new FileIndexUploaded();
		
		nonController = new UploadNonController( channelName );
		nonController.setChannelFriends( channelName );
		
		fs.createDirectoryIfNotExist( channelName );
		
		for (MultipartFile fi : file) {
			String extension = fi.getContentType()
				.replace("/", "").replace("image", ".").replace("video", ".");
			
			uploadFiles = new UploadSequenceFiles(uploadFS.getPathDirectory(), fi);
			
			if (file.length > 1) {
				uploadFiles.createFileSystem(uploadFS.getPathDirectory(), channelName + "/" + fi.getOriginalFilename());
			} else {
				uploadFiles.createFileSystem(uploadFS.getPathDirectory(), channelName + "/" + ( nameFile + extension ));
			}
		}
		
		return "redirect:/indexpage";
	}
	
	/**
	 * Register values of the progress bar.
	 * 
	 * Progress bar is localized in HTML '/upload' page.
	 * 
	 * @param values
	 * 	Values of the HTML page.
	 * 	
	 * 	Occur where file is upload a way.
	 * 
	 * @param model
	 * 	Simple pass parameter dont have any uses for this.
	 * 
	 * @return
	 * 	HTML page.
	 */
	/*
	@RequestMapping(path = "/upload", method = RequestMethod.GET)
	public String registerProgressBarValues(
			@RequestParam("progressbar") boolean value
		  , Model model) {
		
		ProgressBarValues progress = new ProgressBarValues();

		// take only values from HTML page.
		progress.setValue(progress.value);
		// simple pass the model parameter for look.
		progress.occurChanged(model);
		
		return "upload";
	}
	*/
	
	@RequestMapping("/upload")
	public String upload() {
		return "upload";
	}
}
