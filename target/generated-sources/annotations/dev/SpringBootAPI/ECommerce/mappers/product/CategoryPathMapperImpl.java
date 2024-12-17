package dev.SpringBootAPI.ECommerce.mappers.product;

import dev.SpringBootAPI.ECommerce.dtos.product.CategoryPathDTO;
import dev.SpringBootAPI.ECommerce.models.product.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-16T19:43:40-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class CategoryPathMapperImpl implements CategoryPathMapper {

    @Override
    public CategoryPathDTO toDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryPathDTO categoryPathDTO = new CategoryPathDTO();

        return categoryPathDTO;
    }
}
