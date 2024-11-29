package dev.SpringBootAPI.ECommerce.mappers;

import dev.SpringBootAPI.ECommerce.models.user.Phone;
import dev.SpringBootAPI.ECommerce.dtos.PhoneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // O componente será gerenciado pelo Spring (injeção de dependência)
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    PhoneDTO phoneToPhoneDTO(Phone phone);

    Phone phoneDTOToPhone(PhoneDTO phoneDTO);
}
