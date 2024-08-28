package com.example.apisencilla.apisencilla.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apisencilla.apisencilla.Models.domain.User;
import com.example.apisencilla.apisencilla.Services.UserService;

import java.util.List;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "http://localhost:5173")  // Permite solicitudes desde este origen
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping("/show")
    public List<User> show() {
        List<User> users = userService.findAll();
        if (users == null) {
            throw new RuntimeException("Users not found.");
        }
        return users;
    } 

    @GetMapping("/show/{id}")
    public User showUser(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new RuntimeException("User not found.");
        }
        return user;
    }    
}