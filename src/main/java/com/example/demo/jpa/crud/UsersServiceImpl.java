package com.example.demo.jpa.crud;

import com.example.demo.jpa.Users;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Users service, implementation the Services Users.
 */
@Service
@RequestMapping
public class UsersServiceImpl implements UsersRepository {

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Save data's of the users.
     *
     * @param users
     *  User to save.
     *
     * @return
     *  Save values.
     */
    @Override
    public Users saveData(Users users) {
        return usersRepository.saveData(users);
    }

    /**
     * Read values the users.
     *
     * @return
     *  Reader values.
     */
    @Override
    public List<Users> fetchUsers() {
        return (List<Users>) usersRepository.findAll();
    }

    /**
     * Update data's of the user.
     *
     * @param users
     *  Users data
     *
     * @param id
     *  Id the Users.
     *
     * @return
     *  Change values, after changes values with your updates.
     *  Returns save of data's.
     */
    @Override
    public Users updateData(Users users, Long id) {
        Users usr = usersRepository.findById(id).get();

        if (Objects.nonNull(users.getFirstName()) && !"".equalsIgnoreCase(users.getFirstName()))
            usr.setFirstName( users.getFirstName() );

        if (Objects.nonNull(users.getPassword()) && !"".equalsIgnoreCase(users.getPassword()))
            usr.setPassword(users.getPassword());

        return usersRepository.saveData( usr );
    }

    /**
     * Delete user by Id.
     *
     * @param id
     *  Id the user.
     */
    @Override
    public void deleteData(Long id) {
        usersRepository.deleteById( id );
    }

    //** Overrides not implemented ** .

    @Override
    public <S extends Users> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Users> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Users> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Users> findAll() {
        return null;
    }

    @Override
    public Iterable<Users> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Users entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Users> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
