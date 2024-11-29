package dev.SpringBootAPI.ECommerce.dtos;

import dev.SpringBootAPI.ECommerce.validators.cpf.ValidCpf;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private Long id;

    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String name;

    @Email(message = "O email deve ser válido.")
    @Size(max = 100, message = "O email deve ter no maximo 100 caracteres.")
    private String email;

    @ValidCpf(message = "CPF inválido.")
    private String cpf;

    @Past(message = "A data de nascimento deve ser uma data passada.")
    private LocalDate birthDate;


    private Boolean active;

    @PastOrPresent(message = "A data de criação deve ser no passado ou presente.")
    private LocalDate createdAt;

    @PastOrPresent(message = "A data de atualização deve ser no passado ou presente.")
    private LocalDate updatedAt;

    private UserTypeDTO userType;
}