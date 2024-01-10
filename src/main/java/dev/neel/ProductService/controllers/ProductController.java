package dev.neel.ProductService.controllers;

import org.springframework.web.bind.annotation.RestController;

import dev.neel.ProductService.dtos.GenericProductDto;
import dev.neel.ProductService.exceptions.NotFoundException;
import dev.neel.ProductService.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;





@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("FakeStoreProductService")ProductService productService){
        this.productService = productService;
    }

    @GetMapping      
    public List<GenericProductDto> getAllProducts() throws NotFoundException {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")      
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException{
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.deleteProductById(id),HttpStatus.GONE);
    }

    @PutMapping("/{id}")
    public GenericProductDto updateProductById(@RequestBody GenericProductDto genericProductDto,@PathVariable Long id){
        return productService.updateProductById(genericProductDto,id);
    }

    @PostMapping        
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }

}