package dev.SpringBootAPI.ECommerce.mappers.product;

import dev.SpringBootAPI.ECommerce.dtos.product.CategoryPathDTO;
import dev.SpringBootAPI.ECommerce.models.product.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryPathMapper {
    CategoryPathMapper INSTANCE = Mappers.getMapper(CategoryPathMapper.class);

    //@Mapping(source = "parentCategory.id", target = "parentId")
    CategoryPathDTO toDto(Category category);

    //@Mapping(target = "parentCategory", expression = "java(categoryPathDTO.getParentId() != null ? new Category(categoryPathDTO.getParentId()) : null)")
    //Category toEntity(CategoryPathDTO categoryPathDTO);
}
