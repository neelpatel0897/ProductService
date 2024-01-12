package dev.neel.ProductService.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mp_mentor")
public class Mentor_mp extends User_mp {
    private double avgRating;
}