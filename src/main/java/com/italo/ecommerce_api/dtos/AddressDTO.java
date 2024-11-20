package com.italo.ecommerce_api.dtos;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 dígitos.")
    private String zipCode;
    private Long userId;
}
