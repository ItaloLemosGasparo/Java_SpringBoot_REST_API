package dev.SpringBootAPI.ECommerce.services;

import dev.SpringBootAPI.ECommerce.dtos.UserTypeDTO;
import dev.SpringBootAPI.ECommerce.mappers.UserTypeMapper;
import dev.SpringBootAPI.ECommerce.models.user.UserType;
import dev.SpringBootAPI.ECommerce.repositories.UserTypeRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserTypeMapper userTypeMapper;

    //Create
    public UserTypeDTO createUserType(@Valid UserType userType) {
        return userTypeMapper.toDto(userTypeRepository.save(userType));
    }
    //

    //Read
    public List<UserTypeDTO> getUserTypes() {
        return userTypeRepository.findAll().stream().map(userTypeMapper::toDto).collect(Collectors.toList());
    }

    public Optional<UserTypeDTO> getUserTypeById(int id) {
        return userTypeRepository.findById(id).map(userTypeMapper::toDto);
    }
    //

    //Update
    @Transactional
    public UserTypeDTO updateUserType(UserTypeDTO existingUserTypeDTO, UserTypeDTO updatedUserTypeDTO) {
        UserType existingUserType = userTypeMapper.toEntity(existingUserTypeDTO);

        if (updatedUserTypeDTO.getName() != null)
            existingUserType.setName(updatedUserTypeDTO.getName());

        if (updatedUserTypeDTO.getDescription() != null)
            existingUserType.setDescription(updatedUserTypeDTO.getDescription());

        // Força a sincronização da entidade e do banco de dados para garantir que o PreUpdate sejá chamado
        entityManager.merge(existingUserType);

        return userTypeMapper.toDto(userTypeRepository.save(existingUserType));
    }
    //

    //Delete
    public void deleteById(int id) {
        userTypeRepository.deleteById(id);
    }
    //
}
