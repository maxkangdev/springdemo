package com.example.demo;

import lombok.Data;

@Data
public class ComplicatedException extends RuntimeException{

    Object data;

    public ComplicatedException(Object data) {
        this.data = data;
    }
}