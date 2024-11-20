package com.italo.ecommerce_api.mappers;

import com.italo.ecommerce_api.dtos.UserDTO;
import com.italo.ecommerce_api.models.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userType.id", target = "userType.id")
    UserDTO toDto(User user);

    @Mapping(source = "userType.id", target = "userType.id")
    User toEntity(UserDTO userDTO);
}