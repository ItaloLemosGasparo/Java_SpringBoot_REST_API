package dev.SpringBootAPI.ECommerce.controllers;

import dev.SpringBootAPI.ECommerce.dtos.PhoneDTO;
import dev.SpringBootAPI.ECommerce.services.PhoneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/{userId}/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    //Create
    @PutMapping
    public ResponseEntity<PhoneDTO> createPhone(@Valid @RequestBody PhoneDTO phoneDTO) {
        return ResponseEntity.ok(phoneService.createPhone(phoneDTO));
    }
    //

    //Read
    @GetMapping
    public ResponseEntity<List<PhoneDTO>> getPhones(@PathVariable UUID id) {
        List<PhoneDTO> phoneDTOs = phoneService.findAllByUserId(id);

        return phoneDTOs.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(phoneDTOs);
    }
    //

    //Update
    @PutMapping("/{phoneId}")
    public ResponseEntity<PhoneDTO> updatePhone(@PathVariable UUID userId, @PathVariable Long phoneId, @Valid @RequestBody PhoneDTO updatePhone) {
        Optional<PhoneDTO> existingPhoneDTO = phoneService.findById(phoneId);
        return existingPhoneDTO.map(phoneDTO -> ResponseEntity.ok(phoneService.updatePhone(phoneDTO, updatePhone)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    //

    //Delete
    @DeleteMapping("/{phoneId}")
    public ResponseEntity<Void> deletePhone(@PathVariable UUID userId, @PathVariable Long phoneId) {
        Optional<PhoneDTO> phoneDTO = phoneService.findById(phoneId);

        if (phoneDTO.isEmpty())
            return ResponseEntity.notFound().build();

        phoneService.deletePhone(phoneDTO.get().getId());
        return ResponseEntity.ok().build();
    }
    //
}
