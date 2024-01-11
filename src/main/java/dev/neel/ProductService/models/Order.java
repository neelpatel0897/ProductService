package dev.neel.ProductService.models;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "orders")
@Getter
@Setter
public class Order extends BaseModel {

    @ManyToMany()
    @JoinTable(
        name = "products_orders",
        joinColumns =@JoinColumn(name = "orders_id"),
        inverseJoinColumns = @JoinColumn(name = "products_id")
    )       
    private List<Product> product;
}