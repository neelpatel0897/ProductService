package dev.neel.ProductService.services;

import java.util.List;

import dev.neel.ProductService.dtos.GenericProductDto;
import dev.neel.ProductService.exceptions.NotFoundException;

public interface ProductService {

    GenericProductDto getProductById(Long id) throws NotFoundException;

    List<GenericProductDto> getAllProducts() throws NotFoundException;

    GenericProductDto deleteProductById(Long id);

    GenericProductDto updateProductById(GenericProductDto genericProductDto,Long id);

    GenericProductDto createProduct(GenericProductDto genericProductDto);

    
}