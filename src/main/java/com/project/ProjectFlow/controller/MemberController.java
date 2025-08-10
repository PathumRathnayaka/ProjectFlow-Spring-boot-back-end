package com.project.ProjectFlow.controller;

import com.project.ProjectFlow.customstatuscode.ErrorStatus;
import com.project.ProjectFlow.customstatuscode.SuccessStatus;
import com.project.ProjectFlow.dto.CustomStatus;
import com.project.ProjectFlow.dto.impl.MemberDto;
import com.project.ProjectFlow.service.imple.MemberServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberServiceImpl memberService;



    @PostMapping
    public CustomStatus saveMember(@Valid @RequestBody MemberDto memberDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            // Collect first error message (you can customize to collect all)
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            String errorMessage = fieldError.getDefaultMessage();

            // Return validation error wrapped in SuccessStatus
            return new ErrorStatus(HttpStatus.BAD_REQUEST.value(), errorMessage);
        }

        // No errors, proceed normally
        return memberService.save(memberDto);
    }

    @PutMapping("/{id}")
    public CustomStatus updateMember(@Valid @RequestBody MemberDto memberDto,@PathVariable String id, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            // Collect first error message (you can customize to collect all)
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            String errorMessage = fieldError.getDefaultMessage();

            // Return validation error wrapped in SuccessStatus
            return new ErrorStatus(HttpStatus.BAD_REQUEST.value(), errorMessage);
        }
        return memberService.update(id,memberDto);

    }

    @GetMapping
    public List<MemberDto> getAllMembers(){
        return memberService.getAll();
    }


}
