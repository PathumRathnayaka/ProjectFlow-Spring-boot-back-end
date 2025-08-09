package com.project.ProjectFlow.controller;

import com.project.ProjectFlow.customstatuscode.SuccessStatus;
import com.project.ProjectFlow.dto.impl.MemberDto;
import com.project.ProjectFlow.service.imple.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberServiceImpl memberService;


    @PostMapping
    public SuccessStatus saveUser(@RequestBody MemberDto memberDto){
        return memberService.save(memberDto);
    }

    /*@GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return memberService.getUserAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        return memberService.getUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id , @RequestBody MemberDto memberDto){
        return userService.updateUser(id, memberDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser (@PathVariable String id){
        return userService.deleteUser(id);
    }*/

}
