package com.example.demo.jpa.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * JPA Test's
 */
@SpringBootTest
public class UsersControllerTest {

    private static UsersController user;

    @Test
    void assertForInsertValues(Users controller) {
        user.saveUser(controller);
    }
}
