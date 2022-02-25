package com.example.demo.upload;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * Upload Sequence routine.
 * 
 * @author Diogo R. Roessler (c) 2022.
 *
 */
public class UploadSequenceFiles extends FilesUpload {

	public UploadSequenceFiles() {
		
	}
	
	/**
	 * Instance for Upload Files.
	 * 
	 * @param dir
	 * 	Parameter mandatory.
	 * 
	 * @param file
	 * 	Parameter mandatory.
	 */
	public UploadSequenceFiles(String dir, MultipartFile file) {
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
	public boolean createFileSystem(String dir, String file) {
		
		/* Create file on file system. */
		try {
			byte buffer[] = getFileToUpload().getBytes();
			
			FileOutputStream fos = new FileOutputStream(dir + file);
			fos.write( buffer );
			
			// check if success or failed.
			System.out.printf("File created with 0 in file system returns : %s \n", ( fos != null ));
			
			fos.close();
		}
		catch(IOException file_ex) {
			file_ex.printStackTrace();
		}
		
		return false;
	}
}
