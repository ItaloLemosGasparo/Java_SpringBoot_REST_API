package dev.SpringBootAPI.ECommerce.controllers;

import dev.SpringBootAPI.ECommerce.dtos.AddressDTO;
import dev.SpringBootAPI.ECommerce.mappers.AddressMapper;
import dev.SpringBootAPI.ECommerce.models.user.Address;
import dev.SpringBootAPI.ECommerce.models.user.User;
import dev.SpringBootAPI.ECommerce.services.AddressService;
import dev.SpringBootAPI.ECommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @Autowired
    AddressMapper addressMapper;

    //Create
    @PostMapping
    public ResponseEntity<AddressDTO> createAddress(@Valid @RequestBody Address address) {
        return ResponseEntity.status(201).body(
                addressMapper.toDto(addressService.createAddress(address))
        );
    }
    //

    //Read
    @GetMapping("/{id}")
    public ResponseEntity<List<AddressDTO>> getAddressesByUserId(@PathVariable Long id) {
        List<Address> addresses = addressService.getAddressesByUserId(id);

        if (addresses.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(
                addresses.stream()
                        .map(addressMapper::toDto)
                        .collect(Collectors.toList())
        );
    }
    //

    //Update
    @PutMapping
    public ResponseEntity<AddressDTO> updateAddress(@Valid @RequestBody AddressDTO updateAddressDTO) {
        Optional<Address> existingAddress = addressService.getAddressById(updateAddressDTO.getId());

        if (existingAddress.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(addressMapper.toDto(addressService.updateAddress(existingAddress.get(), updateAddressDTO)));
    }
    //

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        Optional<Address> address = addressService.getAddressById(id);

        if (address.isEmpty())
            return ResponseEntity.notFound().build();

        addressService.deleteBYId(id);
        return ResponseEntity.noContent().build();
    }
    //
}
