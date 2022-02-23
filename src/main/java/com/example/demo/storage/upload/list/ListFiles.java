package com.example.demo.storage.upload.list;

import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Builder;
import lombok.Getter;

import java.io.File;

@Getter
@Builder
public class ListFiles {

    /**
     * Location of the static folder path, it's contains all file supported for website app.
     */
    public static final String LOCATION_PATH_DIR = "src/main/resources/static/";

    /**
     * List of the files.
     */
    public static File listFilesFromPath;

	/* Getters and Setters */
	
    /**
     * Get file name with path.
     */
	public String fileNames;
    
	public ListFiles(String fileNames) {
		this.fileNames = fileNames;
	}

	public String getFileNames() {
		return fileNames;
	}

	public void setFileNames(String fileNames) {
		this.fileNames = fileNames;
	}
    
    /**
     * Get file formats from an iterator, and show in @see ModelMap.
     *
     * This is for add in  @see index function how to attribute.
     *
     * @throws NullPointerException
     * 	Take it for null pointer exception, in iterator of the files.
     */
    @NonNull
    @GetMapping("/indexpage")
    public String foreach(Model map) throws NullPointerException {
        File fileObject = new File(LOCATION_PATH_DIR);
        File[] objectsFiles = fileObject.listFiles();

        for (File _it : objectsFiles) {
            map.addAttribute("foreach_fs", replaceValue(_it));
            System.out.println( _it );
        }
        
        return "indexpage";
    }

    /**
     * Replace all values the iterator.
     *
     * @param it
     * 	Iterator list
     *
     * @return
     * 	It's self, returns the iterator.
     */
    @NonNull
    private Object replaceValue(Object it) {
        if (it == null)
            return LOCATION_PATH_DIR.replace(LOCATION_PATH_DIR, "");

        return it;
    }
}
