package dev.SpringBootAPI.ECommerce.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PhoneDTO {

    private Long id;

    @NotNull(message = "O DDD não pode ser nulo.")
    @Pattern(regexp = "^\\d{2}$", message = "O DDD deve ter exatamente 2 dígitos.")
    private String ddd;

    @NotNull(message = "O número de telefone não pode ser nulo.")
    @Pattern(regexp = "^\\d{8,9}$", message = "O número de telefone deve ter entre 8 e 9 dígitos.")
    private String number;

    private Long userId;
}
