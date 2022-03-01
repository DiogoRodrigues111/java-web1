package com.example.demo.download;

import java.io.File;
import java.net.URL;

public class FileSelector {
	private File FileName;
	
	private URL UrlValue;

	/**
	 * @return the fileName
	 */
	public File getFileName() {
		return FileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(File fileName) {
		FileName = fileName;
	}

	/**
	 * @return the urlValue
	 */
	public URL getUrlValue() {
		return UrlValue;
	}

	/**
	 * @param urlValue the urlValue to set
	 */
	public void setUrlValue(URL urlValue) {
		UrlValue = urlValue;
	}
	
	
}
