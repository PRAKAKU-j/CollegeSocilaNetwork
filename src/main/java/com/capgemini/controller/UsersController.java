package com.capgemini.controller;

import com.capgemini.entity.Users;
import com.capgemini.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    @Autowired
    private UsersRepository repo;

    @PostMapping("/user")
    @CrossOrigin("*")
    public ResponseEntity<Users> registerUser(@RequestBody Users user){
            System.out.println("Controller called");
        return ResponseEntity.ok(repo.save(user));
    }

}
