package com.example.demo.jpa.crud;

import com.example.demo.jpa.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User controller contains all definitions.
 */
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * Save user data values.
     *
     * @param users
     *  Users
     * @return
     *  Save new data's values.
     */
    @PostMapping("/users")
    public Users saveUser(@RequestBody Users users) {
        return usersService.saveData(users);
    }

    /**
     * Read data values
     *
     * @return
     *  Reader user values.
     */
    @GetMapping("/users")
    public List<Users> fetchUser() {
        return usersService.fetchUsers();
    }

    /**
     * Update values of the user data's.
     *
     * @param users
     *  Users self.
     *
     * @param id
     *  Id of the user.
     *
     * @return
     *  Update values data's.
     */
    @PutMapping("/users/{id}")
    public Users updateUser(
            @RequestBody Users users
            , @PathVariable("id") Long id
    ) {
        return usersService.updateData(users, id);
    }

    /**
     * Delete user values by Id.
     *
     * @param id
     *  Id for delete.
     *
     * @return
     *  Successful in the case granted.
     */
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        usersService.deleteById(id);
        return "User DELETED with success";
    }
}
