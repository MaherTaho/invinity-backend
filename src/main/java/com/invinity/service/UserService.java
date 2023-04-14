package com.invinity.service;

import com.invinity.model.User;
import com.invinity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> addUser(User user) {
        if(userExist(user))
            return ResponseEntity.status(409).body(null);
        user.setCreateAt(System.currentTimeMillis());
        return ResponseEntity.ok().body(userRepository.save(user));
    }

    private boolean userExist(User user) {
        return getUser(user).isPresent() ;
    }
    public boolean userExist(String userId) {
        return getUserById(userId).isPresent();
    }

    public Optional<User> getUser(User user) {
        return userRepository.findByUsername(user.getUsername());
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }
}
