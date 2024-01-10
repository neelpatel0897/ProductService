package dev.neel.ProductService.thirdpartyclient.services;

import java.util.List;

import dev.neel.ProductService.dtos.GenericProductDto;
import dev.neel.ProductService.exceptions.NotFoundException;
import dev.neel.ProductService.thirdpartyclient.dtos.FakeStoreProductDto;

public interface ThirdPartyClientService {
    FakeStoreProductDto getProductById(Long id) throws NotFoundException;

    List<FakeStoreProductDto> getAllProducts() throws NotFoundException;

    FakeStoreProductDto deleteProductById(Long id);

    FakeStoreProductDto updateProductById(GenericProductDto genericProductDto,Long id);

    FakeStoreProductDto createProduct(GenericProductDto genericProductDto);
}