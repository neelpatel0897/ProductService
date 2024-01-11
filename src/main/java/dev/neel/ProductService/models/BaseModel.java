package dev.neel.ProductService.models;


import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public class BaseModel {
    
    @Id        
    @UuidGenerator    
    @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false, unique = true)
    private UUID uuid;    
}