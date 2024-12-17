package dev.SpringBootAPI.ECommerce.services.product;

import dev.SpringBootAPI.ECommerce.dtos.product.CategoryDTO;
import dev.SpringBootAPI.ECommerce.dtos.product.CategoryPathDTO;
import dev.SpringBootAPI.ECommerce.mappers.product.CategoryMapper;
import dev.SpringBootAPI.ECommerce.mappers.product.CategoryPathMapper;
import dev.SpringBootAPI.ECommerce.models.product.Category;
import dev.SpringBootAPI.ECommerce.repositories.product.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryPathMapper categoryPathMapper;

    //Create
    public CategoryDTO createCategory(@Valid Category category) {
        return categoryMapper.toDto(categoryRepository.save(category));
    }
    //

    //Read

    //

    public List<CategoryDTO> getCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .toList();
    }

    public List<CategoryDTO> getTopCategories() {
        return categoryRepository.findByParentCategoryIsNull().stream()
                .map(categoryMapper::toDto)
                .toList();
    }

    public List<CategoryPathDTO> getCategoryPath(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new RuntimeException("Category not found with id: " + categoryId)
        );
        return getCategoryPathIterative(category);
    }

    private List<CategoryPathDTO> getCategoryPathIterative(Category category) {
        List<Category> path = new ArrayList<>();
        while (category != null) {
            path.add(0, category); // Insere no início para construir o caminho da raiz à folha
            category = category.getParentCategory();
        }
        return path.stream().map(categoryPathMapper::toDto).toList();
    }


}
