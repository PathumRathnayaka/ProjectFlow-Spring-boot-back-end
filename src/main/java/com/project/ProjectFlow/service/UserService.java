package com.project.ProjectFlow.service;

import com.project.ProjectFlow.dto.impl.MemberDto;
import com.project.ProjectFlow.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public ResponseEntity<User> saveUser(MemberDto memberDto);

    ResponseEntity<List<User>> getUserAll();


    ResponseEntity<User> getUserById(String id);

    ResponseEntity<User> updateUser(String id, MemberDto memberDto);

    ResponseEntity<String> deleteUser(String id);
}
