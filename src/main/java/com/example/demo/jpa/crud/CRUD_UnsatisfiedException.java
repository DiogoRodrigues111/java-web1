package com.example.demo.jpa.crud;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class CRUD_UnsatisfiedException extends org.springframework.beans.factory.UnsatisfiedDependencyException {
    public CRUD_UnsatisfiedException(String resourceDescription, String beanName, String propertyName, String msg) {
        super(resourceDescription, beanName, propertyName, msg);
    }
}
