package com.example.demo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private final int status;
    private final String message;
    private String stackTrace;
    private List<CustomFieldError> errors;

    @Getter
    @Setter
    @RequiredArgsConstructor
    private static class CustomFieldError {
        private final String field;
        private final String message;
        private final Object data;
    }

    public void addCustomFieldError(String field, String message, Object data){
        if(Objects.isNull(errors)){
            errors = new ArrayList<>();
        }
        errors.add(new CustomFieldError(field, message,data));
    }
}