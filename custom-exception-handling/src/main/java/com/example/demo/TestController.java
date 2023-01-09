package com.example.demo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.InvalidParameterException;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("/user")
    public ResponseEntity getUser(@RequestParam long id){
        if(id == 0){
            throw new InvalidParameterException("invalid id");
        }
        return ResponseEntity.ok("");
    }

    @PostMapping("/user")
    public ResponseEntity postUser(@Valid @RequestBody User user) {
        if (user.getName().equals("maxkang")){
            throw new ComplicatedException(user);
        }
        return ResponseEntity.ok("");
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class User{
        private String name;
        private int age;
    }
}
