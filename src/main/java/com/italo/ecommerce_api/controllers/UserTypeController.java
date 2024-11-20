package com.italo.ecommerce_api.controllers;

import com.italo.ecommerce_api.dtos.UserDTO;
import com.italo.ecommerce_api.dtos.UserTypeDTO;
import com.italo.ecommerce_api.mappers.UserTypeMapper;
import com.italo.ecommerce_api.models.user.User;
import com.italo.ecommerce_api.models.user.UserType;
import com.italo.ecommerce_api.services.UserTypeService;
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
