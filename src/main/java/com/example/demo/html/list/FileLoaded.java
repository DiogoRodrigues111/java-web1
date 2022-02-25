package com.example.demo.html.list;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileLoaded {

	private MultipartFile FileUploaded;
	
	private String FileDirectoryPath;
	
	private File FileReceive;

	/**
	 * @return the fileReceive
	 */
	public File getFileReceive() {
		return FileReceive;
	}

	/**
	 * @param fileReceive the fileReceive to set
	 */
	public void setFileReceive(File fileReceive) {
		FileReceive = fileReceive;
	}

	/**
	 * @return the fileUploaded
	 */
	public MultipartFile getFileUploaded() {
		return FileUploaded;
	}

	/**
	 * @param fileUploaded the fileUploaded to set
	 */
	public void setFileUploaded(MultipartFile fileUploaded) {
		FileUploaded = fileUploaded;
	}

	/**
	 * @return the fileDirectoryPath
	 */
	public String getFileDirectoryPath() {
		return FileDirectoryPath;
	}

	/**
	 * @param fileDirectoryPath the fileDirectoryPath to set
	 */
	public void setFileDirectoryPath(String fileDirectoryPath) {
		FileDirectoryPath = fileDirectoryPath;
	}
	
	
}
