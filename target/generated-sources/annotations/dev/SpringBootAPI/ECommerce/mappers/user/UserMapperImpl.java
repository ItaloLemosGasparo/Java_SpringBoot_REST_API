package dev.SpringBootAPI.ECommerce.mappers.user;

import dev.SpringBootAPI.ECommerce.dtos.UserDTO;
import dev.SpringBootAPI.ECommerce.models.user.User;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-05T19:12:33-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private UserTypeMapper userTypeMapper;

    @Override
    public UserDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setCpf( user.getCpf() );
        userDTO.setBirthDate( user.getBirthDate() );
        userDTO.setActive( user.getActive() );
        userDTO.setCreatedAt( user.getCreatedAt() );
        userDTO.setUpdatedAt( user.getUpdatedAt() );
        userDTO.setUserType( userTypeMapper.toDto( user.getUserType() ) );

        userDTO.setUrl( "http://localhost:8080/api/user/" + user.getId() );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setName( userDTO.getName() );
        user.setEmail( userDTO.getEmail() );
        user.setCpf( userDTO.getCpf() );
        user.setBirthDate( userDTO.getBirthDate() );
        user.setUserType( userTypeMapper.toEntity( userDTO.getUserType() ) );
        user.setActive( userDTO.getActive() );
        user.setCreatedAt( userDTO.getCreatedAt() );
        user.setUpdatedAt( userDTO.getUpdatedAt() );

        return user;
    }
}
