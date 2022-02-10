package com.example.demo.controller;

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
	 * Index page of the HTML.
	 *
	 * @return
	 * 	Page html.
	 */
	@RequestMapping("/")
	public String index() {

		return "index";
	}

}
