package dev.SpringBootAPI.ECommerce.dtos;

import dev.SpringBootAPI.ECommerce.validators.cpf.ValidCpf;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class UserDTO {
    private UUID id;

    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "O nome só pode conter letras e espaços.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String name;

    @Email(message = "O email deve ser válido.")
    @Size(max = 100, message = "O email deve ter no máximo 100 caracteres.")
    private String email;

    private String cpf;

    @Past(message = "A data de nascimento deve ser uma data passada.")
    private LocalDate birthDate;

    private Boolean active;

    private String url;

    @PastOrPresent(message = "A data de criação deve ser no passado ou presente.")
    private LocalDate createdAt;

    @PastOrPresent(message = "A data de atualização deve ser no passado ou presente.")
    private LocalDate updatedAt;

    private Integer userType;
}
