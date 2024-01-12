package dev.neel.ProductService.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User_mp {
    @Id    
    private Long id;
    private String name;
    private String email;
}