package dev.SpringBootAPI.ECommerce.services;

import dev.SpringBootAPI.ECommerce.models.user.UserType;
import dev.SpringBootAPI.ECommerce.repositories.UserTypeRepository;
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
