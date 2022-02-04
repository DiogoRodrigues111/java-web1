package com.example.demo;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	public static final String LOCATION_PATH_DIR = "src/main/resources/static/";
	public static File listFilesFromPath;

	@NonNull
	private String fileFormater() {
		File fileObject = new File(LOCATION_PATH_DIR);
		File[] objectsFiles = fileObject.listFiles();

		for (File _it : objectsFiles) {
			listFilesFromPath = _it;
			System.out.println(listFilesFromPath);
		}

		return LOCATION_PATH_DIR;
	}
	
	@RequestMapping("/")
	public String index(ModelMap map) {
		map.addAttribute("filenames", fileFormater().replace(LOCATION_PATH_DIR, listFilesFromPath.getName()));
		return "index";
	}
}
