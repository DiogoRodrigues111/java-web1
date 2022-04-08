package com.example.demo.controller;

import com.example.demo.jpa.entity.User;
import com.example.demo.jpa.services.UserService;
import com.example.demo.jpa.services.UserServiceImpl;

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
	@RequestMapping(path = "/signin", method = RequestMethod.POST)
	public String loginSignInPage(
			  @RequestParam("nome_log")  String nome
			, @RequestParam("email_log") String email
			, User usr
			, UserServiceImpl userService)
	{
//		System.out.println(nome);
//		System.out.println(email);
//		
//		usr.setUserName(nome);
//		usr.setEmail(email);
//		
//		System.out.println(usr.userName);
//		System.out.println(usr.email);
//		
//		if ((userService.fetchUserList().listIterator()) == usr) {
//			if ((usr.userName == nome) && (usr.email == email)) {
//				return "loginsuccess";
//			}
//		} else {
//			if (!(usr.userName == nome) && !(usr.email == email)) {
//				return "failed";
//			}
//		}
		
		return "indexpage";
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
	 * Load page in the case sign-in is failed.
	 * 
	 * @return
	 * 	Failed to login.
	 */
	@RequestMapping("/failed")
	public String failed() {
		return "failed";
	}
	
	/**
	 * Load page of sign-in only success.
	 * 
	 * @return
	 * 	successfully on login.
	 */
	@RequestMapping("/loginsuccess")
	public String loginsuccess() {
		return "loginsuccess";
	}
}
