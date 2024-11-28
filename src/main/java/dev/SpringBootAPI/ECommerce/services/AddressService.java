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

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    EntityManager entityManager;

    //Create
    public Address createAddress(@Valid Address address) {
        return addressRepository.save(address);
    }
    //

    //Read
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public List<Address> getAddressesByUserId(Long userId) {
        return addressRepository.findAllByUserId(userId);
    }
    //

    //Update
    @Transactional
    public Address updateAddress(Address existingAddress, @Valid AddressDTO updateAddressDTO) {
        Address updateAddress = addressMapper.toEntity(updateAddressDTO);

        if (updateAddress.getStreet() != null)
            existingAddress.setStreet(updateAddress.getStreet());

        if (updateAddress.getNumber() != null)
            existingAddress.setStreet(updateAddress.getNumber());

        if (updateAddress.getNumber() != null)
            existingAddress.setStreet(updateAddress.getNumber());

        if (updateAddress.getNumber() != null)
            existingAddress.setStreet(updateAddress.getNumber());

        if (updateAddress.getNumber() != null)
            existingAddress.setStreet(updateAddress.getNumber());

        if (updateAddress.getNumber() != null)
            existingAddress.setStreet(updateAddress.getNumber());

        if (updateAddress.getNumber() != null)
            existingAddress.setStreet(updateAddress.getNumber());

        if (updateAddress.getNumber() != null)
            existingAddress.setStreet(updateAddress.getNumber());

        if (updateAddress.getUser() != null)
            existingAddress.setUser(updateAddress.getUser());

        // Força a sincronização da entidade e do banco de dados para garantir que o PreUpdate sejá chamado
        entityManager.merge(existingAddress);
        entityManager.flush();

        return addressRepository.save(existingAddress);
    }
    //

    //Delete

    //
}
