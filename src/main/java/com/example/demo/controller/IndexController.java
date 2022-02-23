package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	/**
	 * Register from page HTML.
	 * 
	 * @param nome
	 * @param email
	 * @param user
	 * @return
	 */
	@RequestMapping(path = "/signin", method = RequestMethod.POST)
	@GetMapping("/")
	public String writeSignInParams(
			  @RequestParam("nome")  String nome
			, @RequestParam("email") String email
			, User user)
	{
		user.setUserName(nome);
		user.setEmail(email);
		
		userService.saveUsrData(user);
		
		return "signin";
	}
	
	/**
	 * Login page from html page.
	 * 
	 * @param nome
	 * @param email
	 * @param user
	 * @return
	 */
	@RequestMapping(path = "/loginsuccess", method = RequestMethod.GET)
	@GetMapping("/signin")
	public String loginSignInPage(
			  @RequestParam("nome")  String nome
			, @RequestParam("email") String email
			, User user)
	{
		String name = user.getUserName();
		String e_mail = user.getEmail();
		
		if (nome.equals(name) && email.equals(e_mail)) {
			return "redirect:/loginsuccess";
		}
		
		return "loginsuccess";
	}
	
	/* Controller pages below */
	
	/**
	 * Sign In page of the HTML.
	 * 
	 * @return
	 */
	@RequestMapping("/signin")
	public String signin() {
		return "signin";
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
	
	@RequestMapping("/loginsuccess")
	public String loginsuccess() {
		return "loginsuccess";
	}
	
	@RequestMapping("/indexpage")
	public String indexPage() {
		return "indexpage";
	}

}
