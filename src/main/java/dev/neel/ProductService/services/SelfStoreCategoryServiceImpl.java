package dev.neel.ProductService.services;

import org.springframework.stereotype.Service;

import dev.neel.ProductService.dtos.GenericCategoryDto;

import java.util.List;

@Service("SelfStoreCategoryServiceImpl")
public class SelfStoreCategoryServiceImpl implements CategoryService {

    @Override
    public List<GenericCategoryDto> getAllCategories() {
        return null;        
    }

    @Override
    public GenericCategoryDto getCategory(String category) {
        return null;
    }
    
}