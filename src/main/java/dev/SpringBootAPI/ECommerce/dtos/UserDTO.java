package dev.SpringBootAPI.ECommerce.dtos;

import dev.SpringBootAPI.ECommerce.validators.cpf.ValidCpf;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private Long id;

    @NotNull(message = "O nome não pode ser nulo.")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "O nome só pode conter letras e espaços.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String name;

    @NotNull(message = "O email não pode ser nulo.")
    @Email(message = "O email deve ser válido.")
    @Size(max = 100, message = "O email deve ter no máximo 100 caracteres.")
    private String email;

    @NotNull(message = "O CPF não pode ser nulo.")
    @ValidCpf(message = "CPF inválido.")
    private String cpf;

    @NotNull(message = "A data de nascimento não pode ser nula.")
    @Past(message = "A data de nascimento deve ser uma data passada.")
    private LocalDate birthDate;

    private Boolean active;

    @PastOrPresent(message = "A data de criação deve ser no passado ou presente.")
    private LocalDate createdAt;

    @PastOrPresent(message = "A data de atualização deve ser no passado ou presente.")
    private LocalDate updatedAt;

    private UserTypeDTO userType;
}
