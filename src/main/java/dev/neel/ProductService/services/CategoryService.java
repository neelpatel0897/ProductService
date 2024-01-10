package dev.neel.ProductService.services;

import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import dev.neel.ProductService.dtos.GenericCategoryDto;

public interface CategoryService {

    List<GenericCategoryDto> getAllCategories();
    
    GenericCategoryDto getCategory(String category);


}