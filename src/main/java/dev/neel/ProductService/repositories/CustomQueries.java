package dev.neel.ProductService.repositories;

public interface CustomQueries {
    String FIND_ALL_BY_TITLE = "select * from products where title = :title";
}