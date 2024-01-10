package dev.neel.ProductService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import dev.neel.ProductService.dtos.ExceptionDto;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException){

        System.out.println("Not found exception happen");
        return new ResponseEntity<>(
                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    private ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundException(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
        System.out.println("Array Index Out of bound exception");
        return new ResponseEntity<>(
                new ExceptionDto(HttpStatus.NOT_FOUND, arrayIndexOutOfBoundsException.getMessage()),
                HttpStatus.NO_CONTENT
        );
    }
}