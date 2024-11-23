package dev.SpringBootAPI.ECommerce.mappers;

import dev.SpringBootAPI.ECommerce.dtos.AddressDTO;
import dev.SpringBootAPI.ECommerce.models.user.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "user.id", target = "userId")  // Mapeia o ID do usuário
    AddressDTO toDto(Address address);

    @Mapping(source = "userId", target = "user.id")  // Mapeia o ID de volta para o objeto user
    Address toEntity(AddressDTO addressDTO);
}
