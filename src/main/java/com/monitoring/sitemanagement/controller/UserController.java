package com.monitoring.sitemanagement.controller;

import com.monitoring.sitemanagement.model.Project;
import com.monitoring.sitemanagement.model.User;
import com.monitoring.sitemanagement.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {

        userService.AddUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> getUsers() {

        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<?> count(){

        int user= userService.count();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
