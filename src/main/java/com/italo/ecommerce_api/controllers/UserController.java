package com.italo.ecommerce_api.controllers;

import com.italo.ecommerce_api.dtos.UserDTO;
import com.italo.ecommerce_api.models.User;
import com.italo.ecommerce_api.services.UserService;
import com.italo.ecommerce_api.mappers.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    //Insert
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(201).body(createdUser);
    }
    //Insert

    //Select
    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<User> users = userService.getUsers();

        if (users.isEmpty())
            return ResponseEntity.noContent().build();

        List<UserDTO> userDTOs = users.stream()
                .map(user -> userMapper.toUserDTO(user))
                .collect(Collectors.toList());

        return ResponseEntity.ok(userDTOs);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserDTO>> getUsersByName(@PathVariable String name) {
        List<User> users = userService.getUsersByName(name);

        if (users.isEmpty())
            return ResponseEntity.notFound().build();

        List<UserDTO> userDTOs = users.stream()
                .map(user -> userMapper.toUserDTO(user))
                .collect(Collectors.toList());

        return ResponseEntity.ok(userDTOs);
    }

    @GetMapping("/name/single/{name}")
    public ResponseEntity<UserDTO> getUserByName(@PathVariable String name) {
        Optional<User> user = userService.getUserByName(name);

        if (user.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userMapper.toUserDTO(user.get()));
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);

        if (user.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userMapper.toUserDTO(user.get()));
    }
    //Select

    //Update
    @PutMapping("/email/{email}")
    public ResponseEntity<User> updateUserByEmail(@PathVariable String email, @Valid @RequestBody UserDTO updatedUser) {
        Optional<User> existingUser = userService.getUserByEmail(email);

        if (existingUser.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userService.updateUser(existingUser.get(), userMapper.toUser(updatedUser)));
    }

    @PatchMapping("/email/{email}")
    public ResponseEntity<User> patchUserByEmail(@PathVariable String email, @RequestBody UserDTO partialUpdatedUser) {
        Optional<User> existingUser = userService.getUserByEmail(email);

        if (existingUser.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userService.updateUser(existingUser.get(), userMapper.toUser(partialUpdatedUser)));
    }
    //Update

    //Delete
    @DeleteMapping("/email/{email}")
    public ResponseEntity<Void> deleteUserByEmail(@PathVariable String email) {
        Optional<User> userToDelete = userService.getUserByEmail(email);

        if (userToDelete.isEmpty())
            return ResponseEntity.notFound().build();

        userService.deleteUserById(userToDelete.get().getId());
        return ResponseEntity.noContent().build();
    }
    //Delete
}
