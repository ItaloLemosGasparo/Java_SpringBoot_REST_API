package dev.SpringBootAPI.ECommerce.mappers.product;

import dev.SpringBootAPI.ECommerce.dtos.product.CategoryPathDTO;
import dev.SpringBootAPI.ECommerce.models.product.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryPathMapper {
    CategoryPathMapper INSTANCE = Mappers.getMapper(CategoryPathMapper.class);

    CategoryPathDTO toDto(Category category);
}
