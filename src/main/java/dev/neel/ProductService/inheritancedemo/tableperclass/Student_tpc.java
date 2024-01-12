package dev.neel.ProductService.inheritancedemo.tableperclass;



import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_student")
public class Student_tpc extends User_tpc{
    private double psp;
    private double attandence;

}