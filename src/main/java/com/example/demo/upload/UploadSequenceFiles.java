package com.example.demo.upload;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Upload Sequence routine.
 * 
 * @author Diogo R. Roessler (c) 2022.
 *
 */
public class UploadSequenceFiles extends FilesUpload {

	public UploadSequenceFiles() {
		
	}
	
	public UploadSequenceFiles(String dir, File file) {
		setPathDirectory(dir);
		setFileToUpload(file);
	}
	
	/**
	 * Create file system.
	 * 
	 * Put the File Upload to folder.
	 * 
	 * Don't forget the @param put "/" slash to hardcode string.
	 * 
	 * @param dir
	 * 	Directory for upload, don't forget it put "/" slash to hardcode string.
	 * 
	 * @return
	 * 	always false.
	 */
	public boolean createFileSystem(String dir) {
		/* Create file on file system. */
		try {
			FileWriter fs = new FileWriter(new File(dir + getFileToUpload()));
			Files.createFile(Paths.get(new URI(getFileToUpload().getName())));
			
			// check if success or failed.
			System.out.printf("Failed to create file system with -1 in file system returns : %s", ( fs == null ));
			System.out.printf("Create file system with 0 in file system returns : %s", ( fs != null ));
			
			fs.close();
		}
		catch(IOException file_ex) {
			file_ex.printStackTrace();
		}
		catch(URISyntaxException uri_ex) {
			uri_ex.printStackTrace();
		}
		
		return false;
	}
}
