package com.example.demoexamcoffee.service.impl;

import com.example.demoexamcoffee.model.entity.Category;
import com.example.demoexamcoffee.model.entity.CategoryNameEnum;
import com.example.demoexamcoffee.repository.CategoryRepository;
import com.example.demoexamcoffee.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        Category category = new Category();
                        category.setName(categoryNameEnum);

                        switch (categoryNameEnum) {
                            case Drink -> category.setNeededTime(1);
                            case Coffee -> category.setNeededTime(2);
                            case Cake -> category.setNeededTime(10);
                            case Other -> category.setNeededTime(5);
                        }
                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
