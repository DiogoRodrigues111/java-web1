package com.example.demo.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.jpa.entity.User;
import com.example.demo.jpa.services.UserService;

/**
 * Index page controller
 *
 * Take an @see Controller.
 */
@Controller
public class IndexController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public String writeIndexParams(
			  @RequestParam("nome")  String nome
			, @RequestParam("email") String email
			, User user )
	{		
		user.setUserName(nome);
		user.setEmail(email);
		
		userService.saveUsrData(user);
		
		return "index";
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

}
