package dev.neel.ProductService.inheritancedemo.joinedtable;



import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_student")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student_jt extends User_jt{
    private double psp;
    private double attandence;

}