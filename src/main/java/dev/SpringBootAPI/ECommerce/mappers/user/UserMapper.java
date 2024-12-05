package dev.SpringBootAPI.ECommerce.mappers.user;

import dev.SpringBootAPI.ECommerce.dtos.UserDTO;
import dev.SpringBootAPI.ECommerce.models.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = UserTypeMapper.class)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "url", expression = "java(\"http://localhost:8080/api/user/\" + user.getId())")
    UserDTO toDto(User user);

    User toEntity(UserDTO userDTO);
}