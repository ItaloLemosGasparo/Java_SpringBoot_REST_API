package com.italo.ecommerce_api.controllers;

import com.italo.ecommerce_api.models.User;
import com.italo.ecommerce_api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Insert
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(201).body(createdUser);
    }
    //Insert

    //Select
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();

        if (users.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<User>> getUsersByName(@PathVariable String name) {
        List<User> users = userService.getUsersByName(name);

        if (users.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/name/single/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name) {
        Optional<User> user = userService.getUserByName(name);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    //Select

    //Update
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
    //Update

    //Delete
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);

        if (user.isEmpty())
            return ResponseEntity.notFound().build();

        userService.deleteUserById(user.get().getId());
        return ResponseEntity.noContent().build();
    }
    //Delete
}
