package dev.SpringBootAPI.ECommerce.controllers;

import dev.SpringBootAPI.ECommerce.dtos.UserDTO;
import dev.SpringBootAPI.ECommerce.dtos.UserTypeDTO;
import dev.SpringBootAPI.ECommerce.mappers.UserTypeMapper;
import dev.SpringBootAPI.ECommerce.models.user.User;
import dev.SpringBootAPI.ECommerce.models.user.UserType;
import dev.SpringBootAPI.ECommerce.services.UserTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        userType.setName(userType.getName().toUpperCase()); //Name.UpperCase

        return ResponseEntity.status(201).body(userTypeMapper.toDto(userTypeService.createUserType(userType)));
    }
    //

    //Read
    @GetMapping
    public ResponseEntity<List<UserTypeDTO>> getUserTypes(){
            List<UserType> userTypes = userTypeService.getUserTypes();

        if (userTypes.isEmpty())
            return  ResponseEntity.noContent().build();

        return ResponseEntity.ok(
                userTypes.stream()
                        .map(userTypeMapper::toDto)
                        .collect(Collectors.toList())
        );
    }
    //

    //Update
    //

    //Delete
    //
}
