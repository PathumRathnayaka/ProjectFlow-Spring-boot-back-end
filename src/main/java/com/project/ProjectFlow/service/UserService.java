package com.project.ProjectFlow.service;

import com.project.ProjectFlow.dto.UserDto;
import com.project.ProjectFlow.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public ResponseEntity<User> saveUser(UserDto userDto);

    ResponseEntity<List<User>> getUserAll();


    ResponseEntity<User> getUserById(String id);

    ResponseEntity<User> updateUser(String id, UserDto userDto);

    ResponseEntity<String> deleteUser(String id);
}
