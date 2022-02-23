package com.example.demo.upload;

import org.springframework.web.multipart.MultipartFile;

public class FilesUpload {

	private String PathDirectory;
	
	private MultipartFile FileToUpload;

	/**
	 * @return the pathDirectory
	 */
	public String getPathDirectory() {
		return PathDirectory;
	}

	/**
	 * @param pathDirectory the pathDirectory to set
	 */
	public void setPathDirectory(String pathDirectory) {
		PathDirectory = pathDirectory;
	}

	/**
	 * @return the fileToUpload
	 */
	public MultipartFile getFileToUpload() {
		return FileToUpload;
	}

	/**
	 * @param fileToUpload the fileToUpload to set
	 */
	public void setFileToUpload(MultipartFile fileToUpload) {
		FileToUpload = fileToUpload;
	}
	
	
}
