package dev.SpringBootAPI.ECommerce.models.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Password {
    @NotNull(message = "A senha não pode ser nula.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}", message = "A senha deve ter no mínimo 8 caracteres, incluindo letras, números e caracteres especiais.")
    @Column(nullable = false)
    private String password;
}
