package com.brigths.Final.Countdown.Project.service;

import com.brigths.Final.Countdown.Project.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category addCategory(Category Category);

    Category getCategoryById(Integer id);

    void deleteCategoryById(Integer id);

    Category updateCategoryById(Integer id, Category category);

    boolean existsCategoryById(Integer id);


}
