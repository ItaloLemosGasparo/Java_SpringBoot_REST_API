package com.italo.ecommerce_api.mappers;

import com.italo.ecommerce_api.dtos.UserDTO;
import com.italo.ecommerce_api.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);
}
