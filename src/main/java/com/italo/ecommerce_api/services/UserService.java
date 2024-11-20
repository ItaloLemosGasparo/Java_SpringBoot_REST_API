package com.italo.ecommerce_api.services;

import com.italo.ecommerce_api.models.user.User;
import com.italo.ecommerce_api.repositories.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User createUser(@Valid User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersByName(String name) {
        return userRepository.findAllByNameContainingIgnoreCase(name);
    }

    public Optional<User> getUserByName(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User updateUser(User existingUser, User updatedUser) {
        if (updatedUser.getName() != null)
            existingUser.setName(updatedUser.getName());

        if (updatedUser.getEmail() != null)
            existingUser.setEmail(updatedUser.getEmail());

        if (updatedUser.getPassword() != null)
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));

        if (updatedUser.getCpf() != null)
            existingUser.setCpf(updatedUser.getCpf());

        if (updatedUser.getBirthDate() != null)
            existingUser.setBirthDate(updatedUser.getBirthDate());

        if (updatedUser.getPhone() != null)
            existingUser.setPhone(updatedUser.getPhone());

        if (updatedUser.getAddress() != null)
            existingUser.setAddress(updatedUser.getAddress());

        if (updatedUser.getUserType() != null)
            existingUser.setUserType(updatedUser.getUserType());

        if (updatedUser.getActive() != null)
            existingUser.setActive(updatedUser.getActive());

        return userRepository.save(existingUser);
    }
}
