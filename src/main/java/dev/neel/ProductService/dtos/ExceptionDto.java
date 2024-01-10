package dev.neel.ProductService.dtos;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ExceptionDto {
    private HttpStatus status;
    private String message;

    public ExceptionDto(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        
    }
    
}