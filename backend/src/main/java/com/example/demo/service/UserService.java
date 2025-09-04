package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // CREATE
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // READ all
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // READ by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    // UPDATE
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }

    // DELETE
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
