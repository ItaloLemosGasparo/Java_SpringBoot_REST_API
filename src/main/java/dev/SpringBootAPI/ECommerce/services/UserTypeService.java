package dev.SpringBootAPI.ECommerce.services;

import dev.SpringBootAPI.ECommerce.dtos.UserTypeDTO;
import dev.SpringBootAPI.ECommerce.models.user.UserType;
import dev.SpringBootAPI.ECommerce.repositories.UserTypeRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTypeService {
    @Autowired
    UserTypeRepository userTypeRepository;

    @Autowired
    private EntityManager entityManager;

    //Create
    public UserType createUserType(@Valid UserType userType) {
        return userTypeRepository.save(userType);
    }
    //

    //Read
    public List<UserType> getUserTypes() {
        return userTypeRepository.findAll();
    }

    public Optional<UserType> getUserTypeById(int id) {
        return userTypeRepository.findById(id);
    }
    //

    //Update
    @Transactional
    public UserType updateUserType(UserType existingUserType, UserType updatedUserType) {
        if (updatedUserType.getName() != null)
            existingUserType.setName(updatedUserType.getName());

        if (updatedUserType.getDescription() != null)
            existingUserType.setDescription(updatedUserType.getDescription());

        entityManager.merge(existingUserType); // Garante que a entidade está sincronizada
        entityManager.flush(); // Força a sincronização no banco de dados

        return userTypeRepository.save(existingUserType);
    }
    //

    //Delete
    public void deleteById(int id) {
        userTypeRepository.deleteById(id);
    }
    //
}
