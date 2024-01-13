package dev.neel.ProductService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel{
    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category")    
    List<Product> products;
}