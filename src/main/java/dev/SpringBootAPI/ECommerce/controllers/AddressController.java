package dev.SpringBootAPI.ECommerce.controllers;

import dev.SpringBootAPI.ECommerce.dtos.AddressDTO;
import dev.SpringBootAPI.ECommerce.models.user.Address;
import dev.SpringBootAPI.ECommerce.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/user/{id}/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    //Create
    @PostMapping
    public ResponseEntity<AddressDTO> createAddress(@Valid @RequestBody Address address) {
        return ResponseEntity.status(201).body(addressService.createAddress(address));
    }
    //

    //Read
    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAddressesByUserId(@PathVariable UUID id) {
        List<AddressDTO> addressesDTOs = addressService.getAddressesByUserId(id);

        if (addressesDTOs.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(addressesDTOs);
    }
    //

    //Update
    @PutMapping
    public ResponseEntity<AddressDTO> updateAddress(@Valid @RequestBody AddressDTO updateAddressDTO) {
        Optional<AddressDTO> existingAddressDTO = addressService.getAddressById(updateAddressDTO.getId());

        return existingAddressDTO.map(addressDTO -> ResponseEntity.ok(addressService.updateAddress(addressDTO, updateAddressDTO)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    //

    //Delete
    @DeleteMapping
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        Optional<AddressDTO> addressDTO = addressService.getAddressById(id);

        if (addressDTO.isEmpty())
            return ResponseEntity.notFound().build();

        addressService.deleteBYId(id);
        return ResponseEntity.noContent().build();
    }
    //
}
