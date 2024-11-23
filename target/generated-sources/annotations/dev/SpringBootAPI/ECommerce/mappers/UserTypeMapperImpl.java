package dev.SpringBootAPI.ECommerce.mappers;

import dev.SpringBootAPI.ECommerce.dtos.UserTypeDTO;
import dev.SpringBootAPI.ECommerce.models.user.UserType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-23T17:00:02-0300",
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

        userTypeDTO.setId( (long) userType.getId() );
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

        if ( userTypeDTO.getId() != null ) {
            userType.setId( userTypeDTO.getId().intValue() );
        }
        userType.setName( userTypeDTO.getName() );
        userType.setDescription( userTypeDTO.getDescription() );

        return userType;
    }
}
