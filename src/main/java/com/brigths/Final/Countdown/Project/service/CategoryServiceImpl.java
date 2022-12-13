package com.brigths.Final.Countdown.Project.service;

import com.brigths.Final.Countdown.Project.model.Category;
import com.brigths.Final.Countdown.Project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    //get Categories
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    //get one Category
    @Override
    public Category getCategoryById(Integer id) {
        Optional<Category> optional = categoryRepository.findById(id);
        Category category = null;

        if (optional.isPresent()) {
            category = optional.get();
        } else {
            throw new RuntimeException("Category not found with id: " + id);
        }
        return category;
    }

    //add one category
    @Override
    public Category addCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    //delete one Category
    @Override
    public void deleteCategoryById(Integer id) {
        boolean exists = this.categoryRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Category with id " + id + " was not found.");
        }
        this.categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategoryById(Integer id, Category category) {

        Category categoryData = getCategoryById(id);
        if(categoryData != null) {
            categoryData.setName(category.getName());
            categoryData.setDescription(category.getDescription());

            return categoryData;
        }
        return null;
    }

    @Override
    public boolean existsCategoryById(Integer id) {
        return categoryRepository.existsById(id);
    }

}
