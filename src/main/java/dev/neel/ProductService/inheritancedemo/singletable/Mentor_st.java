package dev.neel.ProductService.inheritancedemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

@Getter
@Setter
@Entity(name = "st_mentor")
@DiscriminatorValue(value = "3")
public class Mentor_st extends User_st {
    private double avgRating;
}