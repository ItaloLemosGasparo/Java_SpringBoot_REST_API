package dev.SpringBootAPI.ECommerce.services;

import dev.SpringBootAPI.ECommerce.models.user.User;
import dev.SpringBootAPI.ECommerce.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
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

    @Autowired
    private EntityManager entityManager;

    //Create
    @Transactional
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
    //

    //Read
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    //

    //Update
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

        entityManager.merge(existingUser); // Garante que a entidade está sincronizada
        entityManager.flush(); // Força a sincronização no banco de dados

        return userRepository.save(existingUser);
    }
    //

    //Delete
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    //
}