package dev.SpringBootAPI.ECommerce.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthDate;
    private String phone;
    private Boolean active;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private UserTypeDTO userType;
}