package com.example.demo.jpa.services;

import com.example.demo.jpa.entity.User;
import com.example.demo.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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
        return null;
    }

    @Override
    public void deleteUsrByIdData(Long id) {
        userRepository.deleteById(id);
    }
}
