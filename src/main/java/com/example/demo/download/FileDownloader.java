package com.example.demo.download;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class FileDownloader extends FileSelector {

	public void checkURL(URL url, File dst) throws IOException {
		if (url == null)
			throw new RuntimeException("Values not be null, Url null.");
		
		setFileName(dst);
		setUrlValue(url);
		
		FileUtils.copyURLToFile(url, dst);
	}
}
