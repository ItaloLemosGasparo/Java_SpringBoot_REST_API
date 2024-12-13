package dev.SpringBootAPI.ECommerce.dtos.product;

import dev.SpringBootAPI.ECommerce.models.product.Category;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    private Long id;

    @Size(min = 3, max = 100, message = "The name must have between 3 and 100 characters.")

    private String name;

    @Size(max = 255, message = "The \"iconUrl\" can have 255 characters at maximum.")

    private String iconUrl;

    private Long previousCategoryId;
}
