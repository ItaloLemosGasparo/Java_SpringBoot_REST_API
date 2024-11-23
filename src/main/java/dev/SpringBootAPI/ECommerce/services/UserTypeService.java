package dev.SpringBootAPI.ECommerce.services;

import dev.SpringBootAPI.ECommerce.dtos.UserTypeDTO;
import dev.SpringBootAPI.ECommerce.models.user.UserType;
import dev.SpringBootAPI.ECommerce.repositories.UserTypeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService {
    @Autowired
    UserTypeRepository userTypeRepository;

    public UserType createUserType(@Valid UserType userType) {
        return userTypeRepository.save(userType);
    }

    public List<UserType> getUserTypes() {
        return userTypeRepository.findAll();
    }
}
