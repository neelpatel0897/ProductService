package dev.neel.ProductService.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name="products")
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    private double price;
    @ManyToOne    
    private Category category;

}