package dev.neel.ProductService.controllers;

import org.springframework.web.bind.annotation.RestController;

import dev.neel.ProductService.dtos.GenericCategoryDto;
import dev.neel.ProductService.services.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/products")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(@Qualifier("FakeStoreCategoryService") CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public void getAllCategories(){

    }

    @GetMapping("/category/{name}")    
    public GenericCategoryDto getCategory(@PathVariable("name")String category){
            return categoryService.getCategory(category);
    }
    
}