package com.example.demo.controller;

import com.example.demo.jpa.entity.User;
import com.example.demo.jpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JpaController {

    @Autowired(required = false)
    private UserService userService;

    /**
     * Save
     *
     * @param user
     * @return
     */
    @PostMapping("/add")
    public User saveUserAdd(@RequestBody User user) {
        return userService.saveUsrData(user);
    }

    /**
     * Reader value.
     *
     * @return
     */
    @GetMapping("/add")
    public List<User> fetchUserReader() {
        return userService.fetchUserList();
    }

    /**
     * Update data's.
     *
     * @param user
     * @param id
     * @return
     */
    @PutMapping("/add/{id}")
    public User
    updateUserAdd(@RequestBody User user
                , @PathVariable("id") Long id)
    {
        return userService.updateUsrData(user, id);
    }

    /**
     * Delete User By Id.
     *
     * @param id
     * @return
     */
    @DeleteMapping("/add/{id}")
    public String deleteUserAdd(@PathVariable("id") Long id) {
        userService.deleteUsrByIdData(id);
        return "Deleted with success";
    }
}
