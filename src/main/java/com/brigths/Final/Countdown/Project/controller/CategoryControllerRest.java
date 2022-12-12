package com.brigths.Final.Countdown.Project.controller;

import com.brigths.Final.Countdown.Project.model.Category;
import com.brigths.Final.Countdown.Project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryControllerRest {

    private CategoryService categoryService;

    @Autowired
    public CategoryControllerRest(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //get category list
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        try {
            List<Category> categories = categoryService.getAllCategories();

            if(categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //get one category by id
    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Integer id){
        Category category = categoryService.getCategoryById(id);

        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    //create new category
    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory (@RequestBody Category category){

        try {
            Category category1 = categoryService.addCategory(
                    new Category(
                            category.getName(),
                            category.getDescription())
            );
            return new ResponseEntity<>(category1, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //delete one category by id
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<HttpStatus> deleteCategoryById(@PathVariable("id") Integer id){
        try {
            categoryService.deleteCategoryById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update category info
    @PutMapping("/categories/{id}") // PUT in REST API
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Integer id, @RequestBody Category category) {
        Category category1 = categoryService.updateCategoryById(id, category);
        if(category1 != null ) {
            return new ResponseEntity<>(categoryService.addCategory(category1), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
