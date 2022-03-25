package com.example.demo.controller.login;

import com.example.demo.jpa.entity.User;

import org.springframework.beans.factory.annotation.Autowired;

public class StaticLogin extends User {
    
    @Autowired
    public static String userStaticNomeLogin;
    @Autowired
    public static String userStaticEmailLogin;
    @Autowired
    private User user;

    /**
     * Simple instance this contructors.
     */
    public StaticLogin() {
        // create User instance.
        user = this;

        // get memory address.
        userStaticNomeLogin = userName;
        userStaticEmailLogin = email;

        // use that values.
        setEmail( userStaticEmailLogin );
        setUserName( userStaticNomeLogin );
    }
}
