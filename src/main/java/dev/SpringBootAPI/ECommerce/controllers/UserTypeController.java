package dev.SpringBootAPI.ECommerce.controllers;

import dev.SpringBootAPI.ECommerce.dtos.UserTypeDTO;
import dev.SpringBootAPI.ECommerce.mappers.UserTypeMapper;
import dev.SpringBootAPI.ECommerce.models.user.UserType;
import dev.SpringBootAPI.ECommerce.services.UserTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userTypes")
public class UserTypeController {
    @Autowired
    UserTypeService userTypeService;

    @Autowired
    UserTypeMapper userTypeMapper;

    //Create UserType
    @PostMapping
    public ResponseEntity<UserTypeDTO> createUser(@Valid @RequestBody UserType userType) {
        UserType createdUserType = userTypeService.createUserType(userType);;
        return ResponseEntity.status(201).body(userTypeMapper.toDto(createdUserType));
    }

    //Search UserType


}
