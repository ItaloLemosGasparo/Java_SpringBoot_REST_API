package dev.SpringBootAPI.ECommerce.services;

import dev.SpringBootAPI.ECommerce.dtos.PhoneDTO;
import dev.SpringBootAPI.ECommerce.mappers.PhoneMapper;
import dev.SpringBootAPI.ECommerce.models.user.Phone;
import dev.SpringBootAPI.ECommerce.repositories.PhoneRepository;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    @Autowired
    PhoneMapper phoneMapper;

    @Autowired
    EntityManager entityManager;

    //Create
    public PhoneDTO createPhone(@Valid PhoneDTO phoneDTO) {
        return phoneMapper.toDTO(phoneRepository.save(phoneMapper.toEntity(phoneDTO)));
    }
    //

    //Read
    public List<PhoneDTO> findAllByUserId(UUID id) {
        return phoneRepository.findAllByUserId(id).stream().map(phoneMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<PhoneDTO> findById(Long id) {
        return phoneRepository.findById(id).map(phoneMapper::toDTO);
    }
    //

    //Update
    public PhoneDTO updatePhone(PhoneDTO existingPhoneDTO, PhoneDTO updatePhoneDTO) {
        Phone existingPhone = phoneMapper.toEntity(existingPhoneDTO);

        if (updatePhoneDTO.getDdd() != null)
            existingPhone.setDdd(updatePhoneDTO.getDdd());

        if (updatePhoneDTO.getNumber() != null)
            existingPhone.setNumber(updatePhoneDTO.getNumber());

        entityManager.merge(existingPhone);

        return phoneMapper.toDTO(phoneRepository.save(existingPhone));
    }

    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }
    //

    //Delete
    //
}
