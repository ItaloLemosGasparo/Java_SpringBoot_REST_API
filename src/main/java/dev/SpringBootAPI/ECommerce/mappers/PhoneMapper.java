package dev.SpringBootAPI.ECommerce.mappers;

import dev.SpringBootAPI.ECommerce.models.user.Phone;
import dev.SpringBootAPI.ECommerce.dtos.PhoneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // O componente será gerenciado pelo Spring (injeção de dependência)
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    @Mapping(source = "user.id", target = "userId")
    PhoneDTO toDTO(Phone phone);

    @Mapping(source = "userId", target = "user.id")
    Phone toEntity(PhoneDTO phoneDTO);
}
