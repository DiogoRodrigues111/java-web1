package com.example.demo.jpa.services;

import com.example.demo.jpa.entity.User;
import com.example.demo.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private EntityManager sqlUserManager;

    @Override
    public User saveUsrData(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUsrData(User user, Long id) {
        User userdb = userRepository.findById(id).get();

        if (Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())) {
            userdb.setUserName(user.getUserName());
        }

        if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
            userdb.setEmail(user.getEmail());
        }

        return userRepository.save(userdb);
    }

    @Override
    public void deleteUsrByIdData(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean checkIfUserExists(String usr)
    {
        final String SQL_QUERY_FIND_USR = "SELECT COUNT(*) FROM pg_user WHERE userName =" + usr;

        Query query = sqlUserManager.createNativeQuery(SQL_QUERY_FIND_USR);
        query.setParameter(1, usr);

        int count = ((Number)query.getSingleResult()).intValue();

        return count > 0;   // ASSUME SUCCESS, ELSE RETURNS FALSE
    }
}
