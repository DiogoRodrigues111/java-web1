package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("/")
    @PostMapping
    public String login(@RequestParam("user") String user, @RequestParam("pass") String password) {

        return "index";
    }
}
