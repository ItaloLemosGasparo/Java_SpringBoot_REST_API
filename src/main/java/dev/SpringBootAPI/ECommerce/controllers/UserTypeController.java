package dev.SpringBootAPI.ECommerce.controllers;

import dev.SpringBootAPI.ECommerce.dtos.UserTypeDTO;
import dev.SpringBootAPI.ECommerce.mappers.UserTypeMapper;
import dev.SpringBootAPI.ECommerce.models.user.UserType;
import dev.SpringBootAPI.ECommerce.services.UserTypeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/userTypes")
public class UserTypeController {
    @Autowired
    UserTypeService userTypeService;

    @Autowired
    UserTypeMapper userTypeMapper;

    //Create
    @PostMapping
    public ResponseEntity<UserTypeDTO> createUser(@Valid @RequestBody UserType userType) {
        return ResponseEntity.status(201).body(
                userTypeMapper.toDto(userTypeService.createUserType(userType))
        );
    }
    //

    //Read
    @GetMapping
    public ResponseEntity<List<UserTypeDTO>> getUserTypes() {
        List<UserType> userTypes = userTypeService.getUserTypes();

        if (userTypes.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(
                userTypes.stream()
                        .map(userTypeMapper::toDto)
                        .collect(Collectors.toList())
        );
    }
    //

    //Update
    @PutMapping
    public ResponseEntity<UserTypeDTO> updateUserType(@Valid @RequestBody UserTypeDTO updateUserTypeDTO) {
        Optional<UserType> existingUserType = userTypeService.getUserTypeById(updateUserTypeDTO.getId());

        if (existingUserType.isEmpty())
            return ResponseEntity.notFound().build();

        UserType updateUserType = userTypeMapper.toEntity(updateUserTypeDTO);
        return ResponseEntity.ok(userTypeMapper.toDto(userTypeService.updateUserType(existingUserType.get(), updateUserType)));
    }
    //

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserType(@PathVariable int id) {
        Optional<UserType> userType = userTypeService.getUserTypeById(id);

        if (userType.isEmpty())
            return ResponseEntity.notFound().build();

        userTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    //
}
