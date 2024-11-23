package dev.SpringBootAPI.ECommerce.mappers;

import dev.SpringBootAPI.ECommerce.dtos.UserDTO;
import dev.SpringBootAPI.ECommerce.models.user.User;
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