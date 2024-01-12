package dev.neel.ProductService.inheritancedemo.singletable;



import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

@Getter
@Setter
@Entity(name = "st_student")
@DiscriminatorValue(value = "2")
public class Student_st extends User_st{
    private double psp;
    private double attandence;

}