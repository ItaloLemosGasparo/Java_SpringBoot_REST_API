package dev.SpringBootAPI.ECommerce.controllers.product;

import dev.SpringBootAPI.ECommerce.dtos.product.CategoryDTO;
import dev.SpringBootAPI.ECommerce.models.product.Category;
import dev.SpringBootAPI.ECommerce.services.product.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryCotroller {

    @Autowired
    private CategoryService categoryService;

    @PutMapping
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }
}
