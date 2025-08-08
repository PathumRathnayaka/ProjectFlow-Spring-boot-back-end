package com.project.ProjectFlow.controller;

import com.project.ProjectFlow.dto.UserDto;
import com.project.ProjectFlow.model.User;
import com.project.ProjectFlow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return userService.getUserAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id , @RequestBody UserDto userDto){
        return userService.updateUser(id,userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser (@PathVariable String id){
        return userService.deleteUser(id);
    }

}
