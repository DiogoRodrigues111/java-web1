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

	public static final String LOCATION_PATH_DIR = "src/main/resources/static";
	public static File listFilesFromPath;

	@NonNull
	private static Object fileFormater() throws NullPointerException {
		File fileObject = new File(LOCATION_PATH_DIR);
		File[] objectsFiles = fileObject.listFiles();

		for (File _it : objectsFiles) {
			listFilesFromPath = _it;
			System.out.println(listFilesFromPath);
			return listFilesFromPath;
		}

		String value_repl = LOCATION_PATH_DIR.replace(
				LOCATION_PATH_DIR, // oldValue
				listFilesFromPath.getName());

		return value_repl;
	}
	
	@RequestMapping("/")
	public String index(ModelMap map) {
		map.addAttribute("filenames", fileFormater());
		return "index";
	}
}
