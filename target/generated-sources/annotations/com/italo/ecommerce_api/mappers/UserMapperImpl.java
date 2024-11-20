package com.italo.ecommerce_api.mappers;

import com.italo.ecommerce_api.dtos.UserDTO;
import com.italo.ecommerce_api.dtos.UserTypeDTO;
import com.italo.ecommerce_api.models.user.User;
import com.italo.ecommerce_api.models.user.UserType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-20T16:43:29-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUserType( userTypeToUserTypeDTO( user.getUserType() ) );
        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setCpf( user.getCpf() );
        userDTO.setBirthDate( user.getBirthDate() );
        userDTO.setPhone( user.getPhone() );
        userDTO.setActive( user.getActive() );
        userDTO.setCreatedAt( user.getCreatedAt() );
        userDTO.setUpdatedAt( user.getUpdatedAt() );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUserType( userTypeDTOToUserType( userDTO.getUserType() ) );
        user.setId( userDTO.getId() );
        user.setName( userDTO.getName() );
        user.setEmail( userDTO.getEmail() );
        user.setCpf( userDTO.getCpf() );
        user.setBirthDate( userDTO.getBirthDate() );
        user.setPhone( userDTO.getPhone() );
        user.setActive( userDTO.getActive() );
        user.setCreatedAt( userDTO.getCreatedAt() );
        user.setUpdatedAt( userDTO.getUpdatedAt() );

        return user;
    }

    protected UserTypeDTO userTypeToUserTypeDTO(UserType userType) {
        if ( userType == null ) {
            return null;
        }

        UserTypeDTO userTypeDTO = new UserTypeDTO();

        userTypeDTO.setId( userType.getId() );
        userTypeDTO.setName( userType.getName() );
        userTypeDTO.setDescription( userType.getDescription() );

        return userTypeDTO;
    }

    protected UserType userTypeDTOToUserType(UserTypeDTO userTypeDTO) {
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
