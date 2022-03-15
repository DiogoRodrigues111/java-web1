package com.example.demo.download;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class FileDownloader extends FileSelector {

	/**
	 * Check URL and put the value on Apache.Common.io.
	 * 
	 * @param url
	 * 	URL the download.
	 * 
	 * @param dst
	 * 	Where save file.
	 * 
	 * @throws IOException
	 */
	public void checkURL(URL url, File dst) throws IOException {
		
		if (url == null)
			throw new RuntimeException("Values not be null, Url null.");
		
		setFileName(dst);
		setUrlValue(url);
		
		FileUtils.copyURLToFile(url, dst);
	}
}
