package dev.neel.ProductService.inheritancedemo.mappedsuperclass;



import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mp_student")
public class Student_mp extends User_mp{
    private double psp;
    private double attandence;

}