package com.example.demo.jpa.crud;

import com.example.demo.jpa.Users;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersControllerTest {

    private static UsersController user;

    @Test
    void assertForInsertValues(Users controller) {
        user.saveUser(controller);
        System.out.println(user.toString());
        assert(user == null);
    }
}
