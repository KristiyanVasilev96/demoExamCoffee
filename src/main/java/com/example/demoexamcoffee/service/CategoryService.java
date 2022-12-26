package com.example.demoexamcoffee.service;

import com.example.demoexamcoffee.model.entity.Category;
import com.example.demoexamcoffee.model.entity.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
