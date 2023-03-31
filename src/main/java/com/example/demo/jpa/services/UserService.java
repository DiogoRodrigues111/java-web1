package com.example.demo.jpa.services;

import com.example.demo.jpa.entity.User;

import java.util.List;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

//@Service
//@Configuration
public interface UserService {

    /**
     * Save
     *
     * @param user
     * @return
     */
    User saveUsrData(User user);

    /**
     * Read
     *
     * @return
     */
    List<User> fetchUserList();

    /**
     * Update
     *
     * @param user
     * @param id
     * @return
     */
    User updateUsrData(User user, Long id);

    /**
     * Delete
     *
     * @param id
     */
    void deleteUsrByIdData(Long id);

    /**
     * Check if user exist
     */
    boolean checkIfUserExists(String usr);
}
