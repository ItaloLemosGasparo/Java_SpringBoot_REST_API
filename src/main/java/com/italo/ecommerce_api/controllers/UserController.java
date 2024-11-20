package com.italo.ecommerce_api.controllers;

import com.italo.ecommerce_api.models.User;
import com.italo.ecommerce_api.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        logger.info("Creating user with email: {}", user.getEmail());

        User createdUser = userService.createUser(user);

        logger.info("User created successfully with ID: {}", createdUser.getId());
        
        return ResponseEntity.status(201).body(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        logger.info("Fetching all users...");
        List<User> users = userService.getUsers();

        if (users.isEmpty()) {
            logger.warn("No users found");
            return ResponseEntity.noContent().build();
        }

        logger.info("Fetched {} users", users.size());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{email}")
    public ResponseEntity<User> updateUserByEmail(@PathVariable String email, @Valid @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.getUserByEmail(email);

        if (existingUser.isEmpty())
            return ResponseEntity.notFound().build();

        User updated = userService.updateUser(existingUser.get(), updatedUser);
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{email}")
    public ResponseEntity<User> patchUserByEmail(@PathVariable String email, @RequestBody User partialUpdate) {
        Optional<User> existingUser = userService.getUserByEmail(email);

        if (existingUser.isEmpty())
            return ResponseEntity.notFound().build();

        User updatedUser = userService.updateUser(existingUser.get(), partialUpdate);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);

        if (user.isEmpty())
            return ResponseEntity.notFound().build();

        userService.deleteUserById(user.get().getId());
        return ResponseEntity.noContent().build();
    }
}
