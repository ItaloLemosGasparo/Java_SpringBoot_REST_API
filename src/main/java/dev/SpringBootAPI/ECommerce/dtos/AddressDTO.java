package dev.SpringBootAPI.ECommerce.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class AddressDTO {

    private Integer id;

    @NotNull(message = "O CEP não pode ser nulo.")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 00000-000.")
    private String zipCode;

    @NotNull(message = "O logradouro não pode ser nulo.")
    @Size(min = 3, max = 255, message = "O logradouro deve ter entre 3 e 255 caracteres.")
    private String street;

    @Size(max = 100, message = "O complemento deve ter no máximo 100 caracteres.")
    private String complement;

    @NotNull(message = "O número não pode ser nulo.")
    @Size(max = 6, message = "O número deve ter no máximo 6 caracteres.")
    private String number;

    @NotNull(message = "O bairro não pode ser nulo.")
    @Size(min = 3, max = 255, message = "O bairro deve ter entre 3 e 255 caracteres.")
    private String neighborhood;

    @NotNull(message = "A cidade não pode ser nula.")
    @Size(min = 3, max = 150, message = "A cidade deve ter entre 3 e 150 caracteres.")
    private String city;

    @NotNull(message = "O estado/UF não pode ser nulo.")
    @Pattern(regexp = "^[A-Z]{2}$", message = "O estado/UF deve ser composta por duas letras maiúsculas.")
    private String state;

    private UUID userId;
}
