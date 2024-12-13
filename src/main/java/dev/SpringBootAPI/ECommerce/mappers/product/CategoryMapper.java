package dev.SpringBootAPI.ECommerce.mappers.product;

import dev.SpringBootAPI.ECommerce.dtos.product.CategoryDTO;
import dev.SpringBootAPI.ECommerce.models.product.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO toDto(Category category);

    Category toEntity(CategoryDTO categoryDTO);
}
