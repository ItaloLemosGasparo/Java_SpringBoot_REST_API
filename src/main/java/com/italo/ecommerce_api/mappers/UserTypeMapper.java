package com.italo.ecommerce_api.mappers;

import com.italo.ecommerce_api.dtos.UserTypeDTO;
import com.italo.ecommerce_api.models.user.UserType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserTypeMapper {
    UserTypeMapper INSTANCE = Mappers.getMapper(UserTypeMapper.class);

    UserTypeDTO toDto(UserType userType);

    UserType toEntity(UserTypeDTO userTypeDTO);
}