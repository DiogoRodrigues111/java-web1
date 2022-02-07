package com.example.demo.jpa.crud;

import com.example.demo.jpa.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CRUD of the users.
 *
 * With repository Spring Data.
 */
@Repository
public interface UsersService extends CrudRepository<Users, Long> {
    /**
     * Save data's the users.
     *
     * @param users
     *  User to save.
     *
     * @return
     *  Users with new value.
     */
    Users saveData(Users users);

    /**
     * Read the data of the user
     *
     * @return
     *  List of the data.
     */
    List<Users> fetchUsers();

    /**
     * Update data's of the user with Id too.
     *
     * @param users
     *  Users data
     *
     * @param id
     *  Id the Users.
     *
     * @return
     *  Users self.
     */
    Users updateData(Users users, Long id);

    /**
     * Delete data's, for search by Id.
     *
     * @param id
     *  Id users.
     */
    void deleteData(Long id);
}
