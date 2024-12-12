package dev.SpringBootAPI.ECommerce.dtos.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.UUID;

@Data
public class PhoneDTO {

    private Long id;

    @Pattern(regexp = "^\\d{2}$", message = "The DDD must be exactly 2 digits")
    private String ddd;

    @Pattern(regexp = "^\\d{8,9}$", message = "The phone number must have 8 or 9 digits")
    private String number;

    private boolean confirmed = false;

    private UUID userId;
}
