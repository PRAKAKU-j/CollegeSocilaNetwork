package com.capgemini.controller;

import com.capgemini.entity.UserLogin;
import com.capgemini.repo.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api")
@RequestMapping({"/user","/api"})
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {


    @Autowired
    private LoginRepository repo;


    @PostMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<?> loginUser(@RequestBody UserLogin userData){
        System.out.println(userData);
        UserLogin user=repo.findByUserid(userData.getUserid());
        if(user.getPassword().equals(userData.getPassword()))
            return ResponseEntity.ok(user);
        return (ResponseEntity<?>) ResponseEntity.badRequest();
    }
}
