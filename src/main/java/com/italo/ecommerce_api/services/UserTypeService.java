package com.italo.ecommerce_api.services;

import com.italo.ecommerce_api.models.user.UserType;
import com.italo.ecommerce_api.repositories.UserTypeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService {
    @Autowired
    UserTypeRepository userTypeRepository;

    public UserType createUserType(@Valid UserType userType) {
        return userTypeRepository.save(userType);
    }
}
