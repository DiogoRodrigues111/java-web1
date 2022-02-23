package com.example.demo.upload;

import java.io.File;

public class FilesUpload {

	private String PathDirectory;
	
	private File FileToUpload;

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
	public File getFileToUpload() {
		return FileToUpload;
	}

	/**
	 * @param fileToUpload the fileToUpload to set
	 */
	public void setFileToUpload(File fileToUpload) {
		FileToUpload = fileToUpload;
	}
	
	
}
