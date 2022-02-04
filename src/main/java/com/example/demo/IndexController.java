package com.example.demo;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	public static String LOCATION_PATH_DIR = "src/main/resources/static/";

	@NonNull
	private static Object fileFormater() {
		File fileObject = new File(LOCATION_PATH_DIR);
		File[] objectsFiles = fileObject.listFiles();

		for (File _it : objectsFiles) {
			System.out.println(_it);
		}
		
		return objectsFiles;
	}
	
	@RequestMapping("/")
	public String index(ModelMap map) {
		map.addAttribute("filenames", fileFormater());
		return "index";
	}
}
