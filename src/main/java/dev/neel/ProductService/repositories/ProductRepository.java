package dev.neel.ProductService.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.neel.ProductService.models.Product;

import java.util.UUID;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    
    @Override
    <S extends Product> S save(S entity);

    Product findByTitleEquals(String title);

    
   // @Query(value="select Product from products where Product.title = :title and Product.Price.currency = :currency")
    List<Product> findByTitleEqualsAndPrice_Price(String title, double price);

    // @Query("select Product from Product where Product.price.currency = :currency and Product.title = :naman")
    // List<Product> doSomething(String naman, String currency);


    List<Product> findByPrice_currency(String currency);

    //This one is th native MySQL query
    @Query(value=CustomQueries.FIND_ALL_BY_TITLE, nativeQuery = true)    
    List<Product> findByTitle(String title);

}