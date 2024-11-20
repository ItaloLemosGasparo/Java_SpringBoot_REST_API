package com.italo.ecommerce_api.mappers;

import com.italo.ecommerce_api.dtos.UserDTO;
import com.italo.ecommerce_api.models.user.Address;
import com.italo.ecommerce_api.models.user.User;
import com.italo.ecommerce_api.models.user.UserType;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-20T15:17:37-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String email = null;
        String cpf = null;
        String phone = null;
        Address address = null;
        UserType userType = null;
        Boolean active = null;
        LocalDate birthDate = null;

        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        cpf = user.getCpf();
        phone = user.getPhone();
        address = user.getAddress();
        userType = user.getUserType();
        active = user.getActive();
        birthDate = user.getBirthDate();

        UserDTO userDTO = new UserDTO( id, name, email, cpf, phone, address, userType, active, birthDate );

        return userDTO;
    }

    @Override
    public User toUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setName( userDTO.getName() );
        user.setEmail( userDTO.getEmail() );
        user.setCpf( userDTO.getCpf() );
        user.setBirthDate( userDTO.getBirthDate() );
        user.setPhone( userDTO.getPhone() );
        user.setAddress( userDTO.getAddress() );
        user.setUserType( userDTO.getUserType() );
        user.setActive( userDTO.getActive() );

        return user;
    }
}
