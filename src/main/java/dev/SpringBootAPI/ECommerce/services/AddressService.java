package dev.SpringBootAPI.ECommerce.services;

import dev.SpringBootAPI.ECommerce.dtos.AddressDTO;
import dev.SpringBootAPI.ECommerce.mappers.AddressMapper;
import dev.SpringBootAPI.ECommerce.models.user.Address;
import dev.SpringBootAPI.ECommerce.repositories.AddressRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    EntityManager entityManager;

    //Create
    public AddressDTO createAddress(@Valid Address address) {
        return addressMapper.toDto(addressRepository.save(address));
    }
    //

    //Read
    public Optional<AddressDTO> getAddressById(Long id) {
        return addressRepository.findById(id).map(addressMapper::toDto);
    }

    public List<AddressDTO> getAddressesByUserId(UUID userId) {
        return addressRepository.findAllByUserId(userId).stream().map(addressMapper::toDto).collect(Collectors.toList());
    }
    //

    //Update
    @Transactional
    public AddressDTO updateAddress(AddressDTO existingAddressDTO, @Valid AddressDTO updateAddressDTO) {
        Address existingAddress = addressMapper.toEntity(existingAddressDTO);

        if (updateAddressDTO.getStreet() != null)
            existingAddress.setStreet(updateAddressDTO.getStreet());

        if (updateAddressDTO.getNumber() != null)
            existingAddress.setStreet(updateAddressDTO.getNumber());

        if (updateAddressDTO.getNumber() != null)
            existingAddress.setStreet(updateAddressDTO.getNumber());

        if (updateAddressDTO.getNumber() != null)
            existingAddress.setStreet(updateAddressDTO.getNumber());

        if (updateAddressDTO.getNumber() != null)
            existingAddress.setStreet(updateAddressDTO.getNumber());

        if (updateAddressDTO.getNumber() != null)
            existingAddress.setStreet(updateAddressDTO.getNumber());

        if (updateAddressDTO.getNumber() != null)
            existingAddress.setStreet(updateAddressDTO.getNumber());

        if (updateAddressDTO.getNumber() != null)
            existingAddress.setStreet(updateAddressDTO.getNumber());

        // Força a sincronização da entidade e do banco de dados para garantir que o PreUpdate sejá chamado
        entityManager.merge(existingAddress);

        return addressMapper.toDto(addressRepository.save(existingAddress));
    }
    //

    //Delete
    public void deleteBYId(Long id) {
        addressRepository.deleteById(id);
    }
    //
}
