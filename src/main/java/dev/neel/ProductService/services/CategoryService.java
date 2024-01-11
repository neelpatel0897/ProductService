package dev.neel.ProductService.services;

import java.util.List;

import dev.neel.ProductService.dtos.GenericCategoryDto;

public interface CategoryService {

    List<GenericCategoryDto> getAllCategories();
    
    GenericCategoryDto getCategory(String category);


}