package com.italo.ecommerce_api.dtos;

import com.italo.ecommerce_api.models.Address;
import com.italo.ecommerce_api.models.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String phone;
    private Address address;
    private UserType userType;
    private Boolean active;
    private LocalDate birthDate;
}