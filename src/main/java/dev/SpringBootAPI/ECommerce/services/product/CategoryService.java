package dev.SpringBootAPI.ECommerce.services.product;

import dev.SpringBootAPI.ECommerce.dtos.product.CategoryPathDTO;
import dev.SpringBootAPI.ECommerce.models.product.Category;
import dev.SpringBootAPI.ECommerce.repositories.product.CategoryRepository;
import dev.SpringBootAPI.ECommerce.mappers.product.CategoryPathMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryPathMapper categoryPathMapper;

    public List<CategoryPathDTO> getCategoryPath(Long categoryId) {
        List<Object[]> result = categoryRepository.findCategoryPath(categoryId);
        List<CategoryPathDTO> categoryPath = new ArrayList<>();

        // Mapear os dados da consulta usando o mapper
        for (Object[] row : result) {
            Long id = (Long) row[0];
            Category category = getCategory(row, id);

            categoryPath.add(categoryPathMapper.toDto(category));
        }

        return categoryPath;
    }

    private static Category getCategory(Object[] row, Long id) {
        String name = (String) row[1];
        Long previousCategoryId = (Long) row[2];

        // Criando a instância de Category e setando os valores
        Category category = new Category();
        category.setId(id);
        category.setName(name);

        // Setando a categoria anterior, se houver
        if (previousCategoryId != null) {
            Category previousCategory = new Category();
            previousCategory.setId(previousCategoryId);
            category.setPreviousCategory(previousCategory);
        }
        return category;
    }
}
