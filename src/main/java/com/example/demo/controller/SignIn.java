package com.example.demo.controller;

import com.example.demo.controller.login.StaticLogin;
import com.example.demo.jpa.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignIn {
    
    /**
	 * Login page from HTML page.
	 * 
	 * @param nome
	 * @param email
	 * @param user
	 * @return
	 */
	@RequestMapping(path = "/signin", method = RequestMethod.GET)
	public String loginSignInPage(
			  @RequestParam("nome")  String nome
			, @RequestParam("email") String email
			, User user)
	{
		StaticLogin login = new StaticLogin();

		if (login.userName.equals(nome) && login.email.equals(email)) {
			return "redirect:/loginsuccess";
		} else if (!login.userName.equals(nome) && !login.email.equals(email)) {
			return "redirect:/failed";
		}
		
		return "signin";
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
}
