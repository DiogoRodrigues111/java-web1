package com.example.demo;

import java.io.File;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Index page controller
 *
 * Take an @see Controller.
 */
@Controller
public class IndexController {

	/**
	 * Location of the static folder path, it's contains all file supported for website app.
	 */
	public static final String LOCATION_PATH_DIR = "src/main/resources/static/";

	/**
	 * List of the files.
	 */
	public static File listFilesFromPath;

	/**
	 * Get file formats from an iterator, and show in @see ModelMap.
	 *
	 * This is for add in  @see index function how to attribute.
	 *
	 * @throws NullPointerException
	 * 	Take it for null pointer exception, in iterator of the files.
	 */
	@NonNull
	public void index(ModelMap map) throws NullPointerException {
		File fileObject = new File(LOCATION_PATH_DIR);
		File[] objectsFiles = fileObject.listFiles();

		for (File _it : objectsFiles) {
			map.addAttribute("FILE_NAME", replaceValue(_it));
			System.out.println(_it);
		}
	}

	/**
	 * Index page of the HTML.
	 *
	 * @return
	 * 	Page html.
	 */
	@RequestMapping("/")
	public String index() {

		return "index";
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
