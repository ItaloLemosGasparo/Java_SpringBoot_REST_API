package com.italo.ecommerce_api.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Embeddable
public class Address {
    @NotNull(message = "O logradouro não pode ser nulo.")
    @Size(min = 3, max = 255, message = "O logradouro deve ter entre 3 e 255 caracteres.")
    private String street;

    @NotNull(message = "O número não pode ser nulo.")
    private String number;

    private String complement;

    @NotNull(message = "O bairro não pode ser nulo.")
    private String neighborhood;

    @NotNull(message = "A cidade não pode ser nula.")
    private String city;

    @NotNull(message = "O estado não pode ser nulo.")
    private String state;

    @NotNull(message = "O CEP não pode ser nulo.")
    @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 dígitos.")
    private String zipCode;

}
