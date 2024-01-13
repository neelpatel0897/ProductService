package dev.neel.ProductService.services;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import dev.neel.ProductService.dtos.GenericProductDto;


@Service("SelfStoreProductServiceImpl")
@Primary
public class SelfStoreProductServiceImpl implements ProductService{

    
    @Override
    public GenericProductDto getProductById(Long id) {
        
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProductById'");
    }

    @Override
    public GenericProductDto updateProductById(GenericProductDto genericProductDto, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProductById'");
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        // TODO Auto-generated method stub
        return null;
        
    }
    
}