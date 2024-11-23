package dev.SpringBootAPI.ECommerce.controllers;

import dev.SpringBootAPI.ECommerce.dtos.UserDTO;
import dev.SpringBootAPI.ECommerce.models.user.User;
import dev.SpringBootAPI.ECommerce.services.UserService;
import dev.SpringBootAPI.ECommerce.mappers.UserMapper;
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

    //Create User
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody User user) {
        //a criptogarfia da senha esta no userService.createUser
        User createdUser = userService.createUser(user);

        return ResponseEntity.status(201).body(userMapper.toDto(createdUser));
    }

    //Get All Users
    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<User> users = userService.getUsers();

        if (users.isEmpty())
            return ResponseEntity.noContent().build();

        List<UserDTO> userDTOs = users.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(userDTOs);
    }

    //Get User by Name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserDTO>> getUsersByName(@PathVariable String name) {
        List<User> users = userService.getUsersByName(name);

        if (users.isEmpty())
            return ResponseEntity.notFound().build();

        List<UserDTO> userDTOs = users.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(userDTOs);
    }

    //Get Single User by Name
    @GetMapping("/name/single/{name}")
    public ResponseEntity<UserDTO> getUserByName(@PathVariable String name) {
        Optional<User> user = userService.getUserByName(name);

        if (user.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userMapper.toDto(user.get()));  // Retorna o DTO
    }

    //Get Single User by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);

        if (user.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userMapper.toDto(user.get()));  // Retorna o DTO
    }

    //Update User by Email (full update)
    @PutMapping("/email")
    public ResponseEntity<UserDTO> updateUserByEmail(@Valid @RequestBody UserDTO updatedUserDTO) {
        Optional<User> existingUser = userService.getUserByEmail(updatedUserDTO.getEmail());

        if (existingUser.isEmpty())
            return ResponseEntity.notFound().build();

        User updatedUser = userMapper.toEntity(updatedUserDTO);
        User savedUser = userService.updateUser(existingUser.get(), updatedUser);
        return ResponseEntity.ok(userMapper.toDto(savedUser));  // Retorna o DTO atualizado
    }

    //Partial Update (patch)
    @PatchMapping("/email/{email}")
    public ResponseEntity<UserDTO> patchUserByEmail(@PathVariable String email, @RequestBody UserDTO partialUpdatedUserDTO) {
        Optional<User> existingUser = userService.getUserByEmail(email);

        if (existingUser.isEmpty())
            return ResponseEntity.notFound().build();

        User partialUpdatedUser = userMapper.toEntity(partialUpdatedUserDTO);
        User savedUser = userService.updateUser(existingUser.get(), partialUpdatedUser);
        return ResponseEntity.ok(userMapper.toDto(savedUser));  // Retorna o DTO atualizado
    }

    //Delete User by Email
    @DeleteMapping("/email/{email}")
    public ResponseEntity<Void> deleteUserByEmail(@PathVariable String email) {
        Optional<User> userToDelete = userService.getUserByEmail(email);

        if (userToDelete.isEmpty())
            return ResponseEntity.notFound().build();

        userService.deleteUserById(userToDelete.get().getId());
        return ResponseEntity.noContent().build();
    }
}
