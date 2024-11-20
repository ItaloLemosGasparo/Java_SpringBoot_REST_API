package com.italo.ecommerce_api.mappers;

import com.italo.ecommerce_api.dtos.UserTypeDTO;
import com.italo.ecommerce_api.models.user.UserType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-20T16:43:29-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserTypeMapperImpl implements UserTypeMapper {

    @Override
    public UserTypeDTO toDto(UserType userType) {
        if ( userType == null ) {
            return null;
        }

        UserTypeDTO userTypeDTO = new UserTypeDTO();

        userTypeDTO.setId( userType.getId() );
        userTypeDTO.setName( userType.getName() );
        userTypeDTO.setDescription( userType.getDescription() );

        return userTypeDTO;
    }

    @Override
    public UserType toEntity(UserTypeDTO userTypeDTO) {
        if ( userTypeDTO == null ) {
            return null;
        }

        UserType userType = new UserType();

        userType.setId( userTypeDTO.getId() );
        userType.setName( userTypeDTO.getName() );
        userType.setDescription( userTypeDTO.getDescription() );

        return userType;
    }
}
