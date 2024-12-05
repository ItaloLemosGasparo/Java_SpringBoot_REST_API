package dev.SpringBootAPI.ECommerce.services;

import dev.SpringBootAPI.ECommerce.dtos.AddressDTO;
import dev.SpringBootAPI.ECommerce.mappers.user.AddressMapper;
import dev.SpringBootAPI.ECommerce.models.user.Address;
import dev.SpringBootAPI.ECommerce.repositories.AddressRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
    public AddressDTO createAddress(Address address) {
        return addressMapper.toDto(addressRepository.save(address));
    }
    //

    //Read
    public Optional<AddressDTO> getAddressById(Integer id) {
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

        if (updateAddressDTO.getZipCode() != null)
            existingAddress.setZipCode(updateAddressDTO.getZipCode());

        if (updateAddressDTO.getComplement() != null)
            existingAddress.setComplement(updateAddressDTO.getComplement());

        if (updateAddressDTO.getNumber() != null)
            existingAddress.setNumber(updateAddressDTO.getNumber());

        if (updateAddressDTO.getNeighborhood() != null)
            existingAddress.setNeighborhood(updateAddressDTO.getNeighborhood());

        if (updateAddressDTO.getCity() != null)
            existingAddress.setCity(updateAddressDTO.getCity());

        if (updateAddressDTO.getState() != null)
            existingAddress.setState(updateAddressDTO.getState());

        entityManager.merge(existingAddress);

        return addressMapper.toDto(addressRepository.save(existingAddress));
    }
    //

    //Delete
    public void deleteBYId(Integer id) {
        addressRepository.deleteById(id);
    }
    //
}
