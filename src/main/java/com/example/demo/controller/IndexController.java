package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@Autowired(required = true)
	private UserService userService;

	/**
	 * Register from page HTML.
	 * 
	 * @param nome
	 * @param email
	 * @param user
	 * @return
	 */
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public String registerUserSignIn(
			  @RequestParam("nome")  String nome
			, @RequestParam("email") String email
			, final User user)
	{
		user.setUserName(nome);
		user.setEmail(email);
		
		userService.saveUsrData(user);
		
		return "signin";
	}
	
	
	/**
	 * Index page of the HTML.
	 *
	 * @return
	 * 	Page HTML.
	 */
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
