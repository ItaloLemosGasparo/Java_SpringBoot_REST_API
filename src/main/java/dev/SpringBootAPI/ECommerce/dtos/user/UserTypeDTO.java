package dev.SpringBootAPI.ECommerce.dtos.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserTypeDTO {
    private Integer id;

    @Size(min = 3, max = 100, message = "The name must have between 3 and 100 characters.")
    private String name;

    @Size(min = 3, max = 255, message = "The description must have between 3 and 255 characters.")
    private String description;
}
