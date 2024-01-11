package dev.neel.ProductService.models;

import org.hibernate.mapping.List;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel {
    private String name;    
    
}